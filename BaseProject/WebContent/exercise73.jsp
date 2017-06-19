<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.PartListBean"></jsp:useBean>
<jsp:useBean id="beansearch" scope="request"
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
 <br/>
	<fieldset>
		<input type="radio" id="ex" name="searchtype" value="exact" checked>
		<label for="mc"> Exact Match</label><br>
		<input type="radio" id="li" name="searchtype" value="like">
		<label for="vi"> Like Match (only possible for 'Name' and 'Type')</label><br>
	</fieldset>
	<fieldset>
		<input type="radio" id="partkey" name="selectcolumn" value="partkey" checked>
		<label for="mc"> Partkey</label><br>
		<input type="radio" id="name" name="selectcolumn" value="name">
		<label for="mc"> Name</label><br>
		<input type="radio" id="type" name="selectcolumn" value="type">
		<label for="mc"> Type</label><br>
		<input type="radio" id="size" name="selectcolumn" value="size">
		<label for="mc"> Size</label><br>
		<input type="radio" id="container" name="selectcolumn" value="container">
		<label for="mc"> Container</label><br>
		<input type="radio" id="retailprice" name="selectcolumn" value="retailprice">
		<label for="mc"> Retailprice (entering decimal is necessary)</label><br>
	</fieldset>
	<input type="submit" value="search" />
</form>



<!--form method="POST">
<b>Column:</b>
	<select name="selectcolumn" size="2" multiple>
		<option value="partkey">Partkey</option>
		<option value="name">Name</option>
		<option value="size">Size</option>
		<option value="container">Container</option>
		<option value="retailprice">Retailprice</option>
	</select>
	<input type="submit" value="search" />
</form-->

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
				<th>Type</th>
				<th>Size</th>
				<th>Container</th>
				<th>Retailprice</th>
				<th>Match</th>

			</tr>
			<%
				for (int i = 0; i < beansearch.getList().size(); i++) {
			%>
			<%
					if(beansearch.getChild(i).getMatch()==1) {
			%>
			<tr>

				<td style="font-weight:bold"><%=beansearch.getChild(i).getPartkey()%></td>
				<td style="font-weight:bold"><%=beansearch.getChild(i).getName()%></td>
				<td style="font-weight:bold"><%=beansearch.getChild(i).getType()%></td>
				<td style="font-weight:bold"><%=beansearch.getChild(i).getSize()%></td>
				<td style="font-weight:bold"><%=beansearch.getChild(i).getContainer()%></td>
				<td style="font-weight:bold"><%=beansearch.getChild(i).getRetailprice()%></td>
				<td style="font-weight:bold"><%=beansearch.getChild(i).getMatch()%></td>
			</tr>
			<%
					} else {
			%>
			<tr>

				<td><%=beansearch.getChild(i).getPartkey()%></td>
				<td><%=beansearch.getChild(i).getName()%></td>
				<td><%=beansearch.getChild(i).getType()%></td>
				<td><%=beansearch.getChild(i).getSize()%></td>
				<td><%=beansearch.getChild(i).getContainer()%></td>
				<td><%=beansearch.getChild(i).getRetailprice()%></td>
				<td><%=beansearch.getChild(i).getMatch()%></td>
			</tr>
			<%
					}
				}
			%>
		</table>
	</div>
</div>

</body>
</html>
