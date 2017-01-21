<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">


    <link href = "<c:url value = "/resources/css/bootstrap.css" />" rel = "stylesheet" >
    <link href = "<c:url value = "/resources/css/style.css" />" rel = "stylesheet" >

    <script src = "resources/js/jquery.min.js" type="text/javascript"></script>
    <script src = "resources/js/bootstrap.min.js" type="text/javascript"></script>





    <title>Title</title>
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
                <a class="navbar-brand" href="#">Project Administration</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" class="logOn" data-toggle="modal" data-target="#myModal">Log On</a></li>
                    <!-- <p class="navbar-text">Signed in as Roman Sierikov</p> -->
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navigation_end -->

    <!-- MainInfo_start -->
    <div class="container">
        <section class="col-lg-12 col-md-12 col-sm-12">

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
    <!-- MainInfo_end -->

    <!-- Footer_start -->
    <div class="container-fluid">
        <nav class="navbar navbar-inverse navbar-fixed-bottom">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <p class="navbar-text">Y.Hryshchenko © 2017</p>
                </li>
            </ul>
        </nav>
    </div>
    <!-- Footer_end -->

</body>
</html>
