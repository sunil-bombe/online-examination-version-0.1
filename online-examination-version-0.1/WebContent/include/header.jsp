<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.webwork.online.examination.model.User" %>
    <%
   User user = null;
   session = request.getSession(false);
  
    if(session!=null){
    	  user = (User) session.getAttribute("user");
    }
  
// 
//	if(null != userId){
//	RequestDispatcher	rd = request.getRequestDispatcher("index.jsp");
//	rd.forward(request,response);
//	}
  
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
 <a class="navbar-brand" href=""><img src="assets/logo/vecter.png" style="height:20px;"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
    <ul class="navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="CheckLogin"> <img src="assets/logo/name.png" style="height:25px;" /><span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="xyz.html">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown08">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="#" tabindex="-1" ><%= user.getUserEmail() %></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Logout?status=true" tabindex="-1">Logout</a>
      </li>
    </ul>
  </div>
</nav>