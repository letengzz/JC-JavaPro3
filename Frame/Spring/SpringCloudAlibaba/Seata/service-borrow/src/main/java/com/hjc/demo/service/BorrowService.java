package com.hjc.demo.service;



import com.hjc.demo.entity.UserBorrowDetail;
import org.springframework.stereotype.Service;

/**
 * @author hjc
 */
@Service
public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(Integer uid);

    Boolean doBorrow(Integer uid, Integer bid);
}
