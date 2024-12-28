package com.blog.backend.controller;

import com.blog.backend.entity.Post;
import com.blog.backend.repository.PostRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

  private final PostRepo postRepo;

  public PostController(PostRepo postRepo) {
    this.postRepo = postRepo;
  }

  // 1. Get all posts
  @GetMapping
  public List<Post> getAllPosts() {
    return postRepo.findAll();
  }

  // 2. Get a single post by ID
  @GetMapping("/{id}")
  public ResponseEntity<Post> getPostById(@PathVariable Long id) {
    Optional<Post> post = postRepo.findById(id);
    return post.map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // 3. Create a new post
  @PostMapping
  public ResponseEntity<Post> createPost(@RequestBody Post post) {
    Post savedPost = postRepo.save(post);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
  }

  // 4. Update an existing post
  @PutMapping("/{id}")
  public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
    Optional<Post> optionalPost = postRepo.findById(id);

    if (optionalPost.isPresent()) {
      Post post = optionalPost.get();
      post.setCategory(postDetails.getCategory());
      post.setTitle(postDetails.getTitle());
      post.setDate(postDetails.getDate());
      post.setImage(postDetails.getImage());
      post.setBlurb(postDetails.getBlurb());
      post.setContent(postDetails.getContent());

      Post updatedPost = postRepo.save(post);
      return ResponseEntity.ok(updatedPost);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // 5. Delete a post
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePost(@PathVariable Long id) {
    if (postRepo.existsById(id)) {
      postRepo.deleteById(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
