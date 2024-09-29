package com.codingdojo.brightideas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.brightideas.models.LoginUser;
import com.codingdojo.brightideas.models.Post;
import com.codingdojo.brightideas.models.User;
import com.codingdojo.brightideas.services.PostService;
import com.codingdojo.brightideas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private UserService userServ;

    @Autowired
    private PostService postServ;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("userId", newUser.getId());
        return "redirect:/welcome";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("userId", null);
        return "redirect:/";
    }

    @GetMapping("/welcome")
    public String welcome(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        User user = userServ.findById(userId);
        model.addAttribute("user", user);

        List<Post> posts = postServ.findAllPosts();
        posts.sort((p1, p2) -> Integer.compare(p2.getLikedBy().size(), p1.getLikedBy().size()));

        model.addAttribute("posts", posts);
        System.out.println("Number of posts: " + posts.size());
        return "dashboard.jsp";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable("id") Long userId, Model model, HttpSession session) {
        Long loggedInUserId = (Long) session.getAttribute("userId");
        if (loggedInUserId == null) {
            return "redirect:/";
        }

        User postOwner = userServ.findById(userId);
        if (postOwner == null) {
            return "redirect:/";
        }

        int totalPosts = postServ.countPostsByUser(postOwner);
        int totalLikes = postServ.countLikesForUserPosts(postOwner);

        model.addAttribute("user", postOwner);
        model.addAttribute("totalPosts", totalPosts);
        model.addAttribute("totalLikes", totalLikes);

        return "profile.jsp";
    }

    @GetMapping("/posts/{id}/likestatus")
    public String likeStatus(@PathVariable("id") Long postId, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        Post post = postServ.findPost(postId);
        if (post == null) {
            return "redirect:/welcome"; 
        }

        model.addAttribute("post", post);
        return "likestatus.jsp"; 
    }

    @PostMapping("/posts/new")
    public String createPost(@Valid @ModelAttribute Post newPost, BindingResult result, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        if (result.hasErrors()) {
            return "dashboard";
        }
        User user = userServ.findById(userId);
        if (user == null) {
            return "redirect:/";
        }
        newPost.setUser(user);
        postServ.createPost(newPost);
        return "redirect:/welcome";
    }

    @PostMapping("/posts/{id}/like")
    public String likePost(@PathVariable("id") Long postId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        User user = userServ.findById(userId);
        Post post = postServ.findPost(postId);
        postServ.likePost(post, user);
        return "redirect:/welcome";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable("id") Long postId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        postServ.deletePost(postId);
        return "redirect:/welcome";
    }
}
