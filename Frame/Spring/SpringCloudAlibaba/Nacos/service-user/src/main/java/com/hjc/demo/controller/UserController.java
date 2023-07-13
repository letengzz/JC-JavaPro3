package com.hjc.demo.controller;

import com.hjc.demo.pojo.User;
import com.hjc.demo.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hjc
 */
@RestController
public class UserController {
    @Resource
    UserService service;

    //这里以RESTFul风格为例
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid){
        return service.getUserById(uid);
    }
}
