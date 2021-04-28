package com.dusword.controller;

import com.alibaba.fastjson.JSONObject;
import com.dusword.Mapper.PredictedFileMapper;
import com.dusword.Service.PredictService;
import com.dusword.entity.PredictedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/predict")
public class PredictController {
    @Autowired
    PredictService predictService;

    @Autowired
    PredictedFileMapper predictedFileMapper;

    @PostMapping("/onePic")
    public JSONObject predictPic(@RequestParam("file")MultipartFile multipartFile,@RequestParam("userId")Integer userId){
        return predictService.predictPic(multipartFile,userId);
    }

    @GetMapping("/selectAll")
    public List<PredictedFile> selectAllFromPredictedFile(){
        return predictedFileMapper.selectList(null);
    }
}
