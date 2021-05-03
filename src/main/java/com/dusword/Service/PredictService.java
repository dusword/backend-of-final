package com.dusword.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface PredictService {
    JSONObject predictPic(MultipartFile multipartFile, Integer userId);
    String saveMultiPic(MultipartFile multipartFile, Integer userId);
    JSONObject predictTaskPic();
}
