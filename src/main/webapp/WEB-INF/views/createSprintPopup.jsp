<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Creating new sprint</h4>
        </div>
        <form:form method="POST" commandName="sprint" action="addSprint">
            <div class="modal-body">
                <!-- ID -->
                <label>ID</label>
                <form:input type="text"
                            path="id"
                            name="id"
                            class="form-control"
                            value="${id}"
                            maxlength="100"/>
                <br/>
                <div>
                    <select name="projectId">
                        <c:forEach var="project" items="${projectList}">
                            <option value="${project.id}">${project.id} ${project.title}</option>
                        </c:forEach>
                    </select>
                </div>

                <br/>
                <!-- PROGRESS -->
                <label>Progress</label>
                <br/>
                <div class="progress">
                    <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
                         style="width: 0%;">
                        0%
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Create new Sprint</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
