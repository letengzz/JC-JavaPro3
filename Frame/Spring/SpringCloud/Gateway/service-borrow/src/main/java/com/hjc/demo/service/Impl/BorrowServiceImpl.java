package com.hjc.demo.service.Impl;

import com.hjc.demo.mapper.BorrowMapper;
import com.hjc.demo.service.BorrowService;
import com.hjc.entity.Book;
import com.hjc.entity.Borrow;
import com.hjc.entity.User;
import com.hjc.entity.UserBorrowDetail;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private BorrowMapper mapper;

    //RestTemplate支持多种方式的远程调用
    @Resource
    private RestTemplate restTemplate;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        //这里不用再写IP，直接写服务名称userservice
        User user = restTemplate.getForObject("http://userservice/user/" + uid, User.class);
        //这里不用再写IP，直接写服务名称bookservice
        List<Book> bookList = borrow
                .stream()
                .map(b -> restTemplate.getForObject("http://bookservice/book/" + b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}