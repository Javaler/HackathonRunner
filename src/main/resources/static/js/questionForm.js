const forms=document.querySelectorAll('form.needs-validated');

for(const form of forms){
    form.addEventListener('submit',(e)=>{
        console.log('validation');
        if(!form.checkValidity()){
            e.preventDefault();
            e.stopPropagation();
        }
        form.classList.add('was-validated');
    },false);
}