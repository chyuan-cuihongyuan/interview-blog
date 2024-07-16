package com.chyuan.blog.model;

import java.time.LocalDateTime;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 0:56
 * @Description: com.chyuan.blog.model
 * @version: 1.0
 */
public class Post {

    private Long postId;
    private String title;
    private String content;
    private Long userId;
    private LocalDateTime created;
    private LocalDateTime lastModified;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
