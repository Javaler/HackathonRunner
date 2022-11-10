const forms=document.querySelectorAll('form.needs-validated');
const alert = document.getElementById('not-entered-alert');

for(const form of forms){
    form.addEventListener("input", (e)=>{
        if(form.checkValidity()){
            alert.style.display = 'none'
        } else {
            e.preventDefault();
            e.stopPropagation();
        }
    }, false);

    form.addEventListener('submit',(e)=>{
        console.log('validation');
        if(!form.checkValidity()){
            form.classList.add('was-validated');
            alert.style.display = 'block'

            e.preventDefault();
            e.stopPropagation();
        }
    }, false);
}
