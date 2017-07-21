<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<%@ page import="de.tum.in.dbpra.model.bean.ShiftBean" %>

<jsp:useBean id="shift" scope="request" class="de.tum.in.dbpra.model.bean.ShiftBean"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Search Shifts</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="./header.jsp" %>
      
	<% if (request.getAttribute("error") != null) { %>
		<h1>An error has occurred!</h1>
		<%= request.getAttribute("error") %>
				
	<% } else if (request.getAttribute("error1") != null) { %>
		<h3>There is no employee with the following name: <%=request.getParameter("firstname")%> <%=request.getParameter("lastname")%></h3>
		<a href="./ShiftServlet">Try again</a>

	<% } else if (request.getAttribute("error2") != null) { %>
		<h3>There are more employees with your name <%=request.getParameter("firstname")%> <%=request.getParameter("lastname")%> !</h3>
		<a href="./ShiftServlet2">Log in with employee ID</a>
	
	<% } else if (request.getAttribute("error3") != null) { %>
		<h3>There is no employee named <%=request.getParameter("firstname")%> <%=request.getParameter("lastname")%> with the following Person ID: <%=request.getParameter("personID")%></h3>
		<a href="./ShiftServlet2">Try again</a>
	
    <% } else { %>
		<br>
		<table class="table table-striped">
 	       <thead>
 		       	<tr>
 		       		<th>start time</th>
      		  		<th>end time</th>
  		      		<th>area ID</th>
      		  		<th>additional information</th>
     		   	</tr>
    	    </thead>
    	    <% ArrayList <ShiftBean> shiftList = (ArrayList <ShiftBean>)request.getAttribute("shiftList"); %>
    	    <tbody> 
    			<% for (int i=0; i < shiftList.size(); i++) {
    				shift = (ShiftBean)shiftList.get(i); %>
    	   			<tr>				
						<td><%=shift.getStarttime()%></td>
						<td><%=shift.getEndtime()%></td>
						<td><%=shift.getAreaID()%></td>
						<td><%=shift.getAdditionInfo()%></td>
					</tr>
				<% } %>	
    		</tbody>
		</table>
		<br>
		<br>
    <% } %>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
