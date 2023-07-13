package com.hjc.demo.controller;


import com.hjc.demo.entity.Borrow;
import com.hjc.demo.entity.UserBorrowDetail;
import com.hjc.demo.service.BorrowService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hjc
 */
@RestController
public class BorrowController {
    @Resource
    BorrowService service;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/borrow/{uid}")
    public UserBorrowDetail findUserBorrows(@PathVariable("uid") Integer uid){
        return service.getUserBorrowDetailByUid(uid);
    }


    @GetMapping("/test-load-balancer")
    public String testLoadBalancer() {
        ServiceInstance instance = loadBalancerClient.choose("userservice");
        return instance.getHost() + ":" + instance.getPort();
    }
}
