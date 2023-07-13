package com.hjc.demo.service;

import com.hjc.demo.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author hjc
 */
@Service
public interface UserService {
    User getUserById(Integer uid);
}
