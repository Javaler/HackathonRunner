package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PostDaoImpl;
import com.example.demo.entity.Post;
import com.example.demo.entity.Recruitment;
import com.example.demo.form.PostQuery;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.RecruitmentRepository;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostRepository postRepository;
    private final RecruitmentRepository recruitmentRepository;

    @PersistenceContext
    private EntityManager entityManager;
    PostDaoImpl postDaoImpl;

    @PostConstruct
    public void init() {
        postDaoImpl = new PostDaoImpl(entityManager);
    }


    @GetMapping("/")
    public ModelAndView showHome(ModelAndView mav) {

        List<Post> postList = postRepository.findAllByOrderByIdDesc();
        List<Recruitment> recruitmentList = recruitmentRepository.findAll();

        mav.setViewName("home");
        mav.addObject("postList", postList);
        mav.addObject("postQuery", new PostQuery());
        mav.addObject("recruitmentList", recruitmentList);

        return mav;
    }


    @PostMapping("/")
    public ModelAndView queryPost(@ModelAttribute PostQuery postQuery,
                                    BindingResult result,
                                    ModelAndView mav) {

        List<Post> postList = postDaoImpl.findByCriteria(postQuery);
        List<Recruitment> recruitmentList = recruitmentRepository.findAll();

        mav.setViewName("home");
        mav.addObject("postList", postList);
        mav.addObject("postQuery", postQuery);
        mav.addObject("recruitmentList", recruitmentList);

        return mav;
    }
}
