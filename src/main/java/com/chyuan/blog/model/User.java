package com.chyuan.blog.model;

import java.time.LocalDateTime;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 0:55
 * @Description: com.chyuan.blog.model
 * @version: 1.0
 */
public class User {

    private Long userId;
    private String username;
    private String password;
    private String email;
    private LocalDateTime created;
    private LocalDateTime lastModified;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
}
