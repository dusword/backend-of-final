package com.dusword.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dusword.mapper.PredictedFileMapper;
import com.dusword.mapper.TaskMapper;
import com.dusword.Service.TaskService;
import com.dusword.entity.PredictedFile;
import com.dusword.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    protected static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @GetMapping("/findTaskList/{page}/{size}/{userId}/{authority}")
    public Page<Task> findTaskList(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("userId") Integer userId, @PathVariable("authority") Integer authority) {
        if (authority == 1) {
            QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId).orderByDesc("id");
            Page<Task> requestPage = new Page<>(page, size);
            return taskService.page(requestPage, queryWrapper);
        } else if (authority == 0) {
            QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("id");
            Page<Task> requestPage = new Page<>(page, size);
            return taskService.page(requestPage, queryWrapper);
        } else
            return null;
    }

    @GetMapping("/findTaskList/{page}/{size}/{userId}/{message}/{authority}")
    public Page<Task> findTaskList(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("userId") Integer userId, @PathVariable("message") String message, @PathVariable("authority") Integer authority) {
        if (authority == 1) {
            QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId).orderByDesc("id").like("message", message);
            Page<Task> requestPage = new Page<>(page, size);
            return taskService.page(requestPage, queryWrapper);
        } else if (authority == 0) {
            QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("id").like("message", message);
            Page<Task> requestPage = new Page<>(page, size);
            return taskService.page(requestPage, queryWrapper);
        } else
            return null;
    }

    @PostMapping("/deleteTask/{predictedFileId}")
    public Integer deleteTask(@PathVariable("predictedFileId") Integer predictedFileId) {
        QueryWrapper<Task> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("predicted_file_id", predictedFileId);
        QueryWrapper<PredictedFile> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("id", predictedFileId);
        int result1 = taskMapper.delete(queryWrapper1);
        int result2 = predictedFileMapper.delete(queryWrapper2);
        if (result1 == 1) {
            logger.info("Task中predictedFileId为" + predictedFileId + "的记录删除成功");
            if (result2 == 1) {
                logger.info("PredictedFile中的Id为" + predictedFileId + "的记录删除成功");
                return 1;
            } else
                logger.info("Task记录删除成功");
            return 0;
        } else
            logger.info("PredictedFile记录删除失败");
        return 0;
    }
}
