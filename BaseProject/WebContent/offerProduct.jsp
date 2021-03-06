<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="de.tum.in.dbpra.model.bean.OfferProductBean" %>

<jsp:useBean id="offer" scope="request" class="de.tum.in.dbpra.model.bean.OfferProductBean"></jsp:useBean>

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
		<% ArrayList<OfferProductBean> offers = (ArrayList<OfferProductBean>)session.getAttribute("offers"); %>
		<h1>Shops that offer the Product <%=offers.get(0).getPname()%></h1>
		<%-- get the list of offers--%>
		<table class="table table-striped">
			<%-- output the results --%>
			<thead>
				<tr>
				<%--the headlines for each columns --%>
					<th></th>
					<th>ShopID</th>
					<th>Product Quantity</th>
				</tr>
			</thead>
			
			<tbody> 

				<% for (int i=0; i < offers.size(); i++) { %>
					<tr>
						<td><a href="./locationServlet?product_id=<%=offers.get(i).getProductID()%>&shop_id=<%=offers.get(i).getShopID()%>">See Location Details</a></td>
						<td><%=offers.get(i).getShopID()%></td>
						<td><%=offers.get(i).getQuantity()%></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	<% } %>
	
		</div>
	</div>
	<%-- go back --%>
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