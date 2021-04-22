package com.dusword.controller;

import com.alibaba.fastjson.JSONObject;
import com.dusword.Service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/predict")
public class PredictController {
    @Autowired
    PredictService predictService;

    @PostMapping("/onePic")
    public JSONObject predictPic(@RequestParam("file")MultipartFile multipartFile){
        return predictService.predictPic(multipartFile);
    }
}
