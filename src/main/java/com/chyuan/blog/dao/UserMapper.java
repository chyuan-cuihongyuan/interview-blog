package com.chyuan.blog.dao;

import com.chyuan.blog.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 1:03
 * @Description: com.chyuan.blog.dao
 * @version: 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
