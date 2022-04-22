package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.form.QuestionForm;

@Service
public class QuestionService {

	public String createAnalysisResult(QuestionForm questionForm) {
		
		 
		String analysisResult ="";
		
		// 診断アルゴリズム
		
		//アルゴリズム1 ハッカソン、チーム開発、成果物全てなしと成果物がなくハッカソン経験がない人
		if((questionForm.getHackathon()==0 && questionForm.getTeam()==0 
				&& questionForm.getPortfolio()==0) 
				| questionForm.getPortfolio()==0 && questionForm.getHackathon()==0) {
			analysisResult +=  "Git, GitHubの勉強をしましょう。"
								+ "また、当日はスライド作成やアイデアを2、3個出せるように準備しておきましょう。"; 
		}
		
		//アルゴリズム2　ハッカソン経験なしだがチーム開発経験あり
		if(questionForm.getHackathon()==0 && questionForm.getTeam()==1) {
			analysisResult += "チームにハッカソン経験者がいないならリーダーの役割を担いましょう。"; 
		}
		
		//アルゴリズム3　ハッカソン経験あり
		if(questionForm.getHackathon()==1) {
			analysisResult += " どんどん次のハッカソンに参加して、賞を目指しましょう！"
								+ "今までリーダーの経験がなければリーダーの役割を担ってPMしてみましょう。";
		}
		
		//アルゴリズム4　ハッカソン経験とチーム開発経験なしだが成果物はある
		if(questionForm.getHackathon()==0 && questionForm.getTeam()==0 
				&& questionForm.getPortfolio()==1) {
			analysisResult += " Git, GitHubを使ったチーム開発方法を調べましょう。"
								+ "チーム内にハッカソン経験者やチーム開発経験者がいなくて、成果物のある人が他にいない場合は、リーダーの役割を検討しましょう。";
		}
		
		//アルゴリズム5　成果物ありでGit,GitHub経験なし
		if(questionForm.getPortfolio()==1 && questionForm.getGit()==0) {
			analysisResult += "Git, GitHubの勉強をしましょう。"
								+"チーム内にハッカソン経験者やチーム開発経験者がいなくて、成果物のある人が他にいない場合は、リーダーの役割を検討しましょう。";
		}
		
		//アルゴリズム6　動画編集経験あり
		if(questionForm.getMovie()==1) {
			analysisResult += "動画編集できることを伝えましょう。プレゼン資料作成などで役に立つはずです。";
		}
		
		//アルゴリズム7　プレゼン経験あり
		if(questionForm.getPresentation()==1) {
			analysisResult += "プレゼン資料の作成や発表を積極的に担当しましょう。ハッカソンではプレゼンの出来も評価対象です。";
		}
		
		
		//アルゴリズム8　デザインツールの基礎知識あり
		if(questionForm.getDesign()==1) {
			analysisResult += "チームにデザインツールの応用レベルの人がいれば、その人のサポート役を担いましょう。" ;
		}
		
		//アルゴリズム9　デザインツールの応用レベル
		if(questionForm.getDesign()==2) {
			analysisResult += "デザイン作成ができることを伝えましょう。" ;
		}
		
		//アルゴリズム10　JavaScriptの基礎
		if(questionForm.getFrontend()==1) {
			analysisResult += "JavaScriptのフレームワークを使える人がいれば、その人のサポート役を担いましょう。";
		}
		
		//アルゴリズム11 JavaScriptのフレームワークを使える
		if(questionForm.getFrontend()==2) {
			analysisResult += "フロントエンドの開発を行えることを伝えましょう。";
		}
		
		//アルゴリズム12 バックエンド言語の基礎あり
		if(questionForm.getBackend()==1) {
			analysisResult += "使えるバックエンド言語を伝えましょう。";
		}
		
		//アルゴリズム13 インフラ経験あり
		if(questionForm.getInfrastructure()==1) {
			analysisResult += "使えるインフラツールを伝えましょう。";
		}
		
		//アルゴリズム14 機械学習 API 利用経験orモデル作成経験あり
		if(questionForm.getMachineLearning()==1) {
			analysisResult += "機械学習を組み込めることを伝えましょう。";
		}
		
		//アルゴリズム15 技術的技能なし
		if(questionForm.getMovie()==0 && questionForm.getPresentation()==0
				&& questionForm.getDesign()==0 && questionForm.getFrontend()==0
					&& questionForm.getBackend()==0 && questionForm.getInfrastructure()==0
						&& questionForm.getMachineLearning()==0) {
			analysisResult += "これらのプログラミング言語(JavaScript, PHP, Rubyなど)から1つ選び、勉強しておきましょう。";
		}
			
		
		return analysisResult;
	}
}