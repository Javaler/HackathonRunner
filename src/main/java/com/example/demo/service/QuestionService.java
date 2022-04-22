package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.form.QuestionForm;

@Service
public class QuestionService {

	public String createAnalysisResult(QuestionForm questionForm) {
		
		String analysisResult = "test" + questionForm.toString(); 
		//StringBuilder analysisResult = new StringBuilder();
		
		// 診断アルゴリズム
		
		
		if(questionForm.getHackathon()==0 && questionForm.getTeam()==1) {
			analysisResult += "チームにハッカソン経験者がいないならリーダーの役割を担いましょう。"; 
		}else {
			 String si0 = Integer.valueOf(questionForm.getHackathon()).toString();
			 String si1 = Integer.valueOf(questionForm.getTeam()).toString();
			analysisResult += "false" + si0 + si1;
		}
		
		
		return analysisResult;
	}
}