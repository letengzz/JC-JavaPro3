package com.hjc.demo.service.Impl;

import com.hjc.demo.mapper.BookMapper;
import com.hjc.demo.service.BookService;
import com.hjc.entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper mapper;

    @Override
    public Book getBookById(Integer uid) {
        return mapper.getBookById(uid);
    }
}
