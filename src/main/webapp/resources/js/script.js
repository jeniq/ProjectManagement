// $('#myModal').on('shown.bs.modal', function () {
//   $('#myInput').focus()
// })

// $(function () {
//   $('[data-toggle="tooltip"]').tooltip()
// })
//

//--- Drag & Drop

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));
    document.getElementById(data).classList.remove("label-default");
    document.getElementById(data).classList.add("label-success");
}

//--- DateTimePicker

$(function () {
    $('#datetimepicker-1, #datetimepicker-2').datetimepicker({
        // viewMode: 'years'
    });
});


//--- Add_New_Project

function add() {
    var tr = document.createElement('tr');
    var th = document.createElement('th');
    tbody.appendChild(tr, th, tbody.firstChild);
    console.log("norm");
}

