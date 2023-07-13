package com.hjc.demo.service;

import com.hjc.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(Integer uid);
}
