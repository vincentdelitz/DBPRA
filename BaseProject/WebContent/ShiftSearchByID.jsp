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

	<h4>Please insert the first and last name of the employee that you want to search the shift for. Tĥe names must exactly match meaning that the values are also case sensitive.</h4>
	<form method="post">
		First Name: <input type = "text" name="firstname" value=<%=session.getAttribute("firstname")%> ><br>
		Last Name: <input type = "text" name="lastname" value=<%=session.getAttribute("lastname")%> ><br>
		<label for="personID">Person ID</label>
		<input type="number" name="personID" id="personID" default="1" />
			<br/>
			<input type="submit" value="Get shifts" />
	</form>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
