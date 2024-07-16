package com.chyuan.blog.controller;

import com.chyuan.blog.model.User;
import com.chyuan.blog.service.UserService;
import com.chyuan.blog.util.JwtUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 1:30
 * @Description: com.chyuan.blog.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
        userService.register(user);
        Map<String, Object> response = new HashMap<>();
        response.put("消息", "用户注册成功");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user, HttpSession session) {
        User loggedInUser = userService.login(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            String token = JwtUtil.generateToken(loggedInUser.getUsername());
            session.setAttribute("loggedInUser", loggedInUser);

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.getUsernameFromToken(token);
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
