package com.codingdojo.brightideas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.brightideas.models.Post;
import com.codingdojo.brightideas.models.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    int countByUser(User user);
    List<Post> findByUser(User user);
}