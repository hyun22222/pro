const up = document.querySelector(".ulbtn");
const option = document.querySelectorAll(".option");
const select = document.querySelector("#select");


up.addEventListener("click", ()=> {
    if(select.style.height == "0px"){
      select.style. height = select.scrollHeight + "px";
    }else{
      select.style. height = "0px";
    }
});

option.forEach((item) => {
  item.addEventListener("click", () => {
    up.firstElementChild.textContent = item.textContent;
    select.style. height = "0px";
  })
});


let ca = "";

option.forEach((item) => {
  item.addEventListener("click", () => {
  ca = item.value;
  });
});

ca;

const set = () =>{
            let editor = document.querySelector(".ql-editor").innerHTML;
            let input = document.querySelector("#input1");
            let category = document.querySelector("#ctg");

            category.value = ca;
            input.value = editor;
        }

