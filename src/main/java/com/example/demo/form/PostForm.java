package com.example.demo.form;

import com.example.demo.entity.Post;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostForm {
	private Integer id;	
	
	@NotBlank(message = "名前を入力してください")
	private String name;
	
	@NotNull(message = "選択してください")
	private Integer hackathon;
	
	@NotNull(message = "選択してください")
	private Integer team;
	
	@NotNull(message = "選択してください")
	private Integer frontend;
	
	@NotNull(message = "選択してください")
	private Integer backend;
	
	@NotNull(message = "選択してください")
	private Integer infrastructure;
	
	@NotNull(message = "選択してください")
	private Integer git;
	
	@NotNull(message = "選択してください")
	private Integer design;
	
	@NotNull(message = "選択してください")
	private Integer movie;
	
	@NotNull(message = "選択してください")
	private Integer machinelearning;
	
	@NotNull(message = "選択してください")
	private Integer portfolio;
	
	@NotNull(message = "選択してください")
	private Integer presentation;
	
	@NotNull(message = "作品情報を入力してください")
	private String work;
	
	@NotNull(message = "参加イベント情報を入力してください")
	private String event;
	
	private String comment;

	
	//入力データからEntityを生成して返す  
	public Post toEntity() {
		Post post = new Post();
		
		post.setId(id);
		post.setName(name);
		post.setHackathon(hackathon);
		post.setTeam(team);
		post.setFrontend(frontend);
		post.setBackend(backend);
		post.setInfrastructure(infrastructure);
		post.setGit(git);
		post.setDesign(design);
		post.setMovie(movie);
		post.setMachinelearning(machinelearning);
		post.setPortfolio(portfolio);
		post.setPresentation(presentation);
		post.setWork(work);
		post.setEvent(event);
		post.setComment(comment);
		
		return post;
	}
}
