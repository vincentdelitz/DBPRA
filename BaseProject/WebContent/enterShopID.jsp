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
			<div class="col-md-3">
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

	<h3>Please enter the ID of your Shop!</h3>
	
	<form method="post">
	<div class="form-group">
		<label for="shopID">Shop ID</label>
		<input class="form-control" type="number" name="shopID" id="shopID" placeholder="Shop ID" />
	</div>
	<div class="form-group">
		<label for="quantity">Quantity of Product:</label>
		<input class="form-control" type="number" name="quantity" id="quantity" placeholder="Quantity" />
	</div>
	<button type="submit" class="btn btn-primary">Insert</button>
	</form>
	</div>
	</div>
	</div>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
