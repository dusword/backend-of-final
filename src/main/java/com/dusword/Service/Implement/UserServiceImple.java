package com.dusword.Service.Implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dusword.Mapper.UserMapper;
import com.dusword.Service.UserService;
import com.dusword.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple extends ServiceImpl<UserMapper, User> implements UserService {
}
