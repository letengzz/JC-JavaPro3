package com.hjc.demo.service.Impl;

import com.hjc.demo.client.BookClient;
import com.hjc.demo.client.UserClient;
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
    BorrowMapper mapper;

    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        User user = userClient.getUserById(uid);
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.getBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}