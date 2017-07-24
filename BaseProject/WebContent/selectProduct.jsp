<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="de.tum.in.dbpra.model.bean.ProductBean"%>
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
		<h1>Products that fit your search</h1>
		<%-- get the list of products--%>
		<table class="table table-striped">
			<%-- output the results --%>
			<thead>
				<tr>
				<%--the headlines for each columns --%>
					<th></th>
					<th>Product Name</th>
					<th>Product Type</th>
					<th>Product Price</th>
				</tr>
			</thead>
			<% ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("products"); %>
			<tbody> 

				<% for (int i=0; i < products.size(); i++) { 
					ProductBean product = products.get(i); %>
					<tr>
						<td><a href="./OfferProductServlet?name=<%=products.get(i).getName()%>">See Offering Shops</a></td>
						<td><%=products.get(i).getName()%></td>
						<td><%=products.get(i).getType()%></td>
						<td><%=products.get(i).getPrice()%></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	<% } %>
	<%-- go back --%>
			</div>
		</div>
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