function success() {
    if(document.getElementById("textsend").value===null) {
        document.getElementById('button').disabled = true;
    } else {
        document.getElementById('button').disabled = false;
    }
}