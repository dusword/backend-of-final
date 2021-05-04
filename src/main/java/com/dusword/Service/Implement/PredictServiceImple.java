package com.dusword.Service.Implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dusword.Mapper.PredictedFileMapper;
import com.dusword.Mapper.TaskMapper;
import com.dusword.Service.PredictService;
import com.dusword.entity.PredictedFile;
import com.dusword.entity.Task;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Service
public class PredictServiceImple implements PredictService {

    @Autowired
    private PredictedFileMapper predictedFileMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public JSONObject predictPic(MultipartFile multipartFile, Integer userId) {
        System.out.println("PredictService start!");
        if (userId == null) {
            userId = 0;
        }
        //文件处理部分
        File localFile = makeDir(multipartFile);
        //请求部分
        JSONObject jsonObject = httpRequest(localFile, userId);
        deleteDir(localFile);
        return jsonObject;
    }

    @Override
    public String saveMultiPic(MultipartFile multipartFile, Integer userId,String message) {
        System.out.println("PredictService start!");
        if (userId == null) {
            userId = 0;
        }
        //文件处理部分
        File localFile = makeDir(multipartFile);
        Task task = new Task();
        task.setFileName(localFile.getName());
        task.setUserId(userId);
        task.setMessage(message);
        task.setFilePath(localFile.getAbsolutePath());
        //格式化时间
        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sim.format(date);
        System.out.println(time);
        task.setCreatedTime(time);
        int isInsertSuccess = taskMapper.insert(task);
        System.out.println("is Insert Success?" + isInsertSuccess);
        if (isInsertSuccess == 1) {
            return "OK";
        }
        return "Failed!";
    }

    @Override
    public JSONObject predictTaskPic() {
        System.out.println("Start task predict");
        QueryWrapper<Task> wrapper = new QueryWrapper<>();
        wrapper.eq("is_predicted", "未完成").orderByAsc("id").last("limit 1");
        Task task = taskMapper.selectOne(wrapper);
        if (task != null) {
            System.out.println("Task id is:" + task.getId());
            File file = new File(task.getFilePath());
            JSONObject jsonObject = httpRequest(file, task.getUserId());
            if (jsonObject != null) {
                Integer predictedFileId = jsonObject.getInteger("predicted_file_id");
                task.setIsPredicted("已完成");
                task.setPredictedFileId(predictedFileId);
                taskMapper.updateById(task);
                deleteDir(file);
                return jsonObject;
            }return null;
        } return null;
    }

    /*
    递归删除tmp文件的方法
     */
    public static void deleteDir(File file) {
        //判断是否为文件夹
        if (file.isDirectory()) {
            //获取该文件夹下的子文件夹
            File[] files = file.listFiles();
            //循环子文件夹重复调用delete方法
            for (File value : files) {
                deleteDir(value);
            }
        }
        //若为空文件夹或者文件删除，File类的删除方法
        file.delete();
    }

    /**
     * 创建本地文件工具方法
     *
     * @param multipartFile
     * @return
     */
    public static File makeDir(MultipartFile multipartFile) {
        String tmpFileDir = null;
        String fileName = null;
        File dirFile = null;
        File localFile = null;
        try {
            //制作每个文件特有的目录，保证并发或重名时不出问题
            String randomFileName = UUID.randomUUID().toString();
            tmpFileDir = "D:/tmp/tmpFile/" + randomFileName;
            dirFile = new File(tmpFileDir);
            System.out.println(dirFile.getPath());
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            //MultipartFile转成File对象
            fileName = tmpFileDir + "/" + multipartFile.getOriginalFilename();
            localFile = new File(fileName);
            multipartFile.transferTo(localFile);
            System.out.println(localFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localFile;
    }

    public JSONObject httpRequest(File localFile, Integer userId) {
        OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(60000, TimeUnit.MILLISECONDS).readTimeout(60000, TimeUnit.MILLISECONDS)
                .build();
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        RequestBody body1 = RequestBody.create(MediaType.parse("multipart-formdata"), localFile);
        String picName = localFile.getName();
        System.out.println("filename is:");
        System.out.println(picName);
        // 参数分别为， 请求key ，文件名称 ， RequestBody
        requestBody.addFormDataPart("file", picName, body1).addFormDataPart("userId", userId.toString());
        String url = "http://0.0.0.0:5000/upload_image";
        Request request = new Request.Builder().url(url).post(requestBody.build()).build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            String jsonString = null;
            if (response.body() != null) {
                jsonString = response.body().string();
            }
            JSONObject jsonObject = JSON.parseObject(jsonString);
            String base64Result = jsonObject.getString("base64_result");
            Integer finalResult = jsonObject.getInteger("final_result");
            String divisionResult = null;
            if (finalResult == 0) {
                divisionResult = "阳性";
            } else
                divisionResult = "阴性";
            //格式化时间
            Date date = new Date();
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = sim.format(date);
            System.out.println(time);
            PredictedFile predictedFile = new PredictedFile();
            predictedFile.setRecordTime(time);
            predictedFile.setUserId(userId);
            predictedFile.setBase64Result(base64Result);
            predictedFile.setDivisionResult(divisionResult);
            predictedFile.setFileName(picName);
            int isInsertSuccess = predictedFileMapper.insert(predictedFile);
            jsonObject.put("predicted_file_id", predictedFile.getId());
            System.out.println("is Insert Success?" + isInsertSuccess);
            System.out.println("PredictService end!");
            System.out.println("start to delete tmp file!");
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
