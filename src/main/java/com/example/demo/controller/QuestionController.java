package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.QuestionForm;

@Controller
public class QuestionController {

	@GetMapping("/showQuestion")
	public ModelAndView showQuestion(ModelAndView mav) {
		
		mav.setViewName("questionForm");
		mav.addObject("questionForm", new QuestionForm());
		
		return mav;
	}
}
