<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="de.tum.in.dbpra.model.bean.ShiftBean" %>

<jsp:useBean id="shift" scope="request" class="de.tum.in.dbpra.model.bean.ShiftBean"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer</title>
</head>
<body>
	<% if (request.getAttribute("error") != null) { %>
		<h1>An error has occurred!</h1>
		<%= request.getAttribute("error") %>
				
	<% } else if (request.getAttribute("error1") != null) { %>
		<h3>There is not employee with the following name: <%=request.getParameter("firstname")%> <%=request.getParameter("lastname")%></h3>
		<a href="./ShiftServlet">Try again</a>

	<% } else if (request.getAttribute("error2") != null) { %>
		<h3>There are more employees with your name (<%=request.getParameter("firstname")%> <%=request.getParameter("lastname")%>) !</h3>
		<a href="./ShiftServlet2">Log in with employee ID</a>
	
	<% } else if (request.getAttribute("error3") != null) { %>
		<h3>There is no employee named <%=request.getParameter("firstname")%> <%=request.getParameter("lastname")%> with the following Person ID: <%=request.getParameter("personID")%></h3>
		<a href="./ShiftServlet2">Try again</a>
	
    <% } else { %>
		<br>
		<table border = "1">
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
    	
</body>
</html>
