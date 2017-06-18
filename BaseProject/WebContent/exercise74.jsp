<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.OrderListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Exercise 7.2</title>

</head>
Das ist Exercise 7.4
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
				<th><%=bean.getName()%></th>
			</tr>
			<tr>
				<th>Number of invoice form</th>
				<th><%=bean.getOrderkey()%></th>
			</tr>
			<tr>
				<th>Date</th>
				<th>18-06-2017</th>
			</tr>
			<tr>
				<th>Number of customer</th>
				<th><%=bean.getCustkey()%></th>
			</tr>
			<tr>
				<th>Table with all order items</th>
				<th>Custkey</th>
			</tr>
			<tr>
				<th>Lump sum price</th>
				<th>Custkey</th>
			</tr>

			<tr>

				
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


</body>
</html>
