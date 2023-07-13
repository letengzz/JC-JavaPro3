package com.hjc.demo.mapper;

import com.hjc.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author hjc
 */
@Mapper
public interface UserMapper {
    @Select("select * from db_user where uid = #{uid}")
    User getUserById(Integer uid);

    @Select("select book_count from db_user where uid = #{uid}")
    Integer getUserBookRemain(Integer uid);

    @Update("update db_user set book_count = #{count} where uid = #{uid}")
    Integer updateBookCount(Integer uid,Integer count);
}
