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

        if(git == 0) {
            // 0: Git, GitHub使用経験なし
            analysisResult.add("Git, GitHubの勉強をしましょう。");
        }

        if(hackathon == 0) {
            if(team == 0) {
                if(portfolio == 0) {
                    // 1: ハッカソン参加経験なし、チーム開発経験なし、ツール（アプリ）開発経験なし
                    analysisResult.add("当日はスライド作成やアイデアを2、3個出せるように準備しておきましょう。");
                } else {
                    // 4: ハッカソン参加経験なし、チーム開発経験なし、ツール（アプリ）開発経験あり
                    analysisResult.add("Git, GitHubを使ったチーム開発方法を調べましょう。");
                    analysisResult.add("チーム内にハッカソン参加経験者やチーム開発経験者がいなくて、ツール（アプリ）開発経験のある人が他にいない場合は、リーダーの役割を検討しましょう。");
                }
            } else {
                // 2: ハッカソン参加経験なし、チーム開発経験あり
                analysisResult.add("チームにハッカソン参加経験者がいないならリーダーの役割を担いましょう。");
            }
        } else {
            // 3: ハッカソン参加経験あり
            analysisResult.add("どんどん次のハッカソンに参加して、賞を目指しましょう！");
            analysisResult.add("今までリーダーの経験がなければリーダーの役割を担ってPMしてみましょう。");
        }

        if(portfolio > 1 && git == 0) {
            // 5: ツール（アプリ）開発経験あり、Git, GitHub使用経験なし
            analysisResult.add("チーム内にハッカソン参加経験者やチーム開発経験者がいなくて、ツール（アプリ）開発経験のある人が他にいない場合は、リーダーの役割を検討しましょう。");
        }

        if(movie == 1) {
            // 6: 動画編集経験あり
            analysisResult.add("動画編集できることを伝えましょう。プレゼン資料作成などで役に立つはずです。");
        }

        if(presentation == 1) {
            // 7: プレゼン経験あり
            analysisResult.add("プレゼン資料の作成や発表を積極的に担当しましょう。ハッカソンではプレゼンの出来も評価対象です。");
        }

        if(design == 1) {
            // 8: デザインツールの基礎知識あり
            analysisResult.add("チームにデザインツールの応用レベルの人がいれば、その人のサポート役を担いましょう。");
        }

        if(design == 2) {
            // 9: デザインツールの応用レベル
            analysisResult.add("デザイン作成ができることを伝えましょう。");
        }

        if(frontend == 1) {
            // 10: JavaScriptの基礎
            analysisResult.add("JavaScriptのフレームワークを使える人がいれば、その人のサポート役を担いましょう。");
        }

        if(frontend == 2) {
            // 11: JavaScriptのフレームワークを使える
            analysisResult.add("フロントエンドの開発を行えることを伝えましょう。");
        }

        if(backend == 1) {
            // 12: バックエンド言語の基礎あり
            analysisResult.add("使えるバックエンド言語を伝えましょう。");
        }

        if(infrastructure == 1) {
            // 13: インフラ経験あり
            analysisResult.add("使えるインフラツールを伝えましょう。");
        }

        if(machinelearning > 1) {
            // 14: データ分析・画像処理経験あり
            analysisResult.add("機械学習を組み込めることを伝えましょう。");
        }

        if(movie == 0 && presentation == 0 && design == 0 && frontend == 0
        && backend == 0 && infrastructure == 0 && machinelearning == 0) {
            // 15: 技術的技能なし
            analysisResult.add("プログラミング言語(JavaScript, PHP, Rubyなどから1つ)を勉強しておきましょう。");
        }

        return analysisResult;
    }

    public int[] createHackathonScore(QuestionForm questionForm) {

        int hackathon = questionForm.getHackathon();
        int team = questionForm.getTeam();
        int portfolio = questionForm.getPortfolio();
        int git = questionForm.getGit();
        int frontend = questionForm.getFrontend();
        int backend = questionForm.getBackend();
        int machinelearning = questionForm.getMachinelearning();

        //プログラミング経験値
        int programmingScore = 0;

        if(portfolio == 0) {
            if (frontend == 0 && backend == 0 && machinelearning == 0) {
                // なし
                programmingScore = 0;
            } else {
                // 授業、趣味、独学でプログラミングの基礎を学んだことがある
                programmingScore = 1;
            }
        } else {
            // 簡単なツール（アプリ）を作ったことがある
            // ツール（アプリ）を公開したことがある
            // ツール（アプリ）開発で、設計・実装・テストを経験したがある
            programmingScore = portfolio + 1;
        }

        // チーム開発経験値
        int teamScore = 0;

        if(hackathon == 0) {
            if(team == 0) {
                // なし
                teamScore = 0;
            } else {
                // 知人（友人、研究室仲間）との開発経験
                teamScore = 1;
            }
        } else {
            if(team == 2) {
                // インターン・アルバイトでのチーム開発経験
                teamScore = 4;
            } else {
                // ハッカソンなど、即席チームでの開発経験 1, 2回or3回以上
                teamScore = hackathon + 1;
            }
        }

        int[] score = {programmingScore, teamScore, git};

        return score;
    }
}
