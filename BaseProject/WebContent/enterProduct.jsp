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
	
	<form method="post">
		<label for="name">Product name</label>
		<input type="text" name="name" id="name"/>
			<br/>
	<div class="form-group">
 		 <label for="producttype">Select the product type</label>
  		 <select  class="input-small" class="input-small" id="producttype" name="producttype">
    			<option>drink</option>
    			<option>food</option>
    			<option>clothing</option>
    			<option>souvenir</option>
  		</select>
	</div>
	<label for="price">Product price</label>
		<input type="decimal" name="price" id="price"/>
			<br/>
		<label for="quantity">Product Quantity</label>
		<input type="number" name="quantity" id="quantity"/>
			<br/>
		<label for="shopID">Your Shop ID</label>
		<input type="number" name="shopID" id="shopID"/>
			<br/>
			<br/>
	
		<input type="submit" value="Insert" />
	</form>
	<br>
	
	<a href="insertProduct.jsp">BACK</a>
	

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
