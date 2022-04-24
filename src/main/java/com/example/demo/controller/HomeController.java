package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.form.QuestionForm;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView showHome(ModelAndView mav) {
		
		mav.setViewName("home");
		mav.addObject("home", new QuestionForm());
		
		return mav;
	}
}
