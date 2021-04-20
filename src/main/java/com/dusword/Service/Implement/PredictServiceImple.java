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

@Service
public class PredictServiceImple implements PredictService {
    @Override
    public JSONObject predictPic(MultipartFile multipartFile){
        File file = null;
        try {
            file = multipartToFile(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (file != null) {
//            RequestBody body = RequestBody.create(MediaType.parse("multipart-formdata"), file);
            String filename = file.getName();
            System.out.println("filename is:");
            System.out.println(filename);
//            // 参数分别为， 请求key ，文件名称 ， RequestBody
//            requestBody.addFormDataPart("file", filename, body);
        }
//        String url = "http://localhost:5000/upload_image";
//        Request request = new Request.Builder().url(url).post(requestBody.build()).build();
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }
    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(Objects.requireNonNull(multipart.getOriginalFilename()));
        multipart.transferTo(convFile);
        return convFile;
    }
}
