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
			analysisResult += "Git, GitHubの勉強をしましょう。";
		}
		
		
		if(hackathon==0) {
			if(team==0) {
				if(portfolio==0) {
					//アルゴリズム1 ハッカソン、チーム開発、成果物全てなしと成果物がなくハッカソン経験がない人
					analysisResult += "当日はスライド作成やアイデアを2、3個出せるように準備しておきましょう。";
					
				}else {
					//アルゴリズム4　ハッカソン経験とチーム開発経験なしだが成果物はある
					analysisResult += " Git, GitHubを使ったチーム開発方法を調べましょう。"
							+ "チーム内にハッカソン経験者やチーム開発経験者がいなくて、成果物のある人が他にいない場合は、リーダーの役割を検討しましょう。";
				}
			}else {
				//アルゴリズム2　ハッカソン経験なしだがチーム開発経験あり
				analysisResult += "チームにハッカソン経験者がいないならリーダーの役割を担いましょう。";
				
			}
			
		}else {
			//アルゴリズム3　ハッカソン経験あり
			analysisResult += " どんどん次のハッカソンに参加して、賞を目指しましょう！"
					+ "今までリーダーの経験がなければリーダーの役割を担ってPMしてみましょう。";
		}
				
		//アルゴリズム5　成果物ありでGit,GitHub経験なし
		if(portfolio==1 && git==0) {
			analysisResult += "Git, GitHubの勉強をしましょう。"
								+"チーム内にハッカソン経験者やチーム開発経験者がいなくて、成果物のある人が他にいない場合は、リーダーの役割を検討しましょう。";
		}
		
		//アルゴリズム6　動画編集経験あり
		if(movie==1) {
			analysisResult += "動画編集できることを伝えましょう。プレゼン資料作成などで役に立つはずです。";
		}
		
		//アルゴリズム7　プレゼン経験あり
		if(presentation==1) {
			analysisResult += "プレゼン資料の作成や発表を積極的に担当しましょう。ハッカソンではプレゼンの出来も評価対象です。";
		}
		
		
		//アルゴリズム8　デザインツールの基礎知識あり
		if(design==1) {
			analysisResult += "チームにデザインツールの応用レベルの人がいれば、その人のサポート役を担いましょう。" ;
		}
		
		//アルゴリズム9　デザインツールの応用レベル
		if(design==2) {
			analysisResult += "デザイン作成ができることを伝えましょう。" ;
		}
		
		//アルゴリズム10　JavaScriptの基礎
		if(frontend==1) {
			analysisResult += "JavaScriptのフレームワークを使える人がいれば、その人のサポート役を担いましょう。";
		}
		
		//アルゴリズム11 JavaScriptのフレームワークを使える
		if(frontend==2) {
			analysisResult += "フロントエンドの開発を行えることを伝えましょう。";
		}
		
		//アルゴリズム12 バックエンド言語の基礎あり
		if(backend==1) {
			analysisResult += "使えるバックエンド言語を伝えましょう。";
		}
		
		//アルゴリズム13 インフラ経験あり
		if(infrastructure==1) {
			analysisResult += "使えるインフラツールを伝えましょう。";
		}
		
		//アルゴリズム14 機械学習 API 利用経験orモデル作成経験あり
		if(machinelearning==1) {
			analysisResult += "機械学習を組み込めることを伝えましょう。";
		}
		
		//アルゴリズム15 技術的技能なし
		if(movie==0 && presentation==0
				&& design==0 && frontend==0
					&& backend==0 && infrastructure==0
						&& machinelearning==0) {
			analysisResult += "これらのプログラミング言語(JavaScript, PHP, Rubyなど)から1つ選び、勉強しておきましょう。";
		}
			
		
		return analysisResult;
	}
}