package com.chyuan.blog.service;

import com.chyuan.blog.model.User;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 1:04
 * @Description: com.chyuan.blog.service
 * @version: 1.0
 */
public interface UserService {
    /**
     * 注册
     * @param user
     */
    void register(User user);
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}