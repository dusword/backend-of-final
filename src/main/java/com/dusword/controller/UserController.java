package com.dusword.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dusword.Mapper.UserMapper;
import com.dusword.entity.Test_user;
import com.dusword.entity.User;
import com.dusword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/findAll/{page}/{size}")
    public Page<Test_user> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return userRepository.findAll(pageable);
    }

    @PostMapping("/saveUser")
    public Test_user saveUser(@RequestBody Test_user user) {
        return userRepository.save(user);
    }

    @PostMapping("/insertUser")
    public Integer insertUser(@RequestBody User user){
        System.out.println("insert User");
        return userMapper.insert(user);
    }

    @PostMapping("/checkUser")
    public Integer checkUser(@RequestBody User user) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("user_name",user.getUserName()).eq("user_password",user.getUserPassword());
        if (userMapper.selectList(wrapper).size() !=0) {
            return 1;
        } else return 0;
    }

    @GetMapping("/selectAllUser")
    public List<User> showAllUser(){
        return userMapper.selectList(null);
    }
}
