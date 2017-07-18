<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="de.tum.in.dbpra.model.bean.offerBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Where is the product I need?</title>
</head>
<body>
	<table border="2" bgcolor="efefef">
		<caption><h1>offers</h1></caption>
		<%--check if there is an error when searching for the offers
		If yes, just return "offers not found" and the page is done
		If no, go ahead--%>
		<%
			if (request.getAttribute("error") != null) {
		%>
		<tr>Sorry, we don't have the product you want :-(
		</tr>
	</table>
	<%
		} else {
	%>
	<%-- get the list of offers--%>
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
	<a href="./searchproduct.html">back</a>
</body>
</html>