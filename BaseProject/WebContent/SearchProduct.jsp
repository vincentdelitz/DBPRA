<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Search product</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
   </head>
<body>
	<%@include file="./header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h4>Please insert the name of the product that you want to search for. The search value does not need to be exact, as it also searches for similar values.</h4>
				<%-- input the productID--%>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<form action="./ProductServlet" method="GET">
					<div class="form-group">
						<label for="product_name">Product Name</label>
						<input type="text" class="form-control" id="product_name" name="product_name" placeholder="Enter product name" /> 
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
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