const popoverTriggerList = document.getElementsByClassName("popover-button");
const contactRowList = document.getElementsByClassName("contact-row");
const popoverList = [];

for (let i = 0; i < popoverTriggerList.length; i++) {
    popoverList.push(new bootstrap.Popover(popoverTriggerList[i]));
    contactRowList[i].classList.add("hidden");
    popoverTriggerList[i].addEventListener("click", function () {
        this.classList.remove("btn-outline-primary");
        this.classList.add("btn-primary");
        console.log(i);
        contactRowList[i].classList.remove("hidden");
        popoverList[i].update();
    });
}
