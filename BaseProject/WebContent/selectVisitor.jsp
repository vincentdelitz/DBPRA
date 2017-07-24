<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="de.tum.in.dbpra.model.bean.VisitorBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Choose the visitor</title>
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
		<h1>Visitors that fit your search</h1>
		<%-- get the list of visitors--%>
		<table class="table table-striped">
			<%-- output the results --%>
			<thead>
				<tr>
				<%--the headlines for each columns --%>
					<th></th>
					<th>Visitor Salutation</th>
					<th>Visitor First Name</th>
					<th>Visitor Last Name</th>
					<th>Visitor TicketID</th>
					<!-- TicketID is visible for every visitor on his ticket, more Information would breach data privacy -->
				</tr>
			</thead>
			<% ArrayList<VisitorBean> visitors = (ArrayList<VisitorBean>) request.getAttribute("visitors"); %>
			<tbody> 

				<% for (int i=0; i < visitors.size(); i++) { 
					VisitorBean visitor = visitors.get(i); %>
					<tr>
						<td><a href="./StageServlet?visitorID=<%=visitors.get(i).getVisitorID()%>">See Personal Stages</a></td>
						<td><%=visitors.get(i).getSalutation()%></td>
						<td><%=visitors.get(i).getFirstname()%></td>
						<td><%=visitors.get(i).getLastname()%></td>
						<td><%=visitors.get(i).getTicketID()%></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	<% } %>
	<%-- go back --%>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
			<a class="btn btn-primary" href="./VisitorSearch.jsp" role="button">Back to Visitor Search</a>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
