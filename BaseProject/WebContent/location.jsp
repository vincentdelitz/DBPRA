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
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10">
      
	<%--check if there is an error when searching for the offers
	If yes, just return "offers not found" and the page is done
	If no, go ahead--%>
	<% if (request.getAttribute("error") != null) { %>
		<h3><%=request.getAttribute("error") %></h3>
	<% } else { %>
		<%-- get the list of offers--%>
		<% ArrayList<LocationBean> locations = (ArrayList<LocationBean>) request.getAttribute("locations"); %>
		<h4>You can find <%=locations.get(0).getProductName()%> in the following shop:</h4>
		
		<%-- output the results --%>
		<% for (int i = 0; i < locations.size(); i++) { %>
	
			<dl class="dl-horizontal">
					<dt>Shop ID:</dt>
					<dd><%=locations.get(i).getShopID()%></dd>
					<dt>Type of the Shop:</dt>
					<dd><%=locations.get(i).getShopType()%></dd>
					<dt>Area Name:</dt>
					<dd><%=locations.get(i).getAreaName()%></dd>
					<dt>Area ID:</dt>
					<dd><%=locations.get(i).getAreaID()%></dd>
					<dt>Type of the Area:</dt>
					<dd><%=locations.get(i).getAreaType()%></dd>
			</dl>
	
		<% } %>
	<% } %>
	</div>
	</div>
	<%-- go back --%>
		
		<div class="row">
			<div class="col-md-2">
			<a class="btn btn-primary" href="./offerProduct.jsp" role="button">Back to Offering Shops</a>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-2">
			<a class="btn btn-primary" href="./SearchProduct.jsp" role="button">Back to Product Search</a>
			</div>
		</div>

	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>