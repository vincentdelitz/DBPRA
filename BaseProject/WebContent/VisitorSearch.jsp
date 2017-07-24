<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <jsp:useBean id="bean" scope="request" class="de.tum.in.dbpra.model.bean.StageListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Search stages for visitors</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="./header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10">

				<h2>Stages and corresponding music acts</h2>
				<h4>Here you can search for the stages that a certain visitor will see while watching his acts. Please enter exact values for the first and last name, as it is also case sensitive.</h4>
	
				<div class="row">
					<div class="col-md-5">
						<form method="post">
							<div class="form-group">
								<label for="firstname">First name visitor</label>
								<input class="form-control" type="text" name="firstname" id="firstname" default="Max" placeholder="First Name" />
							</div>
							<div class="form-group">
								<label for="lastname">Last name visitor</label>
								<input class="form-control" type="text" name="lastname" id="lastname" default="Mustermann" placeholder="Last Name" />
							</div>
							<button class="btn btn-primary" type="submit">Search</button>
						</form>
					</div>
				</div>


				<% if (request.getAttribute("error") != null) { %>
	
			 		<%! String s1 = ""; %>
			 		<% s1 = (String) request.getAttribute("error");%>
			 		<script type="text/javascript">
				 		function alertName(){
				 			var str="<%=s1%>";
				 			alert("An error has occured: " + str);
				 		} 
			 		</script>
			 		<script type="text/javascript"> 
			 			window.onload = alertName; 
			 		</script>
			
				<% } else if(bean.getList().size()!=0){ %>
					<div class="row" style="margin-top: 30px;">
						<div class="col-md-12">
			        		<div class="box">
								
								<h4>These are your stages and corresponding music acts <%=bean.getChild(0).getPersFirstName()%> <%=bean.getChild(0).getPersLastName()%></h4>
								
								<table  class="table table-striped">
									<tr>
										<th>StageID</th>
										<th>Stage Name</th>
										<th>Size</th>
										<th>Name of Band</th>
										<th>Performance Start</th>
										<th>Performance End</th>
									</tr>
									<% for (int i = 0; i < bean.getList().size(); i++) { %>
										<tr>
											<td><%=bean.getChild(i).getStageID()%></td>
											<td><%=bean.getChild(i).getName()%></td>
											<td><%=bean.getChild(i).getSize()%></td>
											<td><%=bean.getChild(i).getBandName()%></td>
											<td><%=bean.getChild(i).getPerformanceStart()%></td>
											<td><%=bean.getChild(i).getPerformanceEnd()%></td>
										</tr>
									<% } %>
								</table>
							</div>
						</div>
					</div>
        		<% } %>
        	</div>
        </div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	
</body>
</html>