<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main</title>
    <link href = "<c:url value = "/resources/css/project_manager.css" />" rel = "stylesheet" >
    <link href = "<c:url value = "/resources/css/bootstrap.css" />" rel = "stylesheet">
    <link href = "<c:url value = "/resources/css/bootstrap-datetimepicker.min.css" />" rel = "stylesheet">


    <script type="text/javascript" src = "/resources/js/jquery.min.js" ></script>
    <script type="text/javascript" src = "/resources/js/moment.js" ></script>
    <script type="text/javascript" src = "/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src = "/resources/js/bootstrap-datetimepicker.min.js" ></script>
    <script type="text/javascript" src = "/resources/js/script.js" ></script>
</head>
<body>

<!-- Navigation_start -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <!-- make menu for mobile version -->
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" id="name_sys">Task Manager</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" class="logOn" data-toggle="modal" data-target="#myModal1">Exit</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Navigation_end -->

<!-- MainInfo_start -->
<section class="container-fluid cf">
    <section class="container main">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Projects</div>
                <div class="panel-body">
                    <p>Click on Project Name to see more info.</p>
                </div>

                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Progress</th>
                    </tr>
                    </thead>
                    <tbody >
                    <c:forEach var = "project" items="${projectList}">
                    <tr>
                        <th>${project.id}</th>
                        <th><a  href="#" data-toggle="modal" data-target="#myModal" >${project.title}</a></th>
                        <th>${project.startDate}</th>
                        <th>${project.endDate}</th>
                        <th>
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="${project.progress}" aria-valuemin="0" aria-valuemax="100" style="width: ${project.progress}%;">
                                    ${project.progress}%
                                </div>
                            </div>
                        </th>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addNewSprint">Create new sprint</button> <!-- disabled="disabled" -->
            <button type="button" class="btn btn-primary cnt" data-toggle="modal" data-target="#addNewTask">Create new task</button> <!-- disabled="disabled" -->
        </div>
    </section>
</section>
<!-- MainInfo_end -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Project Name</h4>
            </div>
            <div class="modal-body">
                <div class="panel panel-default">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Progress</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>1</th>
                            <th>09.19.16</th>
                            <th>10.10.16</th>
                            <th>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                        60%
                                    </div>
                                </div>
                            </th>
                        </tr>
                    </table>
                </div>

                <div class="panel-group" id="accordion">
                    <div class="panel panel-default" id="accordion-1">
                        <div class="panel-heading sprint-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                    SPRINT NAME #1
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse">
                            <div class="panel-body-sprint">

                                <!-- Table -->
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Progress</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tbody">
                                    <tr>
                                        <th>1</th>
                                        <th>
                                            <div class="progress">
                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                                    60%
                                                </div>
                                            </div>
                                        </th>
                                    </tr>
                                    </tbody>
                                </table>

                                <!-- TASK_1 -->
                                <div class="panel-task ">
                                    <div class="panel-heading task-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion-1" href="#collapseTwo">
                                                TASK NAME #1
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <table class="table">
                                                <tbody >
                                                <!-- TASK_ID -->
                                                <tr>
                                                    <th>
                                                        <label>#</label>
                                                    </th>
                                                    <th>
                                                        <p>1</p>
                                                    </th>
                                                </tr>
                                                <!-- START_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>Start time</label>
                                                    </th>
                                                    <th>
                                                        <p>11.11.2017</p>
                                                    </th>
                                                </tr>
                                                <!-- END_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>End time</label>
                                                    </th>
                                                    <th>
                                                        <p>30.30.2017</p>
                                                    </th>
                                                </tr>
                                                <!-- ESTIMATED_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>Estimated Time</label>
                                                    </th>
                                                    <th>
                                                        <p>5 hours</p>
                                                    </th>
                                                </tr>
                                                <!-- MEMBERS -->
                                                <tr>
                                                    <th>
                                                        <label>Members</label>
                                                    </th>
                                                    <th>
                                                        <p>sasasasasa</p>
                                                    </th>
                                                </tr>
                                                <!-- STATUS -->
                                                <tr>
                                                    <th>
                                                        <label>Status</label>
                                                    </th>
                                                    <th>
                                                        <p><span class="label label-success">Done</span></p>
                                                    </th>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!-- END_TASK_1 -->

                                <!-- TASK_2 -->
                                <div class="panel-task">
                                    <div class="panel-heading task-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion-1" href="#collapseThree">
                                                TASK NAME #2
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <table class="table">
                                                <tbody >
                                                <!-- TASK_ID -->
                                                <tr>
                                                    <th>
                                                        <label>#</label>
                                                    </th>
                                                    <th>
                                                        <p>2</p>
                                                    </th>
                                                </tr>
                                                <!-- START_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>Start time</label>
                                                    </th>
                                                    <th>
                                                        <p>11.11.2017</p>
                                                    </th>
                                                </tr>
                                                <!-- END_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>End time</label>
                                                    </th>
                                                    <th>
                                                        <p>30.30.2017</p>
                                                    </th>
                                                </tr>
                                                <!-- ESTIMATED_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>Estimated Time</label>
                                                    </th>
                                                    <th>
                                                        <p>5 hours</p>
                                                    </th>
                                                </tr>
                                                <!-- MEMBERS -->
                                                <tr>
                                                    <th>
                                                        <label>Members</label>
                                                    </th>
                                                    <th>
                                                        <p>sasasasasa</p>
                                                    </th>
                                                </tr>
                                                <!-- STATUS -->
                                                <tr>
                                                    <th>
                                                        <label>Status</label>
                                                    </th>
                                                    <th>
                                                        <p><span class="label label-warning">In Process</span></p>
                                                    </th>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!-- END_TASK_2 -->

                                <!-- TASK_3 -->
                                <div class="panel-task">
                                    <div class="panel-heading task-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion-1" href="#collapseFour">
                                                TASK NAME #3
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseFour" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <table class="table">
                                                <tbody >
                                                <!-- TASK_ID -->
                                                <tr>
                                                    <th>
                                                        <label>#</label>
                                                    </th>
                                                    <th>
                                                        <p>3</p>
                                                    </th>
                                                </tr>
                                                <!-- START_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>Start time</label>
                                                    </th>
                                                    <th>
                                                        <p>11.11.2017</p>
                                                    </th>
                                                </tr>
                                                <!-- END_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>End time</label>
                                                    </th>
                                                    <th>
                                                        <p>30.30.2017</p>
                                                    </th>
                                                </tr>
                                                <!-- ESTIMATED_TIME -->
                                                <tr>
                                                    <th>
                                                        <label>Estimated Time</label>
                                                    </th>
                                                    <th>
                                                        <p>5 hours</p>
                                                    </th>
                                                </tr>
                                                <!-- MEMBERS -->
                                                <tr>
                                                    <th>
                                                        <label>Members</label>
                                                    </th>
                                                    <th>
                                                        <p>sasasasasa</p>
                                                    </th>
                                                </tr>
                                                <!-- STATUS -->
                                                <tr>
                                                    <th>
                                                        <label>Status</label>
                                                    </th>
                                                    <th>
                                                        <p><span class="label label-danger">To Do</span></p>
                                                    </th>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!-- END_TASK#3 -->

                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!------------------------------------------- Modals ------------------------------------------->

<!-- LOG_OUT -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Log out</h4>
            </div>
            <div class="modal-body">
                <h5>Do really want to exit?</h5>
            </div>
            <div class="modal-footer">
                <form action = "logout" method="GET">
                    <button type="submit" class="btn btn-primary">Log out</button>
                </form>
            </div>
            </form>
        </div>
    </div>
</div>
<!-- END_LOG_OUT -->

<!-- NEW_SPRINT -->
<div class="modal fade" id="addNewSprint" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Creating new sprint</h4>
            </div>
            <div class="modal-body">
                <form>
                    <!-- ID -->
                    <label>ID</label>
                    <input type="text"
                           class="form-control"
                           placeholder="1"
                           maxlength="100">

                    </br>
                    <!-- PROGRESS -->
                    <label>Progress</label>
                    </br>
                    <div class="progress">
                        <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
                            0%
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" onclick="addNewSprint()">Create new Sprint</button>
            </div>
        </div>
    </div>
</div>
<!-- END_NEW_SPRINT -->

<!-- NEW_TASK -->
<div class="modal fade" id="addNewTask" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Creating new task</h4>
            </div>
            <div class="modal-body">
                <form>
                    <!-- ID -->
                    <label>ID</label>
                    <input type="text"
                           class="form-control"
                           placeholder="1"
                           maxlength="100">

                    <br/>
                    <!-- sprintid -->
                    <label>Sprint</label>
                    <br/>
                    <select>
                        <option value="1">sprint1</option>
                        <option value="2">sprint2</option>
                        <option value="3">sprint13</option>
                    </select>

                    <br/>
                    <br/>
                    <!-- TASK_NAME -->
                    <label>Task Name</label>
                    <input type='text'
                           class="form-control"
                           placeholder="Testing Module#1"
                           maxlength="30">

                    <br/>
                    <!-- START_DATE -->
                    <label>Start Date</label>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker-1'>
                            <input type='text'
                                   class="form-control"
                                   placeholder="01/19/2017 12:47 AM"/>
                            <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                        </div>
                    </div>

                    <!-- END_DATE -->
                    <label>End Date</label>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker-2'>
                            <input type='text'
                                   class="form-control"
                                   placeholder="01/19/2017 12:47 AM"/>
                            <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                        </div>
                    </div>

                    <!-- ESTIMATED TIME -->
                    <label>Estimated Time</label>
                    <input type='text'
                           class="form-control"
                           placeholder="5 hours"
                           maxlength="30">
                    <br/>

                    <!-- MEMBERS -->
                    <label>Members</label>
                    <br/>
                    <div class="memders">
                        <!--               <input type="checkbox">
                                        <a href="#" tabindex="0" data-toggle="popover" data-trigger="focus" data-popover-content="#status">Oleg</a>
                                      </br>
                                      <input type="checkbox">
                                        <a href="#" tabindex="0" data-toggle="popover" data-trigger="focus" data-popover-content="#status">Misha</a>
                                      </br>
                                      <input type="checkbox">
                                        <a href="#" tabindex="0" data-toggle="popover" data-trigger="focus" data-popover-content="#status">Nikolaj</a>
                                      </br> -->
                        <select>
                            <option value="0">Oleg</option>
                            <option>Misha</option>
                            <option>Nikolaj</option>
                        </select>
                    </div>

                    <br/>
                    <!-- STATUS -->
                    <label>Status</label>
                    <br/>
                    <span class="label label-danger">To Do</span>

                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" onclick="addNewTask()">Create new Task</button>
            </div>
        </div>
    </div>
</div>
<!-- END_NEW_TASK -->


<div id="status" class="hidden pop">
    <div class="popover-heading">Status&nbsp;</div>
    <div class="popover-body">???<br>
        <div class="progress pr">
            <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                60%
            </div>
        </div>
    </div>
</div>


</body>
</html>
