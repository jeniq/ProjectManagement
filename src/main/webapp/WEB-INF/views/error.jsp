<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ERROR</title>
    <link href="<c:url value = "/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value = "/resources/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">

</head>
<body>

<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-12 image">
                <img src="/resources/images/error.jpg">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-12">
                <h1>OOPS.</h1>
                <h3>Seems something went wrong.</h3>
                <h4>${message}</h4>
                <a href="/">Return to main page</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>