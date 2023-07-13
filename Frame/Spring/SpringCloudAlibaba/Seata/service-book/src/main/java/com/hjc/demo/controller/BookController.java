package com.hjc.demo.controller;


import com.hjc.demo.entity.Book;
import com.hjc.demo.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {
    @Resource
    BookService service;

    //这里以RESTFul风格为例
    @RequestMapping("/book/{uid}")
    public Book findUserById(@PathVariable("uid") Integer uid){
        return service.getBookById(uid);
    }
    @RequestMapping("/book/remain/{bid}")
    public Integer bookRemain(@PathVariable("bid") Integer uid){
        return service.getRemain(uid);
    }

    @RequestMapping("/book/borrow/{bid}")
    public Boolean bookBorrow(@PathVariable("bid") Integer uid){
        Integer remain = service.getRemain(uid);
        return service.setRemain(uid,remain-1);
    }
}
