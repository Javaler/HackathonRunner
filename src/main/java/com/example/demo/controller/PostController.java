package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Post;
import com.example.demo.form.PostForm;
import com.example.demo.repository.PostRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostController {

	private final PostRepository postRepository;
	
	@GetMapping("/showPostForm")
	public ModelAndView showPostForm(ModelAndView mav) {
		
		mav.setViewName("postForm");
		mav.addObject("postForm", new PostForm());
		
		return mav;
	}
	
	@PostMapping("/post")
	public String post(@ModelAttribute PostForm postForm) {
		
		Post post = postForm.toEntity();
		postRepository.saveAndFlush(post);
		
		return "redirect:/";
	}
	
	@GetMapping("/Post/{post_id}")
	public ModelAndView showPostDetail(ModelAndView mav, 
			@PathVariable(name = "post_id") int postId) {
		
		Optional<Post> somePost = postRepository.findById(postId);
		somePost
			.ifPresentOrElse(post -> {
				mav.setViewName("postDetail");
				mav.addObject("post", post);
			}, () -> {
				mav.setViewName("redirect:/");
			});
		
		return mav;
	}
}
