<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main</title>

    <link href="<c:url value = "/resources/css/customer.css" />" rel="stylesheet">
    <link href="<c:url value = "/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value = "/resources/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">

    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/moment.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/resources/js/script.js"></script>

</head>
<body>

<!-- Navigation_start -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <!-- make menu for mobile version -->
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
                    <tbody>
                    <c:forEach var="project" items="${projectList}">
                        <tr>
                            <th>${project.id}</th>
                            <th>${project.title}</th>
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
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</section>
<!-- MainInfo_end -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">

</div>


<!-- Modal_start -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Exit</h4>
            </div>
            <div class="modal-body">
                <h5>Do you really want to exit? </h5>
            </div>
            <div class="modal-footer">
                <form action="/logout" method="GET">
                    <button type="submit" class="btn btn-primary">Log out</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Modal_end -->


</body>
</html>
