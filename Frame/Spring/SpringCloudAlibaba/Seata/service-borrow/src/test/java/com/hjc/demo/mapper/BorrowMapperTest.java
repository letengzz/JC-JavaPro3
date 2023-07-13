package com.hjc.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BorrowMapperTest {

    @Resource
    private BorrowMapper borrowMapper;
    @Test
    void addBorrow() {
        Integer integer = borrowMapper.addBorrow(2, 2);
        System.out.println("integer = " + integer);
    }
}