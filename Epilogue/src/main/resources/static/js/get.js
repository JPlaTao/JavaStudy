function fetchSend() {
    fetch("http://localhost:80/test")
        .then((response) => {
            return response.json();
        })
        .then((resp) => {
            document.write(resp.message)
        })
        .catch((reason) => {
            console.log(reason)
        })
}

function xhrSend() {
    let xhr = new XMLHttpRequest();
    xhr.open("get", "/test", true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let response = xhr.responseText;
            document.write(response)
        }
    }
}

function jQueryAjaxSend() {
    $.get("http://localhost/test", (response) => {
        console.log(response.data);
        document.write(response.data)
    })
}

function axiosSend() {
    axios.get("http://localhost/test")
        .then((response) => {
            console.log(response.data);
        });
}