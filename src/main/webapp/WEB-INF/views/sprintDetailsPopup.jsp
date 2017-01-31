<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Modal -->
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">${sprint.id}</h4>
        </div>
        <div class="modal-body">

            <!-- TASK -->
            <c:forEach var="task" items="${taskList}">
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
                                <tbody>
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
                                        <br/>
                                        <p class="time_query">
                                            <input type="checkbox" id="checkbox" onclick="check()"> Need more time?
                                        </p>

                                        <div class="reqlabel hide" id="reguest_label">
                                            <label>Request more time</label>
                                            <input type='text'
                                                   class="form-control req"
                                                   placeholder="5 hours"
                                                   maxlength="2">
                                        </div>
                                    </th>
                                    <th>
                                        <p>${task.estimateTime}</p>
                                        <button class="btn btn-primary hide" id="reguest_btn"
                                                onclick="requestTime()">Send request
                                        </button>
                                    </th>
                                </tr>
                                <!-- MEMBERS -->
                                <tr>
                                    <th>
                                        <label>Members</label>
                                    </th>
                                    <th>
                                        <c:forEach var="executor" items="${task.employeeList}">
                                            <p>${executor.name} ${executor.surnmaename} ${executor.position.posName}</p>
                                        </c:forEach>
                                    </th>
                                </tr>
                                <!-- STATUS -->
                                    <tr>
                                        <th>
                                            <label>Status</label>
                                        </th>
                                        <th>
                                            <form:form method="POST" action="updateTaskStatus${task.id}">
                                            <div class="row">
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                                    <select id="status" name = "status">
                                                        <option value="false">In Process</option>
                                                        <option value="true">Done</option>
                                                    </select>
                                                </div>
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                                    <p>
                                                        <c:if test="!${task.isDone}"><span
                                                                class="label label-warning hide" id="on_progress">In Process</span></c:if>
                                                        <c:if test="${task.isDone}"><span
                                                                class="label label-success hide"
                                                                id="done">Done</span></c:if>
                                                    </p>
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-primary upstat">Update status
                                            </button>
                                            </form:form>
                                        </th>
                                    </tr>
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

