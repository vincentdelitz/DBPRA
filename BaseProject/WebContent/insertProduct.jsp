<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<nav class="navbar navbar-default">
         <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="#">Festival</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Organiser <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="#">Sequence Diagram 1</a></li>
                        <li><a href="#">Sequence Diagram 2</a></li>
			<li><a href="./insertProduct">Insert new product</a></li>
                     </ul>
                  </li>
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Visitor <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="#">Activity Diagram</a></li>
                        <li><a href="./stage">Search personal stages</a></li>
                     </ul>
                  </li>
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Homework Example <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="./order">Exercise 7.2</a></li>
                        <li><a href="./part">Exercise 7.3</a></li>
                     </ul>
                  </li>
               </ul>
            </div>
            <!-- /.navbar-collapse -->
         </div>
         <!-- /.container-fluid -->
      </nav>


	<form method="post">
		<label for="name">Product name</label>
		<input type="text" name="name" id="name"/>
			<br/>
	<div class="form-group">
 		 <label for="producttype">Select the product type</label>
  		 <select class="form-control" id="producttype" name="producttype">
    			<option>drink</option>
    			<option>food</option>
    			<option>clothing</option>
    			<option>souvenir</option>
  		</select>
	</div>
	<label for="price">Product price</label>
		<input type="decimal" name="price" id="price"/>
			<br/>
		<input type="submit" value="Insert" />
	</form>
</br>
<% if (request.getAttribute("error") != null) { %>
	<h1>Nothing found!</h1>
	<%= request.getAttribute("error") %>

	<% }  %>
        <div class="box">
		<table  class="table table-striped">
			<tr>
				<th>ProductID</th>
				<th>Name</th>
				<th>Type</th>
				<th>Price</th>
			</tr>
			<%
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>

				<td><%=bean.getChild(i).getProductID()%></td>
				<td><%=bean.getChild(i).getName()%></td>
				<td><%=bean.getChild(i).getType()%></td>
				<td><%=bean.getChild(i).getPrice()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>
        	

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
