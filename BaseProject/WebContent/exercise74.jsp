<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="order" scope="request"
	class="de.tum.in.dbpra.model.bean.OrderBean"></jsp:useBean>
<jsp:useBean id="lineitems" scope="request"
	class="de.tum.in.dbpra.model.bean.LineitemListBean"></jsp:useBean>
<jsp:useBean id="customer" scope="request"
	class="de.tum.in.dbpra.model.bean.CustomerBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Exercise 7.4</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

</br>

<div class="content container">

	<%
		if (request.getAttribute("error") != null) {
	%>
	<div class="box">

		<h1>An error occured!</h1>
		<%=request.getAttribute("error")%>
	</div>
	<%
		} 
			
	%>
	<h1>Invoice form</h1>
	

	<div class="box">
		<table class="table table-striped">
			<tr>
				<th>Information about the customer</th>
				<td><%=customer.getName()%></td>
			</tr>
			<tr>
				<th>Number of invoice form</th>
				<td><%=order.getOrderkey()%></td>
			</tr>
			<tr>
				<th>Date</th>
				<td><%=order.getOrderdate()%></td>
			</tr>
			<tr>
				<th>Number of customer</th>
				<td><%=order.getCustkey()%></td>
			</tr>
			<tr>
				<th>Lump sum price</th>
				<td><%=order.getTotalprice()%></td>
			</tr>
</table>
			<h3>Table with all order items</h3>
			<table class="table table-striped" >
<tr>				
				<th>Linenumber</th>
				<th>Partkey</th>
				<th>Quantity</th>
				<th>Extendedprice</th>
</tr>

				

			<%
				for (int i = 0; i < lineitems.getList().size(); i++) {
			%>
			<tr>

				<td><%=lineitems.getChild(i).getLinenumber()%></td>
				<td><%=lineitems.getChild(i).getPartkey()%></td>
				<td><%=lineitems.getChild(i).getQuantity()%></td>
				<td><%=lineitems.getChild(i).getExtendedprice()%></td>
				
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

