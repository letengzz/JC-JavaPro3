package com.hjc.demo.service;


import com.hjc.entity.UserBorrowDetail;
import org.springframework.stereotype.Service;

/**
 * @author hjc
 */
@Service
public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(Integer uid);
}
