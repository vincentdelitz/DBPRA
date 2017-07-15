<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		First Name: <input type = "text" name="firstname" value=<%=session.getAttribute("firstname")%> ><br>
		Last Name: <input type = "text" name="lastname" value=<%=session.getAttribute("lastname")%> ><br>
		<label for="personID">Person ID</label>
		<input type="number" name="personID" id="personID" default="1" />
			<br/>
			<input type="submit" value="GET SHIFTS" />
	</form>
</body>
</html>
