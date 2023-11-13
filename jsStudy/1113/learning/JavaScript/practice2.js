let j = 0;
let mhIMG = document.getElementById("mh");
setInterval(() => {
    if (j === 3) {
        j = 0;
    }
    switch (j){
        case 0:{
            mhIMG.src = "img/mh1.png"
            break;
        }
        case 1:{
            mhIMG.src = "img/mh2.png"
            break;
        }
        case 2:{
            mhIMG.src = "img/mh3.png"
            break;
        }
    }
    j++;
},1500);

let options = document.querySelectorAll(".optionGroup input");
for (let option of options) {
    option.checked = true;
}

let theDiv = document.getElementById("theDiv");
theDiv.innerText = "下面是一个灯泡"
let imgEl = document.getElementById("light");
let i = 0;
let interval = setInterval(() => {
    if (i % 2 === 0) {
        imgEl.src = "img/关灯.png";
        theDiv.append(",灯关了")
    } else {
        imgEl.src = "img/开灯.png";
        theDiv.append(",灯开了")
    }
    if (i === 10) {
        imgEl.src = "";
        clearInterval(interval)
    }
    i++;
}, 1000)
