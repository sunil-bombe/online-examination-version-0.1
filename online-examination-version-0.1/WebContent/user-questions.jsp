<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"

    %>
    
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.webwork.online.examination.service.QuestionPaperService" %>
 <%@ page import="com.webwork.online.examination.service.impl.QuestionPaperServiceImpl" %>
  <%@ page import="com.webwork.online.examination.model.QuestionPaper" %>
  <%@ page import="com.webwork.online.examination.model.User" %>
  <%!
  QuestionPaperService questionPaperService = new QuestionPaperServiceImpl();
  User user = null;
  %>
  <%
  session = request.getSession(false);
  if(null!=session){
	  user = (User) session.getAttribute("user");
  }
  int userId = user.getUserId();
  if(questionPaperService.isTestGivenBefore(userId)){
	  response.sendRedirect("thank-you.jsp");
  } 
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
<script type="text/javascript">
var count = (1/2)*(60*60); //set hours
var counter = setInterval(timer, 1000); //1000 will  run it every 1 second

function timer() {
    count = count - 1;
    if (count == -1) {
        clearInterval(counter);
        return;
    }

    var seconds = count % 60;
    var minutes = Math.floor(count / 60);
    var hours = Math.floor(minutes / 60);
    minutes %= 60;
    hours %= 60;
    if(count!=0){
      var setTitle=hours + " : " + minutes + " : " + seconds;
      document.title =setTitle;
    document.getElementById("timer").innerHTML = hours + " H : " + minutes + " M :: " + seconds+" S";
    }else{
    document.getElementById("timer").innerHTML ="EXPIRED";
    document.title ="session time out";
    alert('Your time is Expired');
    window.location("user-feedback.jsp");
    } // watch for spelling
}
</script>
<form action="SubmitAnswer" method="POST">
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
        <button type="submit" name="submit" class="btn btn-sm btn-primary">Submit</button>
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
       		<h3>Q <% out.print(count); %>. <% out.print(question.getQuestion());%></h3>
                                            <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label><input type="radio" name="<% out.print(question.getqID()); %>"  value="A">  A. <% out.print(question.getA());%></label>
                                                    </div> 
                                                </div>
                                            </div>

                                             <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label><input type="radio" id="answer"  name="<% out.print(question.getqID()); %>" value="B" >  B. <% out.print(question.getB());%></label>
                                                    </div> 
                                                </div>
                                            </div>

                                             <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label><input type="radio" id="answer"  name="<% out.print(question.getqID()); %>" value="C" >  C. <% out.print(question.getC());%></label>
                                                    </div> 
                                                </div>
                                            </div>
                      
                                             <div class="row form-group">
                                                <div class="col-md-12 ">
                                                    <div class="checkbox">
                                                        <label><input type="radio" id="answer" name="<% out.print(question.getqID()); %>" value="D"  >  D. <% out.print(question.getD());%></label>
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
</form>
</body>
</html>