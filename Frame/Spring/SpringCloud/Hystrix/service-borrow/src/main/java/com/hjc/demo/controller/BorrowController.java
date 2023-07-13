package com.hjc.demo.controller;

import com.hjc.demo.service.BorrowService;
import com.hjc.entity.UserBorrowDetail;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    @HystrixCommand(fallbackMethod = "onError")
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") Integer uid){
        System.out.println("开始向其他服务获取信息");
        return service.getUserBorrowDetailByUid(uid);
    }

    UserBorrowDetail onError(Integer uid){
        System.out.println("服务错误，进入备选方法！");
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}