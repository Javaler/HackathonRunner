package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.form.QuestionForm;

@Service
public class QuestionService {

	public String createAnalysisResult(QuestionForm questionForm) {
		
		 
		String analysisResult ="";
		int hackathon = questionForm.getHackathon();
		int team = questionForm.getTeam();
		int portfolio = questionForm.getPortfolio();
		int git = questionForm.getGit();
		int movie = questionForm.getMovie();
		int presentation = questionForm.getPresentation();
		int design = questionForm.getDesign();
		int frontend = questionForm.getFrontend();
		int backend = questionForm.getBackend();
		int infrastructure = questionForm.getInfrastructure();
		int machinelearning = questionForm.getMachineLearning();
		
		
		//アルゴリズム0
		if(git==0) {
			analysisResult += "<li>Git, GitHubの勉強をしましょう。</li>";
			
		}
		
		
		if(hackathon==0) {
			if(team==0) {
				if(portfolio==0) {
					//アルゴリズム1 ハッカソン、チーム開発、成果物全てなしと成果物がなくハッカソン経験がない人
					analysisResult +="<li>当日はスライド作成やアイデアを2、3個出せるように準備しておきましょう。</li>";
					
				}else {
					//アルゴリズム4　ハッカソン経験とチーム開発経験なしだが成果物はある
					analysisResult += "<li>Git, GitHubを使ったチーム開発方法を調べましょう。</li>"
							+ "<li>チーム内にハッカソン経験者やチーム開発経験者がいなくて、成果物のある人が他にいない場合は、リーダーの役割を検討しましょう。</li>";
				}
			}else {
				//アルゴリズム2　ハッカソン経験なしだがチーム開発経験あり
				analysisResult += "<li>チームにハッカソン経験者がいないならリーダーの役割を担いましょう。</li>";
				
			}
			
		}else {
			//アルゴリズム3　ハッカソン経験あり
			analysisResult += "<li>どんどん次のハッカソンに参加して、賞を目指しましょう！</li>"
					+ "<li>今までリーダーの経験がなければリーダーの役割を担ってPMしてみましょう。</li>";
		}
				
		//アルゴリズム5　成果物ありでGit,GitHub経験なし
		if(portfolio==1 && git==0) {
			analysisResult +="<li>チーム内にハッカソン経験者やチーム開発経験者がいなくて、成果物のある人が他にいない場合は、リーダーの役割を検討しましょう。</li>";
		}
		
		//アルゴリズム6　動画編集経験あり
		if(movie==1) {
			analysisResult += "<li>動画編集できることを伝えましょう。プレゼン資料作成などで役に立つはずです。</li>";
		}
		
		//アルゴリズム7　プレゼン経験あり
		if(presentation==1) {
			analysisResult += "<li>プレゼン資料の作成や発表を積極的に担当しましょう。ハッカソンではプレゼンの出来も評価対象です。</li>";
		}
		
		
		//アルゴリズム8　デザインツールの基礎知識あり
		if(design==1) {
			analysisResult += "<li>チームにデザインツールの応用レベルの人がいれば、その人のサポート役を担いましょう。</li>";
		}
		
		//アルゴリズム9　デザインツールの応用レベル
		if(design==2) {
			analysisResult += "<li>デザイン作成ができることを伝えましょう。</li>";
		}
		
		//アルゴリズム10　JavaScriptの基礎
		if(frontend==1) {
			analysisResult += "<li>JavaScriptのフレームワークを使える人がいれば、その人のサポート役を担いましょう。</li>";
		}
		
		//アルゴリズム11 JavaScriptのフレームワークを使える
		if(frontend==2) {
			analysisResult += "<li>フロントエンドの開発を行えることを伝えましょう。</li>";
		}
		
		//アルゴリズム12 バックエンド言語の基礎あり
		if(backend==1) {
			analysisResult += "<li>使えるバックエンド言語を伝えましょう。</li>";
		}
		
		//アルゴリズム13 インフラ経験あり
		if(infrastructure==1) {
			analysisResult += "<li>使えるインフラツールを伝えましょう。</li>";
		}
		
		//アルゴリズム14 機械学習 API 利用経験orモデル作成経験あり
		if(machinelearning==1) {
			analysisResult += "<li>機械学習を組み込めることを伝えましょう。</li>";
		}
		
		//アルゴリズム15 技術的技能なし
		if(movie==0 && presentation==0
				&& design==0 && frontend==0
					&& backend==0 && infrastructure==0
						&& machinelearning==0) {
			analysisResult += "<li>プログラミング言語(JavaScript, PHP, Rubyなどから1つ)を勉強しておきましょう。</li>";
		}
			
		return analysisResult;
	}
	
	public int[] createHackathonScore(QuestionForm questionForm) {
		
		int[] score = new int[3];
		int programpoint;
		int teampoint;
		int gitpoint;
		int hackathon = questionForm.getHackathon();
		int team = questionForm.getTeam();
		int portfolio = questionForm.getPortfolio();
		int git = questionForm.getGit();
		int movie = questionForm.getMovie();
		int presentation = questionForm.getPresentation();
		int design = questionForm.getDesign();
		int frontend = questionForm.getFrontend();
		int backend = questionForm.getBackend();
		int infrastructure = questionForm.getInfrastructure();
		int machinelearning = questionForm.getMachineLearning();
		
		
		//プログラミング経験値算出
		//なし
		if(frontend == 0 && backend == 0 && machinelearning == 0 && portfolio == 0) {
			programpoint = 1;
		}
		
		//授業、趣味、独学でプログラミングの基礎を学んだことがある
		if(frontend == 1 || backend == 1 || machinelearning == 1 && portfolio == 0) {
			programpoint = 2;
		}
		
		//簡単なツール（アプリ）を作ったことがある
		if(portfolio == 1) {
			programpoint = 3;
		}
		
		//ツール（アプリ）を公開したことがある
		if(portfolio == 2) {
			programpoint = 4;
		}
		
		//ツール（アプリ）開発で、設計・実装・テストを経験したがある
		if(portfolio == 3) {
			programpoint = 5;
		}
		
		
		
		
		return score;
	}
}