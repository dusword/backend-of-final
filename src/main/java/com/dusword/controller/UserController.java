package com.dusword.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dusword.mapper.UserMapper;
import com.dusword.Service.UserService;
import com.dusword.entity.Test_user;
import com.dusword.entity.User;
import com.dusword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Resource
    UserService userService;

    @PostMapping("/insertUser")
    public Integer insertUser(@RequestBody User user){
        System.out.println("insert User");
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("user_name",user.getUserName());
        if (userMapper.selectList(wrapper).size() !=0) {
            return 0;
        } else{
            userMapper.insert(user);
            return 1;
        }
    }

    @PostMapping("/checkUser")
    public Integer checkUser(@RequestBody User user) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("user_name",user.getUserName()).eq("user_password",user.getUserPassword());
        try {
            user=userMapper.selectOne(wrapper);
            if (user == null){
                return 0;
            }
            return user.getUserId();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @GetMapping("/findUserList/{page}/{size}")
    public Page<User> findUserList(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<User> requestPage =new Page<>(page,size);
        return userService.page(requestPage);
    }


    /**
     * just for test
     * @return
     */
    @GetMapping("/selectAllUser")
    public List<User> showAllUser(){
        return userMapper.selectList(null);
    }
}
