package com.hjc.demo.service;

import com.hjc.entity.UserBorrowDetail;
import org.springframework.stereotype.Service;

@Service
public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(Integer uid);
}