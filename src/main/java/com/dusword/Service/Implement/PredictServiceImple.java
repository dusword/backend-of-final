package com.dusword.Service.Implement;

import com.alibaba.fastjson.JSONObject;
import com.dusword.Service.PredictService;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Service
public class PredictServiceImple implements PredictService {
    @Override
    public JSONObject predictPic(MultipartFile multipartFile) {
        String tmpFileDir = null;
        String fileName = null;
        File dirFile = null;
        File localFile = null;
        try {
            //制作每个文件特有的目录，保证并发或重名时不出问题
            String randomFileName = UUID.randomUUID().toString();
            tmpFileDir = "D:/tmp/tmpFile/" + randomFileName;
            dirFile = new File(tmpFileDir);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            //MultipartFile转成File对象
            fileName = tmpFileDir + "/" + multipartFile.getOriginalFilename();
            localFile = new File(fileName);
            multipartFile.transferTo(localFile);

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
            RequestBody body = RequestBody.create(MediaType.parse("multipart-formdata"), localFile);
            String picName = localFile.getName();
            System.out.println("filename is:");
            System.out.println(picName);
            // 参数分别为， 请求key ，文件名称 ， RequestBody
            requestBody.addFormDataPart("file", picName, body);
            String url = "http://0.0.0.0:5000/upload_image";
            Request request = new Request.Builder().url(url).post(requestBody.build()).build();
            try {
                Response response = client.newCall(request).execute();
                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
