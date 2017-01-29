<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

    <link href = "<c:url value = "/resources/css/bootstrap.css" />" rel = "stylesheet" >
    <link href = "<c:url value = "/resources/css/style.css" />" rel = "stylesheet" >

    <script src = "../resources/js/jquery.min.js" type="text/javascript"></script>
    <script src = "../resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../resources/js/script.js" type="text/javascript"></script>

    <title>Welcome</title>
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
                <li><a href="#" class="logOn" data-toggle="modal" data-target="#help">Help</a></li>
                <!-- <p class="navbar-text">Signed in as Roman Sierikov</p> -->
            </ul>
        </div>
    </div>
</nav>
<!-- Navigation_end -->

<!-- MainInfo_start -->
<div class="container-fluid">
    <div class="container c_main">
        <section class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-12">
            <form:form method="POST" commandName="member" action="check-member">
                <form:input
                        path = "email"
                        type="email"
                        name="email"
                        class="form-control email"
                        placeholder="Email"
                        maxlength="30" />
                <br>

                <form:input
                        path = "password"
                        type="password"
                        name="pass"
                        class="form-control pass"
                        placeholder="Password"
                        maxlength="20" />
                <!-- </form> -->
                <div class="modal-footer">
                    <p align="left" id="errors" >${message}</p>
                    <button type="submit" class="btn btn-primary">Log in</button>
                </div>
            </form:form>

        </section>
    </div>
</div>
<!-- MainInfo_end -->

<!-- Help -->
<div class="modal fade" id="help" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header mh">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Help</h4>
            </div>
            <div class="modal-body">
                <div class="row hr">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <label>Position</label>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <label>Email</label>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <label>Password</label>
                    </div>
                </div>
                <!-- Admin -->
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <label>Admin</label>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <p>admin@gmail.com</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <p>admin</p>
                    </div>
                </div>
                <!-- Employee -->
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <label>Employee</label>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <p>gr.yevhen@gmail.com</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <p>12345</p>
                    </div>
                </div>
                <!-- Project Manager -->
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <label>Project Manager</label>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <p>roman.opeida@gmail.com</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <p>12345</p>
                    </div>
                </div>
                <!-- Customer -->
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <label>Customer</label>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <p>gr.yevhen@gmail.com</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <p>12345</p>
                    </div>
                </div>

            </div>
            </form>
        </div>
    </div>
</div>
<!-- End_Help -->

<!-- Footer_start -->
<div class="container-fluid">
    <nav class="navbar navbar-inverse navbar-fixed-bottom">
        <ul class="nav navbar-nav navbar-left">
            <li>
                <p class="navbar-text">Yevhen Hryshchenko © 2017</p>
            </li>
        </ul>
    </nav>
</div>
<!-- Footer_end -->

</body>
</html>
