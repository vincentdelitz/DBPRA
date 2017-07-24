<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Festival Database</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="./header.jsp" %>
 <div class="container-fluid">
		<div class="row">
			<div class="col-md-10">
	<% if (request.getAttribute("error1") != null) { %>
		<h3>There is no employee with the following name: <%=request.getParameter("firstname")%> <%=request.getParameter("lastname")%></h3>
		<br>
		<h4>Try again! Please enter exact values for the first and last name, as it is also case sensitive.</h4>
		<br>
	<% } else { %>
		<h3>Please enter your name to search for your shifts</h3>
		<br>
		<h4>Please enter exact values for the first and last name, as it is also case sensitive.</h4>
		<br>
	<% } %>
			<div class="row">
					<div class="col-md-4">
						<form method="post">
							<div class="form-group">
								<label for="firstname">First Name:</label>
								<input class="form-control" type="text" name="firstname" id="firstname" default="1" placeholder="Enter First Name" />
							</div>
							<div class="form-group">		
								<label for="lastname">Last Name:</label>
								<input class="form-control type="text" name="lastname" id="lastname" default="1" placeholder="Enter Last Name" />
							</div>
							<button class="btn btn-primary" type="submit">Get Shifts</button>
						</form>
				</div>
			</div>
		</div>
	</div>
</div>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>