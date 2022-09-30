const changePage=(pageNum)=>{ 
    const n=2;
    for(let i=0;i<n;i++){
        const questionPage=document.getElementById(`question-page${i}`);
        questionPage.style.display='none';
    }
    const shownQuestionPage=document.getElementById(`question-page${pageNum}`);
    shownQuestionPage.style.display='block';

    const progressBar=document.getElementById('progress-bar');
    scrollTo(0,0);
    progressBar.style.width=`${100*pageNum/n}%`;
};
