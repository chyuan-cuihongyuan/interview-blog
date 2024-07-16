package com.chyuan.blog.service.impl;

import com.chyuan.blog.dao.UserMapper;
import com.chyuan.blog.model.User;
import com.chyuan.blog.service.UserService;
import com.chyuan.blog.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 1:04
 * @Description: com.chyuan.blog.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        user.setCreated(LocalDateTime.now());
        user.setLastModified(LocalDateTime.now());
        userMapper.insertUser(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findUserByUsername(username);
        if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
