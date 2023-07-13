package com.hjc.demo.mapper;


import com.hjc.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author hjc
 */
@Mapper
public interface BookMapper {
    @Select("select * from db_book where bid = #{bid}")
    Book getBookById(Integer bid);

    @Select("select count from db_book where bid = #{bid}")
    Integer getRemain(Integer bid);

    @Update("update db_book set count = #{count} where bid = #{bid}")
    Integer serRemain(Integer bid,Integer count);
}
