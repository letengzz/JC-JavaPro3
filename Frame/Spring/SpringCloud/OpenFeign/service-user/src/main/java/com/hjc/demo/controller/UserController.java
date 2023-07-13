package com.hjc.demo.controller;

import com.hjc.demo.service.UserService;
import com.hjc.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserService service;

    @Value("${server.port}")
    private String serverPort;

    //这里以RESTFul风格为例
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid){
        System.out.println("我被调用拉！服务端口=" + serverPort);
        return service.getUserById(uid);
    }
}
