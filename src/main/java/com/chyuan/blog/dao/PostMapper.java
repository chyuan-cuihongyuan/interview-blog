package com.chyuan.blog.dao;

import com.chyuan.blog.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16
 * @Description: com.chyuan.blog.dao
 * @version: 1.0
 */
@Mapper
public interface PostMapper {
    /**
     * 插入文章
     * @param post
     */
    void insertPost(Post post);

    /**
     * 查找所有文章
     * @return
     */
    List<Post> findAllPosts();
    /**
     * 根据用户id查询文章
     * @param userId
     * @return
     */
    List<Post> findPostsByUserId(@Param("userId") Long userId);
    /**
     * 根据文章id查询文章
     * @param postId
     * @return
     */
    Post findPostById(@Param("postId") Long postId);
    /**
     * 更新文章
     * @param post
     */
    void updatePost(Post post);
    /**
     * 删除文章
     * @param postId
     */
    void deletePost(@Param("postId") Long postId);
}