"use strict"

// let allMistakes = document.getElementById('allMistakes');

let remAndMstk = "";



function addRemark(event){
    let mistake = event.target.value.substring(event.target.selectionStart, event.target.selectionEnd);
    let remark = prompt('remark to ' + mistake)
    const listOfMistake = document.getElementById('mistake');
    if (remark != null && remark != ""){
        remAndMstk += mistake + '|' + remark + '||';
        myCreateFunction(mistake, remark);
        document.getElementById("allMistakes").setAttribute("value", remAndMstk) ;
    }

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