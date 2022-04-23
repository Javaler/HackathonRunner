const submitButton=document.getElementById('submit-button'),
sendButton=document.getElementById('send-button');

let invalidColumns=[];

function getValidationMessage(invalidColumns){
    return invalidColumns.map((column)=>{
        return column.getElementsByTagName('p')[0].textContent;
    }).join(',')+'の項目が入力されていません。';
}

function getInvalidColumns(){
    const columns=document.getElementsByClassName('column');
    const invalidColumns=[];
    for(const column of columns){
        let isValid=false;
        const radios=column.querySelectorAll('input[type=radio]');
        for(const radio of radios){
            isValid=isValid||radio.checked;
        }
        if(!isValid){
            invalidColumns.push(column);
        }
    }
    return invalidColumns;
}

sendButton.addEventListener('click',()=>{
    for(const column of invalidColumns){
        column.classList.toggle('valid');
    }
    invalidColumns=getInvalidColumns();
    for(const column of invalidColumns){
        column.classList.toggle('valid');
    }
    if(invalidColumns.length){
        alert(getValidationMessage(invalidColumns));
        scrollToElement(invalidColumns[0]);
    }else{
        submitButton.click();
    }
});

function scrollToElement(element){
    scrollTo({top:element.getBoundingClientRect().top+window.pageYOffset,behavior:"smooth"});
}