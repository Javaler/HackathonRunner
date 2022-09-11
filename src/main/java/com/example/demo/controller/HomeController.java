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
import com.example.demo.form.HomeQuery;
import com.example.demo.repository.PostRepository;
import com.example.demo.dao.HomeDaoImpl;
import com.example.demo.entity.Post;
import com.example.demo.form.HomeQuery;
import com.example.demo.repository.PostRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final PostRepository postRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	HomeDaoImpl homeDaoImpl;

	@PostConstruct
	public void init() {
	homeDaoImpl = new HomeDaoImpl(entityManager);
	}
	
	
	@GetMapping("/")
	public ModelAndView showHome(ModelAndView mav) {
		
		List<Post> postList = postRepository.findAllByOrderByIdDesc();
		
		mav.setViewName("home");
		mav.addObject("postList", postList);
		mav.addObject("homeQuery", new HomeQuery());
		
		return mav;
	}
	
	
	@PostMapping("/")
	public ModelAndView queryTodo(@ModelAttribute HomeQuery homeQuery, 
	                                BindingResult result,
	                                ModelAndView mv) {
	    mv.setViewName("home");

	    List<Post> homeList = null;
	    homeList = homeDaoImpl.findByCriteria(homeQuery);

	    // mv.addObject("homeQuery", homeQuery);
	    mv.addObject("postList", homeList);

	    return mv;
	  }
}
