package com.blog.backend.repository;

import com.blog.backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

  List<Post> findByCategory(String category);
}
