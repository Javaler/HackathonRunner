# HackathonRunner
ハッカソンに対する不安を解消することで、ハッカソンに参加したい・参加する人たちを支援するためのWebアプリ。

**URL**: [https://infinite-citadel-53332.herokuapp.com](https://infinite-citadel-53332.herokuapp.com)

## 使用技術(ツール)一覧

- **アプリケーション**
  - フロントエンド
    - **Bootstrap**
    - **Chart.js**
  - バックエンド
    - **Java**
    - **Maven**
    - **Spring Boot**
- **インフラ**
  - **Heroku**
  - **Heroku Postgres**
- **バージョン/ソースコード管理**
  - **Git, GitHub**
- その他使用ツール
  - Visual Studio Code(フロントエンド, README等)
  - SpringToolSuite4(バックエンド)
  - digrams.net(クラス図)
  - Figma(ワイヤーフレーム, プロトタイプ, アプリアイコン)
  - Notion(ドキュメント)

## 仕様/機能一覧

- **診断機能**
  - 選択式の質問約10個に回答すると、ハッカソンに対する技術レベルを診断し、「ハッカソンまでに何を準備しておけば良いか」や「ハッカソンでどう振る舞えば良いか」といった提案をする
  - [HackathonRunner-Analysis-API](https://github.com/Javaler/HackathonRunner-Analysis-API) を叩いて、同じような技術レベルの人の投稿（どんなハッカソンに参加したかなど）を取得・表示する
  - ハッカソンに対する技術レベルをチャートで表示する
- **投稿機能**
  - 投稿の新規作成、一覧表示、詳細表示
- **検索機能**
  - 投稿の検索
