const changePageAlert = document.getElementById('change-page-alert');

const firstPageButtons = document.getElementById('buttons-first');
const middlePageButtons = document.getElementById('buttons-normal');
const lastPageButtons = document.getElementById('buttons-last');

const progressBar=document.getElementById('progress-bar');


let pageNumber = 0;

const endPageNumber = 12;

const getPage = (pageNumber)=> {
    return document.getElementById(`question-page${pageNumber}`);
}

const getRadios = (pageNumber)=> {
    return getPage(pageNumber).querySelectorAll('input[type=radio]');
}

const getRadioValue = (pageNumber)=> {
    const radios = getRadios(pageNumber);
    for(const radio of radios) {
        if(radio.checked)
            return radio.value;
    }
    return null;
}

const getPageButtons = (pageNumber)=> {
    switch(pageNumber) {
        case 0:
            return firstPageButtons;
        case endPageNumber - 1:
            return lastPageButtons;
        default:
            return middlePageButtons;
    }
}

const showPageButtons = (pageNumber)=> {
    for(const buttons of document.getElementsByClassName('buttons')) {
        buttons.style.display = 'none';
    }
    getPageButtons(pageNumber).style.display = 'block';
}

const nextPage = ()=> {
    if(getRadioValue(pageNumber) === null) {
        changePageAlert.style.display = 'block';
        return;
    }
    changePageAlert.style.display = 'none';

    getPage(pageNumber).style.display = 'none';
    const nextPageEl = getPage(++pageNumber);
    console.log(nextPageEl);
    nextPageEl.style.display = nextPageEl.dataset.pageDisplay;

    showPageButtons(pageNumber);

    scrollTo(0,0);
    progressBar.style.width=`${100*pageNumber/endPageNumber}%`;
}

const prevPage = ()=> {
    getPage(pageNumber).style.display = 'none';
    const prevPageEl = getPage(--pageNumber);
    prevPageEl.style.display = prevPageEl.dataset.pageDisplay;

    showPageButtons(pageNumber);

    const progressBar=document.getElementById('progress-bar');
    scrollTo(0,0);
    progressBar.style.width=`${100*pageNumber/endPageNumber}%`;
}

// エンターキーを押されると、次のページに行く処理
addEventListener('keydown', (e)=>{
    if(e.key === 'Enter' && pageNumber !== endPageNumber-1) {
        e.preventDefault();
        nextPage();
    }
});

{
    const firstPage = getPage(0);
    firstPage.style.display = firstPage.dataset.pageDisplay;
    showPageButtons(0);
}


// 一度progressBarのwidthを変更しておかないと、アニメーションされない。
progressBar.style.width='0%';
