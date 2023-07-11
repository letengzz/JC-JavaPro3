package com.hjc.demo.mapper;

import com.hjc.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mapper接口
 * @author hjc
 */
public interface UserMapper {
    /**
     * 查询所有学生
     * @return 所有学生
     */
    List<User> selectAllUser();

    List<User> selectAllUserLimit(@Param("from") Integer currentPageNo,@Param("pageSize") Integer pageSize);
}
