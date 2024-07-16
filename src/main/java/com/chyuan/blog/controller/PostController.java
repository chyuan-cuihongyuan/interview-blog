package com.chyuan.blog.controller;

import com.chyuan.blog.model.Post;
import com.chyuan.blog.model.User;
import com.chyuan.blog.service.PostService;
import com.chyuan.blog.service.UserService;
import com.chyuan.blog.util.JwtUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 1:22
 * @Description: com.chyuan.blog.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/posts")
public class PostController  {
    @Autowired
    private PostService postService;


    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post, @RequestHeader("Authorization") String token, HttpSession session) {
        String username = JwtUtil.getUsernameFromToken(token);
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || !username.equals(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        post.setUserId(user.getUserId());
        postService.createPost(post);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping(params = "uid")
    public ResponseEntity<List<Post>> getPostsByUserId(@RequestParam("uid") Long userId) {
        return ResponseEntity.ok(postService.getPostsByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post, @RequestHeader("Authorization") String token, HttpSession session) {
        String username = JwtUtil.getUsernameFromToken(token);
        Post existingPost = postService.getPostById(id);
        User user = (User) session.getAttribute("loggedInUser");
        if (existingPost != null && user.getUsername().equals(username)) {
            post.setPostId(id);
            postService.updatePost(post);
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.status(403).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id, @RequestHeader("Authorization") String token, HttpSession session) {
        String username = JwtUtil.getUsernameFromToken(token);
        Post existingPost = postService.getPostById(id);
        User user = (User) session.getAttribute("loggedInUser");
        if (existingPost != null && user.getUsername().equals(username)) {
            postService.deletePost(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }
}
