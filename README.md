# HackathonRunner
ハッカソンに対する不安を解消することで、ハッカソンに参加したい・参加する人たちを支援するためのWebアプリ。

<img src="https://user-images.githubusercontent.com/79685987/197310366-d45ea75e-e970-441c-88f5-f57601a65ef6.jpg">

**URL(公開終了)**: ~~[https://hackathonrunner.azurewebsites.net](https://hackathonrunner.azurewebsites.net)~~

## 仕様/機能一覧

### 診断機能
- 選択式の質問約10個に回答すると、ハッカソンに対する技術レベルを診断し、「ハッカソンまでに何を準備しておけば良いか」や「ハッカソンでどう振る舞えば良いか」といった提案をする
- [HackathonRunner-Analysis-API](https://github.com/Javaler/HackathonRunner-Analysis-API) を叩いて、同じような技術レベルの人の投稿（どんなハッカソンに参加したかなど）を取得・表示する
- ハッカソンに対する技術レベルをチャートで表示する
- 使用時の画面(2022年10月時点)
<img src="https://user-images.githubusercontent.com/79685987/197223472-e6814061-015a-48e1-a347-02e690979ba6.mp4">

### 投稿機能
- 投稿の新規作成、一覧表示、詳細表示、検索
- 使用時の画面(2022年10月時点)
<img src="https://user-images.githubusercontent.com/79685987/197227396-ac8907ca-91b9-480f-9b52-e4ebb2113861.mp4">

### チームメンバー募集機能
- 開発仲間やハッカソンに一緒に参加できる人を集めるための投稿、表示
- 使用時の画面(2022年10月時点)
<img src="https://user-images.githubusercontent.com/79685987/197318073-827d3bae-7763-48c1-9e3f-ac4df6ddc05c.mp4">

## 使用技術(ツール)一覧

- **アプリケーション**
  - フロントエンド
    - **HTML/CSS**
    - **JavaScript**
    - **Bootstrap**
    - **Chart.js**
  - バックエンド
    - **Java**
    - **Maven**
    - **Spring Boot**
    - **[HackathonRunner-Analysis-API](https://github.com/Javaler/HackathonRunner-Analysis-API)**
- **インフラ**
  - **Azure App Service**
  - **Azure Database for PostgreSQL**
- **バージョン/ソースコード管理**
  - **Git, GitHub**
- その他使用ツール
  - Visual Studio Code(フロントエンド, README等)
  - SpringToolSuite4(バックエンド)
  - digrams.net(クラス図)
  - Figma(ワイヤーフレーム, プロトタイプ, アプリアイコン)
  - Notion(ドキュメント)

## 役割分担
- **リーダー・マネジメント(ドキュメント、タスク等)**
  1. kmusicsports - Naoki Kajitani
- **デザイン**
  1. IkedaAkihira - Ikeda Akihira
  2. Utricularor
  3. kmusicsports - Naoki Kajitani
- **フロントエンド**
  1. IkedaAkihira - Ikeda Akihira
  2. kmusicsports - Naoki Kajitani
  3. Utricularor
- **バックエンド**
  1. kmusicsports - Naoki Kajitani
  2. YutaSugino - Yut@
- **インフラ**
  1. YutaSugino - Yut@
- **類似ユーザーの投稿推薦API([HackathonRunner-Analysis-API](https://github.com/Javaler/HackathonRunner-Analysis-API))**
  1. Utricularor

