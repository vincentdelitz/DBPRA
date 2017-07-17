<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="de.tum.in.dbpra.model.bean.offerBean"%>
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
                     </ul>
                  </li>
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Visitor <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="#">Activity Diagram</a></li>
                        <li><a href="#">Sequence Diagram 3</a></li>
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
		<%--check if there is an error when searching for the offers
		If yes, just return "offers not found" and the page is done
		If no, go ahead--%>
		<%
			if (request.getAttribute("error") != null) {
		%>
		<h3><%=request.getAttribute("error") %></h3>
	<%
		} else {
	%>
	<%-- get the list of offers--%>
	<table>
		<caption><h1>offers</h1></caption>
	<%
		ArrayList<offerBean> offers = (ArrayList<offerBean>) request
					.getAttribute("offer");
	%>
	<%-- output the results --%>
	<tr>
	<%--the headlines for each columns --%>
		<th>productID</th>
		<th>AreaID</th>
		<th>Area Name</th>
		<th>ShopID</th>
		<th>Quantity</th>
	</tr>
	<%
		for (int i = 0; i < offers.size(); i++) {
	%>
	<tr>
		<td><%=offers.get(i).getProductID()%></td>
		<td><%=offers.get(i).getAreaID()%></td>
		<td><%=offers.get(i).getAreaname()%></td>
		<td><%=offers.get(i).getShopID()%></td>
		<td><%=offers.get(i).getQuantity()%></td>
	</tr>
	<%
		}
	%>
	</table>
	<%
		}
	%>
	<%-- go back --%>
	<a href="./SearchProduct.jsp">find some other products :)</a>
	<a href="./index.htm">back</a>
	 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>