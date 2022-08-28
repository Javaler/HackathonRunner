package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class HomeController {
	
	private final PostRepository postRepository;
	
	@GetMapping("/")
	public ModelAndView showHome(ModelAndView mav) {
		
		List<Post> postList = postRepository.findAll();
		
		mav.setViewName("home");
		mav.addObject("postList", postList);
		
		return mav;
	}
}
