package com.dusword.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

public interface PredictService {
    JSONObject predictPic(MultipartFile multipartFile, Integer userId);
}
