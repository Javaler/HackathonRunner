package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Recruitment;
import com.example.demo.form.RecruitmentForm;
import com.example.demo.repository.RecruitmentRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RecruitmentController {

    private final RecruitmentRepository recruitmentRepository;

    @GetMapping("/showRecruitmentForm")
    public ModelAndView showRecruitmentForm(ModelAndView mav) {

        mav.setViewName("recruitmentForm");
        mav.addObject("recruitmentForm", new RecruitmentForm());

        return mav;
    }

    @PostMapping("/createRecruitment")
    public String createRecruitment(RecruitmentForm recruitmentForm){

        Recruitment recruitment = recruitmentForm.toEntity();
        recruitmentRepository.saveAndFlush(recruitment);

        return "redirect:/";
    }

    @GetMapping("/showRecruitmentList")
    public ModelAndView showRecruitmentList(ModelAndView mav) {
        List<Recruitment> recruitmentList = recruitmentRepository.findAllByOrderByDeadlineAsc();

        mav.setViewName("recruitmentList");
        mav.addObject("recruitmentList", recruitmentList);

        return mav;
    }

}
