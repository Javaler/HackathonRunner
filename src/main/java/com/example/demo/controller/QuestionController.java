package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Post;
import com.example.demo.form.QuestionForm;
import com.example.demo.service.PostService;
import com.example.demo.service.QuestionService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final PostService postService;

    @GetMapping("/showQuestion")
    public ModelAndView showQuestion(ModelAndView mav) {

        mav.setViewName("questionForm");
        mav.addObject("questionForm", new QuestionForm());

        return mav;
    }

    @PostMapping("/showQuestionResult")
    public ModelAndView showQuestionResult(ModelAndView mav,
            @ModelAttribute QuestionForm questionForm) {

        List<String> analysisResult = questionService.createAnalysisResult(questionForm);
        int[] hackathonScore = questionService.createHackathonScore(questionForm);
        List<Post> recommendPostList = postService.createRecommendPostList(questionForm);

        mav.setViewName("questionResult");
        mav.addObject("analysisResult", analysisResult);
        mav.addObject("hackathonScore", hackathonScore);
        mav.addObject("recommendPostList", recommendPostList);

        return mav;
    }
}
