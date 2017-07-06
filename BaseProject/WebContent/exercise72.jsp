<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.OrderListBean"></jsp:useBean>
<jsp:useBean id="bean_no" scope="request"
	class="de.tum.in.dbpra.model.bean.OrderListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Exercise 7.2</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>

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
	<h1>All Orders that are ok</h1>
	

	<div class="box">
		<table  class="table table-striped">
			<tr>
				<th>Orderkey</th>
				<th>Custkey</th>
				<th>Orderstatus</th>
				<th>Totalprice</th>
				<th>Orderdate</th>

			</tr>
			<%
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>

				<td><a href="./invoiceform?orderkey=<%=bean.getChild(i).getOrderkey()%>"><%=bean.getChild(i).getOrderkey()%></a></td>
				<td><%=bean.getChild(i).getCustkey()%></td>
				<td><%=bean.getChild(i).getOrderstatus()%></td>
				<td><%=bean.getChild(i).getTotalprice()%></td>
				<td><%=bean.getChild(i).getOrderdate()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>

<div class="content container">

	<h1>All Orders that are NOT ok</h1>
	

	<div class="box">
		<table  class="table table-striped">
			<tr>
				<th>Orderkey</th>
				<th>Custkey</th>
				<th>Orderstatus</th>
				<th>Totalprice</th>
				<th>Orderdate</th>

			</tr>
			<%
				for (int i = 0; i < bean_no.getList().size(); i++) {
			%>
			<tr>

				<td><a href="./invoiceform?orderkey=<%=bean_no.getChild(i).getOrderkey()%>"><%=bean_no.getChild(i).getOrderkey()%></a></td>
				<td><%=bean_no.getChild(i).getCustkey()%></td>
				<td><%=bean_no.getChild(i).getOrderstatus()%></td>
				<td><%=bean_no.getChild(i).getTotalprice()%></td>
				<td><%=bean_no.getChild(i).getOrderdate()%></td>
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
