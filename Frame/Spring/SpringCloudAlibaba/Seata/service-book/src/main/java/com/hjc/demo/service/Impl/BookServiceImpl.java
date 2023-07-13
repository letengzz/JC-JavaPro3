package com.hjc.demo.service.Impl;

import com.hjc.demo.entity.Book;
import com.hjc.demo.mapper.BookMapper;
import com.hjc.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hjc
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper mapper;

    @Override
    public Book getBookById(Integer uid) {
        return mapper.getBookById(uid);
    }

    @Override
    public Integer getRemain(Integer bid) {
        return mapper.getRemain(bid);
    }

    @Override
    public Boolean setRemain(Integer bid, Integer count) {
        return mapper.serRemain(bid,count) > 0;
    }
}
