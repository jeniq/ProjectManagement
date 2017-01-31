<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">${project.title}</h4>
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
                        <th>${project.id}</th>
                        <th>${project.startDate}</th>
                        <th>${project.endDate}</th>
                        <th>
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="${project.progress}"
                                     aria-valuemin="0" aria-valuemax="100" style="width: ${project.progress}%;">
                                    ${project.progress}%
                                </div>
                            </div>
                        </th>
                    </tr>
                </table>
            </div>

            <div class="panel-group" id="accordion">
                <c:forEach var="sprint" items="${sprintList}">
                    <div class="panel panel-default" id="accordion-1">
                        <div class="panel-heading sprint-heading">
                            <a class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse${sprint.id}">
                                Sprint #${sprint.id}
                            </a>
                        </div>
                            <div class="panel-body-sprint">

                                <!-- Table -->
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Progress</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>
                                            <div class="progress">
                                                <div class="progress-bar" role="progressbar"
                                                     aria-valuenow="${sprint.progress}" aria-valuemin="0"
                                                     aria-valuemax="100" style="width: ${sprint.progress}%;">
                                                        ${sprint.progress}%
                                                </div>
                                            </div>
                                        </th>
                                    </tr>
                                    </tbody>
                                </table>

                                <!-- TASK_1 -->
                                <div class="panel-task ">
                                    <c:forEach var="task" items="${sprint.taskList}">
                                        <div class="panel-heading task-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordion-1"
                                                    href="#collapse${task.id}">
                                                        ${task.title}
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapse${task.id}" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <table class="table">
                                                    <tbody>
                                                    <!-- TASK_ID -->
                                                    <tr>
                                                        <th>
                                                            <label>ID</label>
                                                        </th>
                                                        <th>
                                                            <p>${task.id}</p>
                                                        </th>
                                                    </tr>
                                                    <!-- START_TIME -->
                                                    <tr>
                                                        <th>
                                                            <label>Start time</label>
                                                        </th>
                                                        <th>
                                                            <p>${task.startDate}</p>
                                                        </th>
                                                    </tr>
                                                    <!-- END_TIME -->
                                                    <tr>
                                                        <th>
                                                            <label>End time</label>
                                                        </th>
                                                        <th>
                                                            <p>${task.endDate}</p>
                                                        </th>
                                                    </tr>
                                                    <!-- ESTIMATED_TIME -->
                                                    <tr>
                                                        <th>
                                                            <label>Estimated Time</label>
                                                        </th>
                                                        <th>
                                                            <p>${task.estimateTime}</p>
                                                        </th>
                                                    </tr>
                                                    <!-- STATUS -->
                                                    <tr>
                                                        <th>
                                                            <label>Status</label>
                                                        </th>
                                                        <th>
                                                            <p><span class="label label-success">
                                                                    <c:if test="${task.isDone}">Done</c:if>
                                                                    <c:if test="!${task.isDone}">Not done</c:if>
                                                                </span>
                                                            </p>
                                                        </th>
                                                    </tr>
                                                    <!-- MEMBERS -->
                                                    <tr>
                                                        <th>
                                                            <label>Members</label>
                                                        </th>
                                                        <th>
                                                            <c:forEach var="executor" items="${task.employeeList}">
                                                                <p>${executor.name} ${executor.surname}: ${executor.position.posName}</p>
                                                            </c:forEach>
                                                        </th>
                                                    </tr>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <!-- END_TASK_1 -->

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <div class="modal-footer">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
