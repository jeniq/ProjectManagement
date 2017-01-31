// $('#myModal').on('shown.bs.modal', function () {
//   $('#myInput').focus()
// })

// $(function () {
//   $('[data-toggle="tooltip"]').tooltip()
// })
//

// jQuery(document).ready(function(){
//     console.log("hello");
//     alert("hello");
// });

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
    $('#datetimepicker-3').datetimepicker({
        viewMode: 'days'
    });
    $('#datetimepicker-4, #datetimepicker-5').datetimepicker({
        viewMode: 'days',
        format: 'YYYY/MM/DD'
    })
});


//--- More info about project

$(function(){
    $("[data-toggle=popover]").popover({
        html : true,
        content: function() {
            var content = $(this).attr("data-popover-content");
            return $(content).children(".popover-body").html();
        },
        title: function() {
            var title = $(this).attr("data-popover-content");
            return $(title).children(".popover-heading").html();
        }
    });

    $('.project-details').on('click', '.details', function (e) {
        $.ajax($(e.currentTarget).attr('href')).done(function (d) {
            $('#projectInfo').html(d).modal();
        });
        return false;
    });

    $('.sprint-details').on('click', '.details', function (e) {
        $.ajax($(e.currentTarget).attr('href')).done(function (d) {
            $('#myModal').html(d).modal();
        });
        return false;
    });

    $('.createProjectBtn').on('click', function (e) {
        $.ajax($(e.currentTarget).attr('href')).done(function (d) {
            $('#createProject').html(d).modal();
        });
        return false;
    });

    $('.createTaskBtn').on('click', function (e) {
        $.ajax($(e.currentTarget).attr('href')).done(function (d) {
            $('#addNewTask').html(d).modal();
        });
        return false;
    });

    $('.createSprintBtn').on('click', function (e) {
        $.ajax($(e.currentTarget).attr('href')).done(function (d) {
            $('#addNewSprint').html(d).modal();
        });
        return false;
    });

});




//---- Select status for task

function GetData() {
    var selind = document.getElementById("status").options.selectedIndex;
    var val= document.getElementById("status").options[selind].value;
    // var text = document.getElementById("status").options[selind].text;
    console.log("Value= " + val);

    var inProgress = 1,
        done = 2;

    if(val==inProgress){
        // console.log('on_progress');
        // console.log('Sum' + "=" + val+inProgress);
        $("#to_do").addClass("hide");
        $("#done").addClass("hide");
        $("#on_progress").removeClass("hide");
    } else if (val==done){
        console.log('done');
        $("#to_do").addClass("hide");
        $("#on_progress").addClass("hide");
        $("#done").removeClass("hide");
    } else {
        alert("error");
    }
}

function addNewProjectManager() {
    var selind = document.getElementById("man").options.selectedIndex;
    var val = document.getElementById('man').options[selind].value;
    var text = document.getElementById("man").options[selind].text;

    console.log(text);

    $('#project_manager').text(text)
}

//----- Add new members to the task

function addNewMember(){
    // var val = document.getElementById('1').text;
    // var vall = document.getElementById('1').value;

    var member = document.getElementById("member").value;
    // var chosen_member = document.getElementById("chosenMember").value;

    $("#chosenMember").val(member);
    console.log(member);


}

//----- Time Query for the task


function check(){
    var box = document.getElementById("checkbox").checked;
    var tr = new Boolean(true);
    console.log(box);

    if(box == tr){
        console.log('Checked');
        $('#reguest_label, #reguest_btn').removeClass('hide');
    } else {
        console.log('UnChecked');
        $('#reguest_label, #reguest_btn').addClass('hide');
    }
}



//---- Deleting Project (Admin)

function deleting(){
    console.log("deleting");
    $("#projectInfo").modal('hide');
}

function close(){
    console.log("Cancel");
    $("#projectInfo").modal('show');
}

function success(){
    console.log("Success!");
    $("#projectInfo").modal('hide');
}












