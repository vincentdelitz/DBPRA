<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.PartListBean"></jsp:useBean>
<jsp:useBean id="bean_no" scope="request"
	class="de.tum.in.dbpra.model.bean.PartListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Exercise 7.3</title>

</head>

<a href="./exercise71.html">Back to exercise71.html</a>

<form>
  Search:<br>
  <input type="text" name="searchparameter"><br>
</form>

<form>
	<fieldset>
		<input type="radio" id="ex" name="searchtype" value="exact" checked>
		<label for="mc"> Exact Match</label><br>
		<input type="radio" id="li" name="searchtype" value="like">
		<label for="vi"> Like Match</label><br>
	</fieldset>
</form>

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
	<h1>All Parts in Alphabetical Order</h1>
	

	<div class="box">
		<table border frame=void style="width: 100%">
			<tr>
				<th>Partkey</th>
				<th>Name</th>
				<th>Size</th>
				<th>Container</th>
				<th>Retailrice</th>

			</tr>
			<%
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>

				<td><%=bean.getChild(i).getPartkey()%></td>
				<td><%=bean.getChild(i).getName()%></td>
				<td><%=bean.getChild(i).getSize()%></td>
				<td><%=bean.getChild(i).getContainer()%></td>
				<td><%=bean.getChild(i).getRetailprice()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>

</body>
</html>
