package com.hjc.demo.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.hjc.demo.entity.Borrow;
import com.hjc.demo.entity.User;
import com.hjc.demo.entity.UserBorrowDetail;
import com.hjc.demo.service.BorrowService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author hjc
 */
@RestController
public class BorrowController {
    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    public UserBorrowDetail findUserBorrows(@PathVariable("uid") Integer uid) {
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/borrow2/{uid}")
    UserBorrowDetail findUserBorrows2(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/blocked")
    JSONObject blocked() {
        JSONObject object = new JSONObject();
        object.put("code", 403);
        object.put("success", false);
        object.put("massage", "您的请求频率过快，请稍后再试！");
        return object;
    }

//    @RequestMapping("/test")
//    @SentinelResource(value = "test",
//            fallback = "except",    //fallback指定出现异常时的替代方案
//            exceptionsToIgnore = IOException.class)  //忽略那些异常，也就是说这些异常出现时不使用替代方案
//    public String test(){
//        throw new RuntimeException("HelloWorld！");
//    }
//
//    //替代方法必须和原方法返回值和参数一致，最后可以添加一个Throwable作为参数接受异常
//    public String except(Throwable t){
//        return t.getMessage();
//    }
//        @RequestMapping("/test")
//    @SentinelResource(value = "test",
//            fallback = "except",    //fallback指定出现异常时的替代方案
//            blockHandler = "block",
//            exceptionsToIgnore = IOException.class)  //忽略那些异常，也就是说这些异常出现时不使用替代方案
//    public String test(){
//        return "test";
//    }
//
//    //替代方法必须和原方法返回值和参数一致，最后可以添加一个Throwable作为参数接受异常
//    public String except(Throwable t){
//        return "异常了...";
//    }
//    public String block(BlockException b){
//        return "限流了...";
//    }
    @RequestMapping("/test")
    @SentinelResource("test") //注意这里需要添加@SentinelResource才可以，用户资源名称就使用这里定义的资源名称
    public String findUserBorrows2(@RequestParam(value = "a", required = false) Integer a,
                            @RequestParam(value = "b", required = false) Integer b,
                            @RequestParam(value = "c", required = false) Integer c) {
        return "请求成功！a = " + a + ", b = " + b + ", c = " + c;
    }

    @RequestMapping("/borrow3/{uid}")
    public String findUserBorrows3(@PathVariable("uid") Integer uid) throws InterruptedException {
        //暂停几秒钟线程

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            return "hello";
    }
    @RequestMapping("/borrow4/{uid}")
    @SentinelResource(value = "findUserBorrows4", blockHandler = "test")
    public UserBorrowDetail findUserBorrows4(@PathVariable("uid") Integer uid) {
        throw new RuntimeException();
    }
    public UserBorrowDetail test(Integer uid, BlockException e){
        e.printStackTrace();
        return new UserBorrowDetail(new User(), Collections.emptyList());
    }
}
