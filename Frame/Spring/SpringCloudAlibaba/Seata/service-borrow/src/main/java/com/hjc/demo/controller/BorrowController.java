package com.hjc.demo.controller;


import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping("/borrow/{uid}")
    public UserBorrowDetail findUserBorrows(@PathVariable("uid") Integer uid){
        return service.getUserBorrowDetailByUid(uid);
    }
    @RequestMapping("/borrow/take/{uid}/{bid}")
    public JSONObject borrow(@PathVariable("uid") int uid,
                             @PathVariable("bid") int bid){
        service.doBorrow(uid, bid);

        JSONObject object = new JSONObject();
        object.put("code", "200");
        object.put("success", false);
        object.put("message", "借阅成功！");
        return object;
    }

}
