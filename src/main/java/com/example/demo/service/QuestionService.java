package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.form.QuestionForm;

@Service
public class QuestionService {

	public List<String> createAnalysisResult(QuestionForm questionForm) {
		
		 
		List<String> analysisResult = new ArrayList<>();
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
		int machinelearning = questionForm.getMachinelearning();
		
		
		//アルゴリズム0
		if(git==0) {
			analysisResult.add("Git, GitHubの勉強をしましょう。");
			
		}
		
		
		if(hackathon==0) {
			if(team==0) {
				if(portfolio==0) {
					//アルゴリズム1 ハッカソン、チーム開発、成果物全てなしと成果物がなくハッカソン経験がない人
					analysisResult.add("当日はスライド作成やアイデアを2、3個出せるように準備しておきましょう。");
					
				}else {
					//アルゴリズム4　ハッカソン経験とチーム開発経験なしだが成果物はある
					analysisResult.add("Git, GitHubを使ったチーム開発方法を調べましょう。");
					analysisResult.add("チーム内にハッカソン経験者やチーム開発経験者がいなくて、成果物のある人が他にいない場合は、リーダーの役割を検討しましょう。");
				}
			}else {
				//アルゴリズム2　ハッカソン経験なしだがチーム開発経験あり
				analysisResult.add("チームにハッカソン経験者がいないならリーダーの役割を担いましょう。");
				
			}
			
		}else {
			//アルゴリズム3　ハッカソン経験あり
			analysisResult.add("どんどん次のハッカソンに参加して、賞を目指しましょう！");
			analysisResult.add("今までリーダーの経験がなければリーダーの役割を担ってPMしてみましょう。");
		}
				
		//アルゴリズム5　成果物ありでGit,GitHub経験なし
		if(portfolio==1 && git==0) {
			analysisResult.add("チーム内にハッカソン経験者やチーム開発経験者がいなくて、成果物のある人が他にいない場合は、リーダーの役割を検討しましょう。");
		}
		
		//アルゴリズム6　動画編集経験あり
		if(movie==1) {
			analysisResult.add("動画編集できることを伝えましょう。プレゼン資料作成などで役に立つはずです。");
		}
		
		//アルゴリズム7　プレゼン経験あり
		if(presentation==1) {
			analysisResult.add("プレゼン資料の作成や発表を積極的に担当しましょう。ハッカソンではプレゼンの出来も評価対象です。");
		}
		
		
		//アルゴリズム8　デザインツールの基礎知識あり
		if(design==1) {
			analysisResult.add("チームにデザインツールの応用レベルの人がいれば、その人のサポート役を担いましょう。");
		}
		
		//アルゴリズム9　デザインツールの応用レベル
		if(design==2) {
			analysisResult.add("デザイン作成ができることを伝えましょう。");
		}
		
		//アルゴリズム10　JavaScriptの基礎
		if(frontend==1) {
			analysisResult.add("JavaScriptのフレームワークを使える人がいれば、その人のサポート役を担いましょう。");
		}
		
		//アルゴリズム11 JavaScriptのフレームワークを使える
		if(frontend==2) {
			analysisResult.add("フロントエンドの開発を行えることを伝えましょう。");
		}
		
		//アルゴリズム12 バックエンド言語の基礎あり
		if(backend==1) {
			analysisResult.add("使えるバックエンド言語を伝えましょう。");
		}
		
		//アルゴリズム13 インフラ経験あり
		if(infrastructure==1) {
			analysisResult.add("使えるインフラツールを伝えましょう。");
		}
		
		//アルゴリズム14 機械学習 API 利用経験orモデル作成経験あり
		if(machinelearning==1) {
			analysisResult.add("機械学習を組み込めることを伝えましょう。");
		}
		
		//アルゴリズム15 技術的技能なし
		if(movie==0 && presentation==0
				&& design==0 && frontend==0
					&& backend==0 && infrastructure==0
						&& machinelearning==0) {
			analysisResult.add("プログラミング言語(JavaScript, PHP, Rubyなどから1つ)を勉強しておきましょう。");
		}
			
		return analysisResult;
	}
	
	public int[] createHackathonScore(QuestionForm questionForm) {
		
		int[] score = new int[3];
		int programpoint = 0;
		int teampoint = 0;
		int gitpoint = 0;
		int hackathon = questionForm.getHackathon();
		int team = questionForm.getTeam();
		int portfolio = questionForm.getPortfolio();
		int git = questionForm.getGit();
		int frontend = questionForm.getFrontend();
		int backend = questionForm.getBackend();
		int machinelearning = questionForm.getMachinelearning();
		
		
		//プログラミング経験値算出
		//なし
		//授業、趣味、独学でプログラミングの基礎を学んだことがある
		if(portfolio == 0) {
			if(frontend == 0 && backend == 0 && machinelearning == 0) {
				programpoint = 0;
			} else {
				programpoint = 1;
			}
		}
		
		//簡単なツール（アプリ）を作ったことがある
		//ツール（アプリ）を公開したことがある
		//ツール（アプリ）開発で、設計・実装・テストを経験したがある
		if(portfolio > 0) {
			programpoint = portfolio + 1;
		}
		
		//チーム開発経験値算出		
		if(hackathon == 0) {
			if(team == 0) {
				teampoint = 0;				//なし
			} else {
				teampoint = 1;				//知人（友人、研究室仲間）との開発経験
			}
		} else {
			if(team == 2) {
				teampoint = 4;				//インターン・アルバイトでのチーム開発経験
			} else {
				teampoint = hackathon + 1;	//ハッカソンなど、即席チームでの開発経験 1, 2回or3回以上
			}
		}		
		
		//Git, GitHub経験値算出
		gitpoint = git;
		
		//算出値格納
		score[0] = programpoint;
		score[1] = teampoint;
		score[2] = gitpoint;
		
		return score;
	}
}
