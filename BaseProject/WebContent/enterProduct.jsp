<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <jsp:useBean id="bean" scope="request" class="de.tum.in.dbpra.model.bean.ProductListBean"></jsp:useBean>
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
	<% if (request.getAttribute("error") != null) { %>
		<%! String s1 = ""; %>
		<% s1 = (String) request.getAttribute("error");%>
		<script type="text/javascript">
			function alertName() {
				var str="<%=s1%>";
				alert("An error has occured: " + str);
		} 
		</script>
		<script type="text/javascript"> 
			window.onload = alertName; 
		</script>
		<!--%= request.getAttribute("error") %-->
	<% } %>
	
	<h3>Please insert your Product Details!</h3>
	
	<div class="row">
	<div class="col-md-3">
	<form method="post">
		<div class="form-group">
			<label for="name">Product name</label>
			<input class="form-control" type="text" name="name" id="name"/>
		</div>
		<div class="form-group">
	 		 <label for="producttype">Select the product type</label>
	  		 <select class="form-control" id="producttype" name="producttype">
	    			<option>drink</option>
	    			<option>food</option>
	    			<option>clothing</option>
	    			<option>souvenir</option>
	  		</select>
		</div>
		<div class="form-group">
			<label for="price">Product price</label>
			<input class="form-control" type="decimal" name="price" id="price"/>
		</div>
		<div class="form-group">
			<label for="quantity">Product Quantity</label>
			<input class="form-control" type="number" name="quantity" id="quantity"/>
		</div>
		<div class="form-group">
			<label for="shopID">Your Shop ID</label>
			<input class="form-control" type="number" name="shopID" id="shopID"/>
		</div>
		<button class="btn btn-primary" type="submit">Insert</button>
		</form>
	</div>
	</div>
		<div class="row" style="margin-top:30px;">
			<div class="col-md-2">
			<a class="btn btn-danger" href="./insertProduct.jsp" role="button">BACK</a>
			</div>
		</div>
	</div>
	</div>
	</div>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
