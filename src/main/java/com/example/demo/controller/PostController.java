package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PostDaoImpl;
import com.example.demo.entity.Post;
import com.example.demo.form.PostForm;
import com.example.demo.form.PostQuery;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;
    PostDaoImpl postDaoImpl;

    @PostConstruct
    public void init() {
        postDaoImpl = new PostDaoImpl(entityManager);
    }


    @GetMapping("/showPostForm")
    public ModelAndView showPostForm(ModelAndView mav) {

        mav.setViewName("postForm");
        mav.addObject("postForm", new PostForm());

        return mav;
    }

    @PostMapping("/post")
    public String post(@ModelAttribute PostForm postForm) {

        Post post = postForm.toEntity();
        postRepository.saveAndFlush(post);

        return "redirect:/Post/" + post.getId();
    }

    @GetMapping("/showPostList")
    public ModelAndView showPostList(ModelAndView mav) {
        List<Post> postList = postRepository.findAllByOrderByIdDesc();

        mav.setViewName("postList");
        mav.addObject("postList", postList);
        mav.addObject("postQuery", new PostQuery());

        return mav;
    }

    @PostMapping("/queryPost")
    public ModelAndView queryPost(@ModelAttribute PostQuery postQuery,
                                    ModelAndView mav) {
        List<Post> postList = postDaoImpl.findByCriteria(postQuery);

        mav.setViewName("postList");
        mav.addObject("postList", postList);
        mav.addObject("postQuery", postQuery);

        return mav;
    }

    @GetMapping("/Post/{post_id}")
    public ModelAndView showPostDetail(ModelAndView mav,
            @PathVariable(name = "post_id") int postId) {

        try {
            Post post = postRepository.findById(postId).get();
            mav.setViewName("postDetail");
            mav.addObject("post", post);
        } catch(Exception e) {
            mav.setViewName("redirect:/");
        }

        return mav;
    }
}
