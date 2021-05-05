package com.dusword.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dusword.Mapper.PredictedFileMapper;
import com.dusword.Mapper.TaskMapper;
import com.dusword.Service.TaskService;
import com.dusword.entity.PredictedFile;
import com.dusword.entity.Task;
import com.dusword.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    TaskService taskService;
    @Resource
    TaskMapper taskMapper;
    @Resource
    PredictedFileMapper predictedFileMapper;

    @GetMapping("/findTaskList/{page}/{size}/{userId}")
    public Page<Task> findUserList(@PathVariable("page") Integer page, @PathVariable("size") Integer size,@PathVariable("userId") Integer userId){
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).orderByDesc("id");
        Page<Task> requestPage =new Page<>(page,size);
        return taskService.page(requestPage,queryWrapper);
    }

    @PostMapping("/deleteTask/{predictedFileId}")
    public Integer deleteTask(@PathVariable("predictedFileId") Integer predictedFileId){
//        System.out.println(predictedFileId);
        QueryWrapper<Task> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("predicted_file_id",predictedFileId);
        QueryWrapper<PredictedFile> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("id",predictedFileId);
        int result1 = taskMapper.delete(queryWrapper1);
        int result2 = predictedFileMapper.delete(queryWrapper2);
//        System.out.println(result1);
//        System.out.println(result2);
        if (result1 ==1){
            if (result2 ==1){
                return  1;
            }else return 0;
        }else return 0;
    }
}
