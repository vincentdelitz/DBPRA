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
	
	<%--check if there is an error when searching for the offers
	If yes, just return "offers not found" and the page is done
	If no, go ahead--%>
	
	<% if (request.getAttribute("error") != null) { %>
		<h3><%=request.getAttribute("error") %></h3>
	<% } else { %>
		<%-- get the list of offers--%>
		<table class="table table-striped">
			<caption><h1>Offers</h1></caption>
			<%-- output the results --%>
			<thead>
				<tr>
				<%--the headlines for each columns --%>
					<th></th>
					<th>productID</th>
					<th>Product Name</th>
					<th>AreaID</th>
					<th>Area Name</th>
					<th>ShopID</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<% ArrayList<OfferProductBean> offers = (ArrayList<OfferProductBean>)session.getAttribute("offers"); %>
			<tbody> 

				<% for (int i=0; i < offers.size(); i++) { 
					offer = (OfferProductBean)offers.get(i); %>
					<tr>
						<td><a href="./locationServlet?product_id=<%=offers.get(i).getProductID()%>&shop_id=<%=offers.get(i).getShopID()%>">See Location</a></td>
						<td><%=offers.get(i).getProductID()%></td>
						<td><%=offers.get(i).getPname()%></td>
						<td><%=offers.get(i).getAreaID()%></td>
						<td><%=offers.get(i).getAreaname()%></td>
						<td><%=offers.get(i).getShopID()%></td>
						<td><%=offers.get(i).getQuantity()%></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	<% } %>
	
	<%-- go back --%>
	<a href="./SearchProduct.jsp">Find some other products :)</a>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
