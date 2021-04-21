<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"

    %>
    
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.webwork.online.examination.service.QuestionPaperService" %>
 <%@ page import="com.webwork.online.examination.service.impl.QuestionPaperServiceImpl" %>
  <%@ page import="com.webwork.online.examination.model.QuestionPaper" %>
  <%!
  QuestionPaperService questionPaperService = new QuestionPaperServiceImpl();
  %>
  <%
  String subject = request.getParameter("subject");
   
  %>
<!DOCTYPE html>
<html>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
 <a class="navbar-brand" href=""><b><p id="timer"></p></b></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="CheckLogin"><img src="assets/logo/name.png" style="height:20px;"/><span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
      <!--  <a class="nav-link btn btn-primary btn-sm" href="user-feedback.jsp" tabindex="-1">submit</a>  -->
        
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" tabindex="-1" aria-disabled="true"></a>
      </li>
       <li class="nav-item">
       <a class="nav-link" href="#"></a>
      </li>
    </ul>
  </div>
</nav>
<br><br><br>
<div class="container">
  <main role="main">
    <div class="jumbotron">
      <div class="col-sm-11 mx-auto" >
       
        <%
        int count = 0;
        
       	ArrayList<QuestionPaper> questionPaperList =(ArrayList<QuestionPaper>) request.getAttribute("questionPaper");
       	for(QuestionPaper question: questionPaperList){
       		count++;
       		%>
       	<div class="modal-content row" style="padding:15px 25px;  margin:0px;">
       		<h3>Q <% out.print(count); %>. <% out.print(question.getQuestion());%>  <button class="btn btn-danger btn-sm">Delete</button></h3>
                                            <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label>  A. <% out.print(question.getA());%></label>
                                                    </div> 
                                                </div>
                                            </div>

                                             <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label>  B. <% out.print(question.getB());%></label>
                                                    </div> 
                                                </div>
                                            </div>

                                             <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label>  C. <% out.print(question.getC()); %></label>
                                                    </div> 
                                                </div>
                                            </div>
                      
                                             <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label>  D. <% out.print(question.getD());%></label>
                                                    </div> 
                                                </div>
                                            </div>
                                            
                                            <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label>  Answer. <% out.print(question.getAnswer());%></label>
                                                    </div> 
                                                </div>
                                            </div>
                                            
                                            
                                            
                                    <!--   <p style="text-align: center;"><button  id="save" class="btn btn-primary btn-sm" >Save</button></p> -->
         <!-- all about questions -->
         
        </div>
        <br>
       	<%
       	}
       %>
        
        
       <!-- below portion -->
      </div>
    </div>
  </main>
</div>

</body>
</html>