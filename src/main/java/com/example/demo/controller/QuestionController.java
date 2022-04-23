package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.QuestionForm;
import com.example.demo.service.QuestionService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class QuestionController {
	
	private final QuestionService questionService;

	@GetMapping("/showQuestion")
	public ModelAndView showQuestion(ModelAndView mav) {
		
		mav.setViewName("questionForm");
		mav.addObject("questionForm", new QuestionForm());
		
		return mav;
	}
	
	@PostMapping("/showQuestionResult")
	public ModelAndView showQuestionResult(ModelAndView mav,
			@ModelAttribute @Validated QuestionForm questionForm,
			BindingResult result) {
		
		if(result.hasErrors()) {
			// 入力エラーあり
			
			mav.setViewName("questionForm"
					+ "");
			mav.addObject("questionForm", questionForm);
		} else {
			// エラーなし
			
			String analysisResult = questionService.createAnalysisResult(questionForm); 
			
			mav.setViewName("questionResult");
			mav.addObject("analysisResult", analysisResult);
		
		}
		return mav;
		
	}
}