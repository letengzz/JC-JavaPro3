package com.hjc.demo.client;

import com.hjc.demo.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("bookservice") //声明为userservice服务的HTTP请求客户端
public interface BookClient {
    //路径保证和其他微服务提供的一致即可
    @RequestMapping("/book/{bid}")
    Book getBookById(@PathVariable("bid") Integer bid);  //参数和返回值也保持一致

    @RequestMapping("/book/remain/{bid}")
    Integer bookRemain(@PathVariable("bid") Integer uid);

    @RequestMapping("/book/borrow/{bid}")
    boolean bookBorrow(@PathVariable("bid") Integer uid);
}