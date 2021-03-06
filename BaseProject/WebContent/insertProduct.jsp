<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <jsp:useBean id="bean" scope="request" class="de.tum.in.dbpra.model.bean.ProductListBean"></jsp:useBean>
<%@ page import="de.tum.in.dbpra.model.bean.ProductListBean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Insert a new product</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="./header.jsp" %>
<div class="container-fluid">
		<div class="row">
			<div class="col-md-10">

<h3>Which Product do you like to offer in your shop?</h3>

<div class="row">
<div class="col-md-10">
	<h5>The Product you want to offer is not in the list?</h5>
	<a class="btn btn-primary" href="./InsertProductServlet3">Insert New Product</a>
	</div>
</div>

<% if (request.getAttribute("error") != null) { %>
	<!--h1>Nothing found!</h1-->
	<%! String s1 = ""; %>
	<% s1 = (String) request.getAttribute("error");%>
	<script type="text/javascript">
	function alertName(){
	var str="<%=s1%>";
	alert("An error has occured: " + str);
	} 
	</script>
	<script type="text/javascript"> window.onload = alertName; </script>
	<!--%= request.getAttribute("error") %-->

	<% }  %>
        <div class="box" style="margin-top: 30px;">
		<table  class="table table-striped">
			<tr>
				<th>Name</th>
				<th>ProductID</th>
				<th>Type</th>
				<th>Price</th>
			</tr>
			<% bean = (ProductListBean) session.getAttribute("bean");
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>
				<td><a href="./InsertProductServlet2?productID=<%=bean.getChild(i).getProductID()%>"><%=bean.getChild(i).getName()%></a></td>
				<td><%=bean.getChild(i).getProductID()%></td>
				<td><%=bean.getChild(i).getType()%></td>
				<td><%=bean.getChild(i).getPrice()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	</div>
</div>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
