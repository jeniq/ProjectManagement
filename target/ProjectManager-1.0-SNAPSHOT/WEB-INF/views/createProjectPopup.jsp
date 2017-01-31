<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/resources/js/script.js"></script>
<!-- CREATING_PROJECT -->
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel1">Create new project</h4>
        </div>
        <form:form method="POST" commandName="project" action="addProject">
            <div class="modal-body">
                <select name="customer">
                    <c:forEach var="customer" items="${customerList}">
                        <option value="${customer.id}">${customer.name} ${customer.surname}</option>
                    </c:forEach>
                </select>
                <br/>
                <label>Name</label>
                <form:input type='text'
                            path="title"
                            class="form-control"
                            placeholder="Project"
                            maxlength="30"/>

                <br/>

                <label>Start Date</label>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker-4'>
                        <form:input type='text'
                                    path="startDate"
                                    class="form-control"
                                    placeholder="01/01/2017"/>
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>

                <label>End Date</label>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker-5'>
                        <form:input type='text'
                                    path="endDate"
                                    class="form-control"
                                    placeholder="01/01/2017"/>
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>

                <label>Project Manager</label>
                <br/>
                <select name="Project Manager">
                    <c:forEach var="pm" items="${projectManagerList}">
                        <option value="${pm.id}">${pm.name} ${pm.surname}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form:form>
    </div>
</div>

