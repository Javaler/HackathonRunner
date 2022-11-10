var ctx = document.getElementById("myRaderChart");
var myRadarChart = new Chart(ctx, {
    type: 'radar',
    data: {
        labels: ["プログラミング経験値", "チーム開発経験値", "Git, GitHub経験値"],
        datasets: [{
            label: 'あなたのスコア',
            data: chartData,
            backgroundColor: 'RGBA(241,140,22, 0.7)',
            borderColor: 'RGBA(241,140,22, 1)',
            borderWidth: 1,
            pointBackgroundColor: 'RGB(46,106,177)'
        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: { // 凡例： 「あなたのスコア」
                labels: {
                    font: {
                        size: 24
                    }
                }
            },
            tooltip: { // ホバー時のポップアップ
                mode: 'index',
                intersect: false
            },
            title: { // チャートタイトル
                display: true,
                text: 'Hackathon Score',
                font: {
                    size: 24
                }
            },

        },
        scales: {
            mySclale: {
                axis: 'r',
                max: 4,
                min: 0,
                ticks: {
                    stepSize: 1,
                    font: { // 0 ~ 4
                        size: 18
                    }
                },
                grid: {
                    lineWidth: 3,
                },
                title: {
                    display: true,
                    text: 'scaleTitle'
                }
            }

        }
    }
});
