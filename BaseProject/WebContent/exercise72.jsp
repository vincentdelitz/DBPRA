<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.OrderListBean"></jsp:useBean>
<jsp:useBean id="bean_no" scope="request"
	class="de.tum.in.dbpra.model.bean.OrderListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Exercise 7.2</title>

</head>

<a href="./exercise71.html">Back to exercise71.html</a>

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
		<table border frame=void style="width: 100%">
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

				<td><a href="./invoiceform"><%=bean.getChild(i).getOrderkey()%></a></td>
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
		<table border frame=void style="width: 100%">
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

				<td><a href="./invoiceform"><%=bean.getChild(i).getOrderkey()%></a></td>
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

</body>
</html>
