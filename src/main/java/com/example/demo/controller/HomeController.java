package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/")
    public ModelAndView showHome(ModelAndView mav) {

        List<Post> postList = postRepository.findAllByOrderByIdDesc();
        List<Recruitment> recruitmentList = recruitmentRepository.findAllByOrderByDeadlineAsc();

        mav.setViewName("home");
        mav.addObject("postList", postList);
        mav.addObject("postQuery", new PostQuery());
        mav.addObject("recruitmentList", recruitmentList);

        return mav;
    }

}
