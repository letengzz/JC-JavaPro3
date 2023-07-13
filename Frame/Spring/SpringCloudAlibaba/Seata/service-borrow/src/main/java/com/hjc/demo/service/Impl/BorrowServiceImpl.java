package com.hjc.demo.service.Impl;


import com.hjc.demo.client.BookClient;
import com.hjc.demo.client.UserClient;
import com.hjc.demo.entity.Book;
import com.hjc.demo.entity.Borrow;
import com.hjc.demo.entity.User;
import com.hjc.demo.entity.UserBorrowDetail;
import com.hjc.demo.mapper.BorrowMapper;
import com.hjc.demo.service.BorrowService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hjc
 */
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

    @Override
    @GlobalTransactional
    public Boolean doBorrow(Integer uid, Integer bid) {
        //这里打印一下XID看看，其他的服务业添加这样一个打印，如果一会都打印的是同一个XID，表示使用的就是同一个事务
        System.out.println(RootContext.getXID());
        //1. 判断图书和用户是否都支持借阅
        if(bookClient.bookRemain(bid) < 1) {
            throw new RuntimeException("图书数量不足");
        }
        if(userClient.userRemain(uid) < 1) {
            throw new RuntimeException("用户借阅量不足");
        }
        //2. 首先将图书的数量-1
        if(!bookClient.bookBorrow(bid)) {
            throw new RuntimeException("在借阅图书时出现错误！");
        }
        //3. 添加借阅信息
        if(mapper.getBorrow(uid, bid) != null) {
            throw new RuntimeException("此书籍已经被此用户借阅了！");
        }
        if(mapper.addBorrow(uid, bid) <= 0) {
            throw new RuntimeException("在录入借阅信息时出现错误！");
        }
        //4. 用户可借阅-1
        if(!userClient.userBorrow(uid)) {
            throw new RuntimeException("在借阅时出现错误！");
        }
        //完成
        return true;
    }
}
