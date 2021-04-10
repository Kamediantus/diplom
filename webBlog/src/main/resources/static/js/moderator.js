"use strict"

var myImage = document.querySelector('img');
var myButton = document.querySelector('button');
var myHeading = document.querySelector('h1');
var myHeading3 = document.querySelector('h3');
let remAndMstk = "";



function addRemark(event){
    let mistake = event.target.value.substring(event.target.selectionStart, event.target.selectionEnd);
    var remark = prompt('remark to ' + mistake)
    const listOfMistake = document.getElementById('mistake');
    if (remark != null && remark != ""){
        remAndMstk += remark + '  ||   ' + mistake + '<br>';
        myCreateFunction(mistake, remark);

    }
    // document.getElementById("newMistake").innerHTML = remAndMstk ;
}

const input = document.querySelector('textarea');
input.addEventListener('select', addRemark);


function myCreateFunction(mistake, remark) {
    var table = document.getElementById("myTable");
    var row = table.insertRow(1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);

    cell1.innerHTML = mistake;
    cell2.innerHTML = remark;
    cell3.innerHTML = '<input type="button" value="Delete" onclick="deleteRow(this)">';
}

function deleteRow(r) {
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
}