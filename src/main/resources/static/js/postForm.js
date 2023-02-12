const changePageAlert = document.getElementById('change-page-alert');

const changePage=(pageNum)=>{
    changePageAlert.style.display = 'none';
    const n=12;
    for(let i=0;i<n;i++){
        const questionPage=document.getElementById(`question-page${i}`);
        questionPage.style.display='none';
    }
    const shownQuestionPage=document.getElementById(`question-page${pageNum}`);
    shownQuestionPage.style.display=shownQuestionPage.dataset.pageDisplay;

    const progressBar=document.getElementById('progress-bar');
    scrollTo(0,0);
    progressBar.style.width=`${100*pageNum/n}%`;
};

const getRadiosByName = (name)=> {
    return document.querySelectorAll(`.form-check-input[name=${name}]`);
}

const getRadioValue = (radioName)=> {
    const radios = getRadiosByName(radioName);
    for(const radio of radios) {
        if(radio.checked)
            return radio.value;
    }
    return null;
}

const showChangePageAlert = ()=> { 
    changePageAlert.style.display = 'block';
}
