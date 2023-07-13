package com.hjc.demo.service.Impl;

import com.hjc.demo.mapper.UserMapper;
import com.hjc.demo.pojo.User;
import com.hjc.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hjc
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    @Override
    public User getUserById(Integer uid) {
        return mapper.getUserById(uid);
    }

    @Override
    public Integer getRemain(Integer uid) {
        return mapper.getUserBookRemain(uid);
    }

    @Override
    public Boolean setRemain(Integer uid, Integer count) {
        return mapper.updateBookCount(uid,count) > 0;
    }
}
