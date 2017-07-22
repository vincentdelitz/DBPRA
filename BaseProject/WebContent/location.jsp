<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="de.tum.in.dbpra.model.bean.LocationBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Where is the product I need?</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
   </head>
<body>
	<%@include file="./header.jsp" %>
      
	<%--check if there is an error when searching for the offers
	If yes, just return "offers not found" and the page is done
	If no, go ahead--%>
	<% if (request.getAttribute("error") != null) { %>
		<h3><%=request.getAttribute("error") %></h3>
	<% } else { %>
		<%-- get the list of offers--%>
		<% ArrayList<LocationBean> locations = (ArrayList<LocationBean>) request.getAttribute("locations"); %>
		<h1>You can find <%=locations.get(0).getName()%> in the following shops:</h1>
		
		<%-- output the results --%>
		<% for (int i = 0; i < locations.size(); i++) { %>
	
			<p class="lead">
				<div>
					<strong>Shop ID:</strong>
					<span><%=locations.get(i).getShopID()%></span>
				</div>
				<div>
					<strong>Type of the Shop:</strong>
					<span><%=locations.get(i).getShopType()%></span>
				</div>
				<div><br/>
					<strong>Area Name:</strong>
					<span><%=locations.get(i).getAreaName()%></span>
				</div>
				<div>
					<strong>Type of the Area:</strong>
					<span><%=locations.get(i).getType()%></span>
				</div><br />

			</p>
	
		<% } %>
	<% } %>
	<%-- go back --%>
	<a href="./SearchProduct.jsp">Find some other products :)</a>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
