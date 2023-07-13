package com.hjc.demo.service;

import com.hjc.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book getBookById(Integer bid);
}