package com.dusword.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dusword.Service.TaskService;
import com.dusword.entity.Task;
import com.dusword.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    TaskService taskService;

    @GetMapping("/findTaskList/{page}/{size}/{userId}")
    public Page<Task> findUserList(@PathVariable("page") Integer page, @PathVariable("size") Integer size,@PathVariable("userId") Integer userId){
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).orderByDesc("id");
        Page<Task> requestPage =new Page<>(page,size);
        return taskService.page(requestPage,queryWrapper);
    }
}
