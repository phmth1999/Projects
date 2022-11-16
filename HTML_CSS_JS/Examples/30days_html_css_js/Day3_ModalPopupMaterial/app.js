let btnOpen = document.querySelector(".open-modal-btn");
let modal = document.querySelector(".modal");
let iconClose = document.querySelector(".modal-header i");
let btnClose = document.querySelector(".modal-footer button");

function toggleModal(){
    modal.classList.toggle("hide");
}
btnOpen.addEventListener("click",toggleModal);
iconClose.addEventListener("click",toggleModal);
btnClose.addEventListener("click",toggleModal);
modal.addEventListener("click",function(e){
    if(e.target == e.currentTarget){
        toggleModal();
    }
});
