<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/resources/js/script.js"></script>
<!-- CREATING_MEMBER -->
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel1">Create member</h4>
        </div>
        <form:form method="POST" commandName="newMember" action="addMember">
            <div class="modal-body">
                <br/>
                <label>Name</label>
                <form:input type='text'
                            path="name"
                            class="form-control"
                            placeholder="Vasia"
                            required = "true"
                            maxlength="30"/>

                <br/>
                <label>Surname</label>
                <form:input type='text'
                            path="surname"
                            class="form-control"
                            placeholder="Pupkin"
                            required = "true"
                            maxlength="30"/>

                <br/>
                <label>Email</label>
                <form:input type='text'
                            path="email"
                            class="form-control"
                            placeholder="vasia@mail.ua"
                            required = "true"
                            maxlength="30"/>

                <br/>
                <label>Password</label>
                <form:input type='text'
                            path="password"
                            class="form-control"
                            placeholder="12345"
                            required = "true"
                            maxlength="30"/>

                <label>Access type</label>
                <br/>
                <select name="accessType">
                    <c:forEach var="type" items="${accessTypeList}">
                        <option value="${type.id}">${type.typeName}</option>
                    </c:forEach>
                </select>
                <br/>
                <label>Position</label>
                <br/>
                <select name="position">
                    <c:forEach var="position" items="${positionList}">
                        <option value="${position.id}">${position.posName}</option>
                    </c:forEach>
                </select>

            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form:form>
    </div>
</div>

