//--- DateTimePicker

$(function () {
    $('#datetimepicker-1, #datetimepicker-2').datetimepicker({
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

$(function () {
    $("[data-toggle=popover]").popover({
        html: true,
        content: function () {
            var content = $(this).attr("data-popover-content");
            return $(content).children(".popover-body").html();
        },
        title: function () {
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
            $('#sprintDetails').html(d).modal();
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

    $('.createMemberBtn').on('click', function (e) {
        $.ajax($(e.currentTarget).attr('href')).done(function (d) {
            $('#createMember').html(d).modal();
        });
        return false;
    });

});


//---- Select status for task

function GetData() {
    var selind = document.getElementById("status").options.selectedIndex;
    var val = document.getElementById("status").options[selind].value;
    // var text = document.getElementById("status").options[selind].text;
    console.log("Value= " + val);

    var inProgress = 1,
        done = 2;

    if (val == inProgress) {
        // console.log('on_progress');
        // console.log('Sum' + "=" + val+inProgress);
        $("#to_do").addClass("hide");
        $("#done").addClass("hide");
        $("#on_progress").removeClass("hide");
    } else if (val == done) {
        console.log('done');
        $("#to_do").addClass("hide");
        $("#on_progress").addClass("hide");
        $("#done").removeClass("hide");
    } else {
        alert("error");
    }
}

//----- Time Query for the task


function check() {
    var box = document.getElementById("checkbox").checked;
    var tr = new Boolean(true);
    console.log(box);

    if (box == tr) {
        console.log('Checked');
        $('#reguest_label, #reguest_btn').removeClass('hide');
    } else {
        console.log('UnChecked');
        $('#reguest_label, #reguest_btn').addClass('hide');
    }
}

function close() {
    console.log("Cancel");
    $("#projectInfo").modal('show');
}

function success() {
    console.log("Success!");
    $("#projectInfo").modal('hide');
}












