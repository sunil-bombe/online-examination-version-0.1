<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.webwork.online.examination.service.impl.UserServiceImpl" %>
 <%@ page import="com.webwork.online.examination.service.UserService" %>
  <%@ page import="com.webwork.online.examination.model.User" %>
<%@ include file="include/header.jsp" %>
<br><br><br>
<div class="container">
  
  <main role="main">
    <div class="jumbotron">
      <div class="col-sm-8 mx-auto">
        <h1 class="text-center"> Details</h1>
       <%
       UserService saveUserServiceImpl = new UserServiceImpl();
       User userDetails = saveUserServiceImpl.getUser(user.getUserId());
       %>
        <form action="SaveUser" method="POST" >
       
        	 <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Full Name</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="fullname" name="userName" value="<% out.println(userDetails.getUserFullName()); %>" placeholder="Full Name" class="form-control" required="">
                                                    
                                                </div>
                                            </div>
                                                                    
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">E-mail ID</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="email" id="email" name="userEmail" value="<%= user.getUserEmail() %>" placeholder="Enter Email" class="form-control" required="">
                                                    
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="password-input" class=" form-control-label">Phone Number</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="mobilenumber" name="userPhone" value="<%= userDetails.getUserPhone() %>" placeholder="Mobile Number" class="form-control"  required="">
                                                    
                                                </div>
                                            </div>
                                            
                                             <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="password-input" class=" form-control-label">Birth Date</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="date" id="mobilenumber" name="userBirth" value=<% out.println(userDetails.getUserBirthDate()); %> class="form-control"  required="">
                                                </div>
                                            </div>
                                            
                                             <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="password-input" class=" form-control-label">College</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="mobilenumber" name="userCollege" value="<% out.println(userDetails.getUserCollege()); %>" placeholder="College" class="form-control"  required="">   
                                                </div>
                                            </div>
        	                     
                                        
                                          <div class="card-footer">
                                        <p style="text-align: center;"><button type="submit" name="submit" id="submit" class="btn btn-primary btn-sm">Submit
                                        </button></p>
        
        </form>
        
      </div>
    </div>
  </main>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.js"></script></body>

<%@ include file="include/footer.jsp" %>
</html>