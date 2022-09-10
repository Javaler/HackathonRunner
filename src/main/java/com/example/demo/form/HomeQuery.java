package com.example.demo.form;

import lombok.Data;

@Data
public class HomeQuery {
	private int hackathon;
	private int team;
	private int frontend;
	private int backend;
	private int infrastructure;
	private int git;
	private int design;
	private int movie;
	private int machineLearning;
	private int portfolio;
	private int presentation;
	
	public HomeQuery() {
		hackathon = -1;
		team = -1;
		frontend = -1;
		backend = -1;
		infrastructure = -1;
		git = -1;
		design = -1;
		movie = -1;
		machineLearning = -1;
		portfolio = -1;
		presentation = -1;
	}

}
