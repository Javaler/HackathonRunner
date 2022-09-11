package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Post;
import com.example.demo.form.PostQuery;
import com.example.demo.repository.PostRepository;
import com.example.demo.dao.PostDaoImpl;
import com.example.demo.entity.Post;
import com.example.demo.form.PostQuery;
import com.example.demo.repository.PostRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final PostRepository postRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	PostDaoImpl postDaoImpl;

	@PostConstruct
	public void init() {
		postDaoImpl = new PostDaoImpl(entityManager);
	}
	
	
	@GetMapping("/")
	public ModelAndView showPost(ModelAndView mav) {
		
		List<Post> postList = postRepository.findAllByOrderByIdDesc();
		
		mav.setViewName("home");
		mav.addObject("postList", postList);
		mav.addObject("postQuery", new PostQuery());
		
		return mav;
	}
	
	
	@PostMapping("/")
	public ModelAndView queryPost(@ModelAttribute PostQuery postQuery, 
	                                BindingResult result,
	                                ModelAndView mav) {
	    mav.setViewName("home");

	    List<Post> postList = postDaoImpl.findByCriteria(postQuery);

	    mav.addObject("postList", postList);

	    return mav;
	  }
}
