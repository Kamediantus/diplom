"use strict"

// let allMistakes = document.getElementById('allMistakes');

let remAndMstk = "";



function addRemark(event){
    let mistake = event.target.value.substring(event.target.selectionStart, event.target.selectionEnd);
    console.log(event.target.selectionStart)
    let remark = prompt('remark to ' + mistake)
    const listOfMistake = document.getElementById('mistake');
    if (remark != null && remark != ""){
        remAndMstk += mistake + '|' + remark + '|' + event.target.selectionStart + ',' + event.target.selectionEnd + '||';
        myCreateFunction(mistake, remark);
        document.getElementById("allMistakes").setAttribute("value", remAndMstk);
        console.log(remAndMstk);
    }

}

const input = document.querySelector('textarea');
input.addEventListener('select', addRemark);


function myCreateFunction(mistake, remark) {
    let table = document.getElementById("myTable");
    let row = table.insertRow(1);
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);

    cell1.innerHTML = mistake;
    cell2.innerHTML = remark;
    cell3.innerHTML = '<input type="button" value="Delete" onclick="deleteRow(this)">';
}

function deleteRow(r) {
    let i = r.parentNode.parentNode.rowIndex;
    let table = document.getElementById("myTable");

    let mistake = table.rows.item(i).cells.item(0).innerHTML;
    let remark = table.rows.item(i).cells.item(1).innerHTML;
    let mstkAndRmrk = mistake + '|' + remark + '|';
    remAndMstk = remAndMstk.replace(mstkAndRmrk, "kuropatka");
    remAndMstk = remAndMstk.replace(new RegExp("kuropatka\\d+,\\d+\\|\\|"), "");
    console.log(remAndMstk);
    document.getElementById("allMistakes").setAttribute("value", remAndMstk) ;

    document.getElementById("myTable").deleteRow(i);
}

function popupFunc(id) {
    let popup = document.getElementById("myPopup" + id);
    popup.classList.toggle("show");
}

function success() {
    if(document.getElementById("textsend").value===null) {
        document.getElementById('button').disabled = true;
    } else {
        document.getElementById('button').disabled = false;
    }
}

let formSubmitting = false;
let setFormSubmitting = function() { formSubmitting = true; };

window.onload = function() {
    window.addEventListener("beforeunload", function (e) {
        if (formSubmitting) {
            return undefined;
        }

        let confirmationMessage = 'It looks like you have been editing something. '
            + 'If you leave before saving, your changes will be lost.';

        (e || window.event).returnValue = confirmationMessage; //Gecko + IE
        return confirmationMessage; //Gecko + Webkit, Safari, Chrome etc.
    });
};

function popupFunc(id) {
    let popup = document.getElementById("myPopup" + id);
    popup.classList.toggle("show");
}


