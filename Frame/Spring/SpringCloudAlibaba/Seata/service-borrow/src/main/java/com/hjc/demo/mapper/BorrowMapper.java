package com.hjc.demo.mapper;

import com.hjc.demo.entity.Borrow;
import feign.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hjc
 */
@Mapper
public interface BorrowMapper {
    @Select("select * from db_borrow where uid = #{uid}")
    List<Borrow> getBorrowsByUid(Integer uid);

    @Select("select * from db_borrow where bid = #{bid}")
    List<Borrow> getBorrowsByBid(Integer bid);

    @Select("select * from db_borrow where bid = #{bid} and uid = #{uid}")
    Borrow getBorrow(@Param("uid") Integer uid, @Param("bid") Integer bid);

    @Insert("insert into db_borrow(uid,bid) values (#{uid},#{bid})")
    int addBorrow(@Param("uid") Integer uid, @Param("bid") Integer bid);
}
