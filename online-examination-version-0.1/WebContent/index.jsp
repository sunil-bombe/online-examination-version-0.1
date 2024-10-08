<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    if(null != session.getAttribute("userId")){
    	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
    	rd.forward(request,response);
    }else if(null != session.getAttribute("adminId")){
    	RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
    	rd.forward(request,response);
    }else{
    	%>
    	<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>studyonline.epizy.com</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

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
      
      html,
body {
  height: 100%;
}

body {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
   
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  
  <body class="text-center">
    <form action="Login" class="form-signin" method="POST">
  <img class="mb-4" src="assets/logo/logo.png" alt=""  height="100">
<!-- <h1 class="text-center"><strong>studyonline.epizy.com</strong></h1> -->
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
  
  <label for="inputEmail" class="sr-only">Email address</label>
  <input type="email" name="username" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
  
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" name="userpwd" id="inputPassword" class="form-control" placeholder="Password" required>
  
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  
  <button type="submit" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted">
  <a href="ForgotPassword" class="text-center">Forgot Password.?</a><br>
  &copy;<a href="http://www.sunilbombe.epizy.com" target="_blank">SkillScore.com</a>  2024</p>
  
</form>
 

</body>
</html>
    	
    	
    	<%
    }
    %>
