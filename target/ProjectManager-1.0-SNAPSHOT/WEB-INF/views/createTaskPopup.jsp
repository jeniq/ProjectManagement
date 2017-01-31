<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Create new task</h4>
        </div>
        <form:form method="POST" commandName="task" action="addTask">
            <div class="modal-body">
                <!-- ID -->
                <label>ID</label>
                <form:input type="text"
                            path="id"
                            class="form-control"
                            value="${id}"
                            maxlength="100"
                            disabled="true"/>

                <br/>
                <!-- sprintid -->
                <label>Sprint</label>
                <br/>
                <select name="sprint">
                    <c:forEach var="sprint" items="${sprintList}">
                        <option value="${sprint.id}">${sprint.id} Project: ${sprint.projectId}</option>
                    </c:forEach>
                </select>

                <br/>
                <br/>
                <!-- TASK_NAME -->
                <label>Task Name</label>
                <form:input type="text"
                            path="title"
                            name="title"
                            class="form-control"
                            placeholder="Testing Module#1"
                            maxlength="30" required="true"
                />

                <br/>
                <!-- START_DATE -->
                <label>Start Date</label>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker-1'>
                        <form:input type='text'
                                    path="startDate"
                                    class="form-control"
                                    placeholder="01/19/2017"
                                    required="true"/>
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>

                <!-- END_DATE -->
                <label>End Date</label>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker-2'>
                        <form:input type='text'
                                    path="endDate"
                                    class="form-control"
                                    placeholder="01/19/2017"
                                    required="true"/>
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>

                <!-- ESTIMATED TIME -->
                <label>Estimated Time</label>
                <form:input type="text"
                            path="estimateTime"
                            class="form-control"
                            placeholder="5 (hours)"
                            maxlength="30"
                            required="true"/>
                <br/>

                <!-- MEMBERS -->
                <label>Members</label>
                <br/>
                <div class="members">
                    <select name="employee">
                        <c:forEach var="member" items="${employeeList}">
                            <option value="${member.id}">${member.name} ${member.surname}</option>
                        </c:forEach>
                    </select>
                </div>

                <br/>
                <!-- STATUS -->
                <label>Status</label>
                <br/>
                <span class="label label-danger">To Do</span>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Create new Task</button>
            </div>
        </form:form>
    </div>
</div>