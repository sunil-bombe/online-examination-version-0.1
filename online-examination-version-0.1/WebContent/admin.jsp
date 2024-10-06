<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.List" %>
      <%@ page import="com.webwork.online.examination.service.UserService" %>
 <%@ page import="com.webwork.online.examination.service.impl.UserServiceImpl" %>
 <%@ page import="com.webwork.online.examination.model.User" %>
     <%!
  UserService userService = new UserServiceImpl();
 
  
  %>
    <%
   session = request.getSession();
	if(session.getAttribute("adminId")==null){
	RequestDispatcher	rd = request.getRequestDispatcher("index.html");
	rd.forward(request,response);
	}
	

  %> 
  
 
<!doctype html>
<html lang="en">
  <head>
  	<meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>studyonline.epizy.com</title>
     <link rel="shortcut icon" href="assets/logo/so.png" type="image/x-icon">

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/navbars/">

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/navbar.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap.js"></script>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="navbar.css" rel="stylesheet">
  </head>
  <body>
 

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
 <a class="navbar-brand" href=""><img src="assets/logo/vecter.png" style="height:60px;"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
    <ul class="navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="CheckLogin"> <img src="assets/logo/name.png" style="height:25px;" /><span class="sr-only">(current)</span></a>
      </li>
      
     <!--  <li class="nav-item">
        <a class="nav-link" href="xyz.html">ADMIN</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="xyz.html">USERS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="xyz.html">SUBJECTS</a>
      </li> -->
      
      <%-- <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown08">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" tabindex="-1" ><%= session.getAttribute("adminName") %></a>
      </li> --%>
       <li class="nav-item">
        <a class="nav-link" href="Logout?status=true" tabindex="-1">Logout</a>
      </li>
    </ul>
  </div>
</nav>
<br><br><br>
<!--  body main container -->
<div class="container">
  
  <main role="main">
    <div class="jumbotron">
      <div class="col-sm-12 mx-auto">
     	
        
          <h2 class="mt-4 text-center">All Student List</h2>
           <a href="admin-add-user.jsp"><button class="btn btn-success">Add User</button></a>
          <a class="btn btn-primary" href="subject.jsp" role="button">Subjects &raquo;</a>  
          <%
          int count = 0;
          List<User> userList = userService.getAllUser("User");
          for(User user: userList){
        	  count++;
			        	  %>
			   <div class="row bg-light shadow" style=" margin:10px;">
			     <div class="col-sm-8">
			     <table class="table table-responsive">
			   <tr>
			    <td><h5><%= count %></h4></td>
			   <td><h5><%= user.getUsername() %></h5></td>
			   <td><h5><%= user.getUserStatus() %></h5></td>
			   <td><h5><%= user.getUserType() %></h5></td>
			   </tr>
			   </table>  
			   </div>
			   <div class="col-sm-4">
			   <table  class="table table-responsive">
			   <tr>
			    <td><h5><a href="user-details.jsp?userId=<%= user.getUserId() %>"  class="btn btn-primary btn-sm">View</a></h5></td>
			    <td><h5><a href="deleteUser?userId=<%= user.getUserId() %>" class="btn btn-danger btn-sm">Delete</a></h5></td>
			   </tr>
			   </table>
			   </div>
			   
			    
			   </div>
        	  
        	  <%
          }
          %>   
        
        
      </div>
    </div>
 
    
  </main>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.js"></script></body>
 

</body>
</html>