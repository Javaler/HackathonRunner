const popoverTriggerList = document.getElementsByClassName("popover-button");

for (i = 0; i < popoverTriggerList.length; i++) {
    popoverTriggerList[i].addEventListener("click", function () {
        this.classList.remove("btn-outline-primary");
        this.classList.add("btn-primary");
    });
}
