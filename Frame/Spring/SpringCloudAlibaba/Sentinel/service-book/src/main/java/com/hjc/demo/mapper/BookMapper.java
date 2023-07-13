package com.hjc.demo.mapper;


import com.hjc.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author hjc
 */
@Mapper
public interface BookMapper {
    @Select("select * from db_book where bid = #{bid}")
    Book getBookById(Integer bid);
}
