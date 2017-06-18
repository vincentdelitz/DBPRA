<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="order" scope="request"
	class="de.tum.in.dbpra.model.bean.OrderBean"></jsp:useBean>
<jsp:useBean id="lineitems" scope="request"
	class="de.tum.in.dbpra.model.bean.LineitemListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Exercise 7.2</title>

</head>

</br>
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
	<h1>Invoice form</h1>
	

	<div class="box">
		<table border frame=void style="width: 50%">
			<tr>
				<th>Information about the customer</th>
				<td>order.getCustkey().getName()</td>
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
			Table with all order items
			<table border frame=void >
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


</body>
</html>
