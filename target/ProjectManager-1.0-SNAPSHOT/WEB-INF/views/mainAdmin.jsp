<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Document</title>
      <link href = "<c:url value = "/resources/css/admin.css" />" rel = "stylesheet" >
      <link href = "<c:url value = "/resources/css/bootstrap.css" />" rel = "stylesheet">
      <link href = "<c:url value = "/resources/css/bootstrap-datetimepicker.min.css" />" rel = "stylesheet">


  <script type="text/javascript" src = "resources/js/jquery.min.js" ></script>
  <script type="text/javascript" src = "resources/js/moment.js" ></script>
  <script type="text/javascript" src = "resources/js/bootstrap.min.js"></script>
  <script type="text/javascript" src = "resources/js/bootstrap-datetimepicker.min.js" ></script>
  <script type="text/javascript" src = "resources/js/script.js" ></script>



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
      <a class="navbar-brand">Task Manager</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" class="logOn" data-toggle="modal" data-target="#myModal1">Admin</a></li>
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
        <div class="panel-heading">Members</div>
        <div class="panel-body">
          <p</p>
        </div>

        <!-- Table -->
        <table class="table">
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Surname</th>
              <th>Email</th>
              <th>Access type</th>
              <th>Position</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var = "currMember" items="${memberList}">
            <tr>
              <th>${currMember.id}</th>
              <th>${currMember.name}</th>
              <th>${currMember.surname}</th>
              <th>${currMember.email}</th>
              <th>${currMember.accessType.typeName}</th>
              <th>${currMember.position}</th>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <br>
              

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
              <th>Sostojanije</th>
            </tr>
          </thead>
          <tbody id="tbody">
          <c:forEach var="project" items="${projectList}">
            <tr>
              <th>${project.id}</th>
              <th><a  href="#" data-toggle="modal" data-target="#myModal" id="">${project.title}</a></th>
              <th>${project.startDate}</th>
              <th>${project.endDate}</th>
              <th>
                <div class="progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                  status(not ready)
                </div>
              </div>
              </th>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
         <button class="btn btn-primary" id="add_new_proj" data-toggle="modal" data-target="#addNewProject">Add new Project</button>
    </div>
  </section>
</section>
<!-- MainInfo_end -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Название Проекта</h4>
      </div>
      <div class="modal-body">
        <div class="panel panel-default">
          <table class="table">
            <thead>
              <tr>
                <th>#</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Sostojanije</th>
              </tr>
            </thead>
            <tbody>
            <tr>
              <th>1</th>
              <th>09.19.16</th>
              <th>10.10.16</th>
              <th>
                <div class="progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                  60%
                </div>
              </div>
              </th>
            </tr>

          </table>
        </div>

  <div class="panel-group" id="accordion">
    <div class="panel panel-default" id="accordion-1">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
            SPRINT NAME #1
          </a>
        </h4>
          </div>
          <div id="collapseOne" class="panel-collapse collapse">
            <div class="panel-body-sprint">
            <!-- TASK_1 -->  
            <div class="panel-task ">
              <div class="panel-heading ">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion-1" href="#collapseTwo">
                    TASK NAME #1
                  </a>
                </h4>
                  </div>
                  <div id="collapseTwo" class="panel-collapse collapse">
                    <div class="panel-body">
                      <p>#</p>
                      <p>Start time</p>
                      <p>End time</p>
                      <p>Members</p>
                      <p><span class="label label-success">Done</span></p>
                    </div>
                  </div>
                </div>
              <!-- TASK_2 -->
              <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion-1" href="#collapseThree">
                    TASK NAME #2
                  </a>
                </h4>
                  </div>
                  <div id="collapseThree" class="panel-collapse collapse">
                    <div class="panel-body">
                      <p>#</p>
                      <p>Start time</p>
                      <p>End time</p>
                      <p>Members</p>
                      <p><span class="label label-warning">In Process</span></p>
                    </div>
                  </div>
                </div>
              <!-- TASK_3 -->
              <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion-1" href="#collapseThree">
                    TASK NAME #3
                  </a>
                </h4>
                  </div>
                  <div id="collapseThree" class="panel-collapse collapse">
                    <div class="panel-body">
                      <p>#</p>
                      <p>Start time</p>
                      <p>End time</p>
                      <p>Members</p>
                      <p><span class="label label-danger">To Do</span></p>
                    </div>
                  </div>
                </div>

            </div>
          </div>
        </div>

    </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Закрыть</button>
      </div>
    </div>
  </div>
</div>


<!-- Add_New_Project -->

  <div class="modal fade" id="addNewProject" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Creating new project</h4>
      </div>
      <div class="modal-body">
        <form>
          <label>Name</label>
          <input type='text' 
                 class="form-control"
                 placeholder="Testing Module#1" 
                 maxlength="30">

          <br>
          <label>Start Date</label>
           <div class="form-group">
                <div class='input-group date' id='datetimepicker-1'>
                    <input type='text' 
                           class="form-control"  
                           placeholder="01/19/2017 12:47 AM"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
           <label>End Date</label>
           <div class="form-group">
                <div class='input-group date' id='datetimepicker-2'>
                    <input type='text' 
                           class="form-control" 
                           placeholder="01/19/2017 12:47 AM"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
            <label>Members</label>
              <div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
            <hr>
            <div id="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
              <span class="label label-default" id="m1" draggable="true" ondragstart="drag(event)">Oleg</span>
              <span class="label label-default" id="m2" draggable="true" ondragstart="drag(event)">Misha</span>
              <span class="label label-default" id="m3" draggable="true" ondragstart="drag(event)">Nikojaj</span>
            </div>

        <!-- </form> -->
      </form>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary" onclick="add()">Create</button>
      </div>
      </form>
    </div>
  </div>
</div>

<!-- Add_New_Project -->













<!-- Footer_start -->
<div class="container-fluid">
		<nav class="navbar navbar-inverse navbar-fixed-bottom">
			<ul class="nav navbar-nav navbar-left">
				<li>
					<p class="navbar-text">Y.Hryshchenko © 2017</p>
				</li>
			</ul>
			<ul class="nav  navbar-nav navbar-right">
				<!-- LinkedIn -->
				<li class="media-links">
					<a href="http://www.linkedin.com/shareArticle?mini=true&amp;url=https://simplesharebuttons.com" target="_blank">
        			<img src="https://simplesharebuttons.com/images/somacro/linkedin.png" id="icon" alt="LinkedIn" />
    				</a>
				</li>
				<!-- Facebook -->
				<li class="media-links">
					<a href="http://www.facebook.com/sharer.php?u=https://simplesharebuttons.com" target="_blank">
       				<img src="https://simplesharebuttons.com/images/somacro/facebook.png" id="icon" alt="Facebook" />
    				</a>
				</li>
				<!-- Email -->
				<li class="media-links">
    				<a href="mailto:?Subject=Simple Share Buttons&amp;Body=I%20saw%20this%20and%20thought%20of%20you!%20 https://simplesharebuttons.com">
        			<img src="https://simplesharebuttons.com/images/somacro/email.png" id="icon" alt="Email" />
    				</a>
				</li>
				<!-- Git -->
				<li class="media-links">
					<a href="http://www.facebook.com/sharer.php?u=https://simplesharebuttons.com" target="_blank">
       				<img src="https://simplesharebuttons.com/images/somacro/facebook.png" id="icon" alt="Facebook" />
    				</a>
				</li>
			</ul>
		</nav>
</div>
<!-- Footer_end -->

<!-- Modal_start -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Log off</h4>
      </div>
      <div class="modal-body">
      <h5>Do really want to exit?</h5>
      </div>
      <div class="modal-footer">
        <form action = "logout" method="GET">
        <button type="submit" class="btn btn-primary" >Log out</button>
        </form>
      </div>
      </form>
    </div>
  </div>
</div>
<!-- Modal_end -->



</body>
</html>
