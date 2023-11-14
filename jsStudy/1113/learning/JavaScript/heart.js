let body = document.querySelector("body")

function random(num) {
    return Math.random() * num;
}

function randomColorString() {
    return "rgb(" + random(255) + "," + random(255) + "," + random(255) + ")"
}

window.onclick = (event) => {
    let x = event.clientX;
    let y = event.clientY;
    let heart = document.createElement("label");
    heart.classList.add("heart");
    heart.innerText = "♥";
    heart.style.userSelect = "none";
    heart.style.fontSize = '30px';
    heart.style.position = "absolute";
    heart.style.left = x - 8 + "px";
    heart.style.top = y - 40 + "px";
    heart.style.color = randomColorString();
    body.appendChild(heart);
    setTimeout(() => {
        body.removeChild(heart)
    }, 3000)
}