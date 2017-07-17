<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <jsp:useBean id="bean" scope="request" class="de.tum.in.dbpra.model.bean.StageListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Search stages for visitors</title>
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
               <a class="navbar-brand" href="./index.htm">Festival</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Employee <span class="caret"></span></a>
                     <ul class="dropdown-menu">

                        <li><a href="./ShiftServlet">Search Shifts</a></li>
                        <li><a href="./SearchProduct.jsp">Search for a product</a></li>
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
               </ul>
            </div>
            <!-- /.navbar-collapse -->
         </div>
         <!-- /.container-fluid -->
      </nav>

<h4>Here you can search for the stages that a certain visitor will see. Please enter exact values for the first and last name, as it is also case sensitive.</h4>
	

	<form method="post">
		<label for="firstname">First name visitor</label>
		<input type="text" name="firstname" id="firstname" default="Max" />
			<br/>
	<label for="lastname">Last name visitor</label>
		<input type="text" name="lastname" id="lastname" default="Mustermann" />
			<br/>
			<input type="submit" value="search" />
	</form>
</br>
<% if (request.getAttribute("error") != null) { %>
	<h1>Nothing found!</h1>
	<%= request.getAttribute("error") %>

	<% } else { %>
        		<div class="box">
		<table  class="table table-striped">
			<tr>
				<th>StageID</th>
				<th>Name</th>
				<th>Size</th>
				</tr>
			<%
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>

				<td><%=bean.getChild(i).getStageID()%></td>
				<td><%=bean.getChild(i).getName()%></td>
				<td><%=bean.getChild(i).getSize()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>
        	<% } %>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
