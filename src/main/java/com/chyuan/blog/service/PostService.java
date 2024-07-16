package com.chyuan.blog.service;

import com.chyuan.blog.model.Post;

import java.util.List;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 1:18
 * @Description: com.chyuan.blog.service
 * @version: 1.0
 */
public interface PostService {
    /**
     * 创建文章
     * @param post
     */
    void createPost(Post post);
    /**
     * 获取所有文章
     * @return
     */
    List<Post> getAllPosts();
    /**
     * 获取用户所有文章
     * @param userId
     * @return
     */
    List<Post> getPostsByUserId(Long userId);
    /**
     * 获取文章
     * @param postId
     * @return
     */
    Post getPostById(Long postId);
    /**
     * 更新文章
     * @param post
     */
    void updatePost(Post post);
    /**
     * 删除文章
     * @param postId
     */
    void deletePost(Long postId);
}
