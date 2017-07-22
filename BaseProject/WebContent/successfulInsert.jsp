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
	function alertName(){
	var str="<%=s1%>";
	alert("An error has occured: " + str);
	} 
	</script>
	<script type="text/javascript"> window.onload = alertName; </script>
	<!--%= request.getAttribute("error") %-->

	<% }  else { %>
        <h1>Your Product has been successfully inserted!</h1>
        <br> 
        <h7>You now offer the following Products in your shop</h7>
        
        <div class="box">
		<table  class="table table-striped">
			<tr>
				<th>Name</th>
				<th>ProductID</th>
				<th>Type</th>
				<th>Price</th>
			</tr>
			<%
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>
				<td><%=bean.getChild(i).getName()%></td>
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
<% }   %>

        	

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
