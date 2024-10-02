<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.webwork.online.examination.model.User"%>
<%@ include file="include/header.jsp"%>
<%! User user = null; %>
<%
session = request.getSession(false);
if(null!=session){
	 user = (User) session.getAttribute("user");
}
%>

<br>
<br>
<br>
<div class="container">

	<main role="main">
		<div class="jumbotron">
			<div class="col-sm-8 mx-auto">
				<h1 class="text-center">Feedback</h1>

				<form action="saveFeedback" method="post">

					<div class="row form-group">
						<div class="col col-md-3">
							<label for="text-input" class=" form-control-label">Full
								Name</label>
						</div>
						<div class="col-12 col-md-9">
							<input type="text" id="fullname" name="userName"
								placeholder="Full Name" class="form-control" required="">

						</div>
					</div>

					<div class="row form-group">
						<div class="col col-md-3">
							<label for="email-input" class=" form-control-label">E-mail
								ID</label>
						</div>
						<div class="col-12 col-md-9">
							<input type="email" id="email" name="userEmail"
								value="<%= user.getUserEmail() %>" placeholder="Enter Email"
								class="form-control" required="">

						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label for="password-input" class=" form-control-label">Phone
								Number</label>
						</div>
						<div class="col-12 col-md-9">
							<input type="text" id="mobilenumber" name="userPhone"
								value="<%= user.getUserPhone() %>" placeholder="Mobile Number"
								class="form-control" required="">

						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label for="textarea-input" class=" form-control-label">
								If you have specific feedback,Please write to us...</label>
						</div>
						<div class="col-12 col-md-9">
							<textarea id="address" rows="9" placeholder="Additional comments"
								name="userComment" required="" class="form-control" required=""></textarea>
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label for="password-input" class=" form-control-label">How
								satisfied you with our Service?</label>
						</div>
						<div class="col-12 col-md-9">
							<ul>

								<li><input type="radio" name="userRemark" value="excellent"
									id="excellent" required> <label for="excellent">excellent</label>

								</li>

								<li><input type="radio" name="userRemark" value="good"
									id="good"> <label for="good"> good</label>
									<div class="check w3ls"></div></li>
								<li><input type="radio" name="userRemark" value="neutral"
									id="neutral"> <label for="neutral">neutral</label>
									<div class="check wthree"></div></li>
								<li><input type="radio" name="userRemark" value="poor"
									id="poor"> <label for="poor">poor</label>
									<div class="check w3_agileits"></div></li>
							</ul>
						</div>
					</div>





					<p style="text-align: center;">
						<button type="submit" name="submit" id="submit"
							class="btn btn-primary btn-sm">Submit</button>
						<a href="thank-you.jsp" class="btn btn-primary btn-sm">Next</a>
					</p>

				</form>

			</div>
		</div>
	</main>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="../assets/dist/js/bootstrap.bundle.js"></script>
</body>
<%@ include file="include/footer.jsp"%>
</html>