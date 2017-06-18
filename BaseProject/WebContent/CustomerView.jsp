<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="customer" scope="request" class="de.tum.in.dbpra.model.bean.CustomerBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer</title>
</head>
<body>
	<% if (request.getAttribute("error") != null) { %>
	<h1>Customer not found!</h1>
	<%= request.getAttribute("error") %>

	<% } else { %>
        		<h1><%= customer.getName() %></h1>
	Address: <%= customer.getAddress() %> <br/>
	Balance: <%= customer.getAcctbal() %>
        	<% } %>
	
</body>
</html>