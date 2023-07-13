package com.hjc.demo.service.Impl;

import com.hjc.demo.mapper.UserMapper;
import com.hjc.demo.service.UserService;
import com.hjc.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    @Override
    public User getUserById(Integer uid) {
        return mapper.getUserById(uid);
    }
}