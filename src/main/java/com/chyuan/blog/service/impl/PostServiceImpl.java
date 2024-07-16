package com.chyuan.blog.service.impl;

import com.chyuan.blog.dao.PostMapper;
import com.chyuan.blog.model.Post;
import com.chyuan.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 1:19
 * @Description: com.chyuan.blog.service.impl
 * @version: 1.0
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public void createPost(Post post) {
        post.setCreated(LocalDateTime.now());
        post.setLastModified(LocalDateTime.now());
        postMapper.insertPost(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postMapper.findAllPosts();
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postMapper.findPostsByUserId(userId);
    }

    @Override
    public Post getPostById(Long postId) {
        return postMapper.findPostById(postId);
    }

    @Override
    public void updatePost(Post post) {
        post.setLastModified(LocalDateTime.now());
        postMapper.updatePost(post);
    }

    @Override
    public void deletePost(Long postId) {
        postMapper.deletePost(postId);
    }
}