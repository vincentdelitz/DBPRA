<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <jsp:useBean id="bean" scope="request" class="de.tum.in.dbpra.model.bean.StageListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Search stages for visitors</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="./header.jsp" %>

<h4>Here you can search for the stages that a certain visitor will see. Please enter exact values for the first and last name, as it is also case sensitive.</h4>
	

	<form method="post">
		<label for="firstname">First name visitor</label>
		<input type="text" name="firstname" id="firstname" default="Max" />
			<br/>
	<label for="lastname">Last name visitor</label>
		<input type="text" name="lastname" id="lastname" default="Mustermann" />
			<br/>
			<input type="submit" value="search" />
	</form>
</br>
<% if (request.getAttribute("error") != null) { %>
	<h1>Nothing found!</h1>
	<%= request.getAttribute("error") %>

	<% } else { %>
        		<div class="box">
		<table  class="table table-striped">
			<tr>
				<th>Visitor ID</th>
				<th>Firstname of Visitor</th>
				<th>Lastname of Visitor</th>
				<th>StageID</th>
				<th>Name</th>
				<th>Size</th>
				<th>Name of Band</th>
				<th>Performance Start</th>
				<th>Performance End</th>
				</tr>
			<%
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>

				<td><%=bean.getChild(i).getPersID()%></td>
				<td><%=bean.getChild(i).getPersFirstName()%></td>
				<td><%=bean.getChild(i).getPersLastName()%></td>
				<td><%=bean.getChild(i).getStageID()%></td>
				<td><%=bean.getChild(i).getName()%></td>
				<td><%=bean.getChild(i).getSize()%></td>
				<td><%=bean.getChild(i).getBandName()%></td>
				<td><%=bean.getChild(i).getPerformanceStart()%></td>
				<td><%=bean.getChild(i).getPerformanceEnd()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>
        	<% } %>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>