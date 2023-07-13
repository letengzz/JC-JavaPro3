package com.hjc.demo.service;


import com.hjc.demo.entity.Book;
import org.springframework.stereotype.Service;

/**
 * @author hjc
 */
@Service
public interface BookService {
    Book getBookById(Integer bid);

    Integer getRemain(Integer bid);

    Boolean setRemain(Integer bid,Integer count);
}
