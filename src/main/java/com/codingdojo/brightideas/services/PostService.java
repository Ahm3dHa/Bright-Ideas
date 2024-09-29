package com.codingdojo.brightideas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.brightideas.models.Post;
import com.codingdojo.brightideas.models.User;
import com.codingdojo.brightideas.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public List<Post> findAllPosts() {
        List<Post> posts = (List<Post>) postRepo.findAll();
        return posts;
    }

    public void createPost(Post post) {
        postRepo.save(post);
    }

    public Post findPost(Long id) {
        Optional<Post> optionalPost = postRepo.findById(id);
        return optionalPost.orElse(null);
    }

    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    public void likePost(Post post, User user) {
        List<User> likers = post.getLikedBy();
        if (!likers.contains(user)) {
            likers.add(user);
            postRepo.save(post);
        }
    }

    public void unlikePost(Post post, User user) {
        List<User> likers = post.getLikedBy();
        if (likers.contains(user)) {
            likers.remove(user);
            postRepo.save(post);
        }
    }

    public int countPostsByUser(User user) {
        return postRepo.countByUser(user);
    }
    
    public int countLikesForUserPosts(User user) {
        List<Post> userPosts = postRepo.findByUser(user);
        int totalLikes = 0;
        for (Post post : userPosts) {
            totalLikes += post.getLikedBy().size();
        }
        return totalLikes;
    }
    
}
