<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">${sprint.id}</h4>
            </div>
            <div class="modal-body">

                <!-- TASK -->
                <c:forEach var="task" items="${sprint.taskList}">
                <div class="panel-task">
                    <div class="panel-heading task-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion-1" href="#collapseFour">
                                ${task.title}
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
                                        </br>
                                        <p class="time_query">
                                            <input type="checkbox" id="checkbox" onclick="check()">  Need more time?
                                        </p>

                                        <div class="reqlabel hide" id="reguest_label">
                                            <label >Request more time</label>
                                            <input type='text'
                                                   class="form-control req"
                                                   placeholder="5 hours"
                                                   maxlength="2">
                                        </div>
                                    </th>
                                    <th>
                                        <p>${task.estimateTime}</p>
                                        <button class="btn btn-primary hide" id="reguest_btn" onclick="requestTime()">Send request</button>
                                    </th>
                                </tr>
                                <!-- MEMBERS -->
                                <tr>
                                    <th>
                                        <label>Members</label>
                                    </th>
                                    <th>
                                        <c:forEach var = "executor" items="${task.employeeList}">
                                            <p>${executor.name} ${executor.surnmaename} ${executor.position.posName}</p>
                                        </c:forEach>
                                    </th>
                                </tr>
                                <!-- STATUS -->
                                <form>
                                    <tr>
                                        <th>
                                            <label>Status</label>
                                        </th>
                                        <th>
                                            <div class="row">
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                                    <select id="status">
                                                        <option value="1">In Process</option>
                                                        <option value="2">Done</option>
                                                    </select>
                                                </div>
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                                    <p>
                                                        <span class="label label-danger"       id="to_do">To Do</span>
                                                        <span class="label label-warning hide" id="on_progress">In Process</span>
                                                        <span class="label label-success hide" id="done">Done</span>
                                                    </p>
                                                </div>
                                            </div>
                                            <button type="button" class="btn btn-primary upstat" onclick="GetData()">Update status</button>
                                        </th>
                                    </tr>
                                </form>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <!-- END_TASK -->

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

