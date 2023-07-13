package com.hjc.demo.controller;

import com.hjc.demo.service.BookService;
import com.hjc.entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {
    @Resource
    BookService service;

    @Value("${key}")
    private String key;

    //这里以RESTFul风格为例
    @RequestMapping("/book/{uid}")
    public Book findUserById(@PathVariable("uid") Integer uid){
        System.out.println(key);
        return service.getBookById(uid);
    }
}
