<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
   class="de.tum.in.dbpra.model.bean.PartListBean"></jsp:useBean>
<jsp:useBean id="beansearch" scope="request"
   class="de.tum.in.dbpra.model.bean.PartListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Exercise 7.3</title>
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
   </head>
   <form>
     Search:<br>
    <input type="text" name="searchparameter"><br>
      <br/>
      <fieldset class="form-group">
         <div class="radio">
            <label><input type="radio" id="ex" name="searchtype" value="exact" checked> Exact Match
            </label><br>
         </div>
         <div class="radio">
            <label><input type="radio" id="li" name="searchtype" value="like">
            Like Match (only possible for 'Name' and 'Type')</label><br>
         </div>
      </fieldset>
      <fieldset>
         <div class="radio">
            <label><input type="radio" id="partkey" name="selectcolumn" value="partkey" checked>
            Partkey</label><br>
         </div>
         <div class="radio">
            <label><input type="radio" id="name" name="selectcolumn" value="name">
            Name</label><br>
         </div>
         <div class="radio">
            <label><input type="radio" id="type" name="selectcolumn" value="type">
            Type</label><br>
         </div>
         <div class="radio">
            <label><input type="radio" id="size" name="selectcolumn" value="size">
            Size</label><br>
         </div>
         <div class="radio">
            <label><input type="radio" id="container" name="selectcolumn" value="container">
            Container</label><br>
         </div>
         <div class="radio">
            <label><input type="radio" id="retailprice" name="selectcolumn" value="retailprice">
            Retailprice (entering decimal is necessary)</label><br>
         </div>
      </fieldset>
      <button type="submit" class="btn btn-default">Search</button>
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
         <table class="table table-striped">
            <tr>
               <th><a href="./part?ordercolumn=partkey&searchparameter=<%=request.getParameter("searchparameter")%>&selectcolumn=<%=request.getParameter("selectcolumn")%>&searchtype=<%=request.getParameter("searchtype")%>">Partkey</a></th>
               <th><a href="./part?ordercolumn=name&searchparameter=<%=request.getParameter("searchparameter")%>&selectcolumn=<%=request.getParameter("selectcolumn")%>&searchtype=<%=request.getParameter("searchtype")%>">Name</a></th>
               <th><a href="./part?ordercolumn=type&searchparameter=<%=request.getParameter("searchparameter")%>&selectcolumn=<%=request.getParameter("selectcolumn")%>&searchtype=<%=request.getParameter("searchtype")%>">Type</a></th>
               <th><a href="./part?ordercolumn=size&searchparameter=<%=request.getParameter("searchparameter")%>&selectcolumn=<%=request.getParameter("selectcolumn")%>&searchtype=<%=request.getParameter("searchtype")%>">Size</a></th>
               <th><a href="./part?ordercolumn=container&searchparameter=<%=request.getParameter("searchparameter")%>&selectcolumn=<%=request.getParameter("selectcolumn")%>&searchtype=<%=request.getParameter("searchtype")%>">Container</a></th>
               <th><a href="./part?ordercolumn=retailprice&searchparameter=<%=request.getParameter("searchparameter")%>&selectcolumn=<%=request.getParameter("selectcolumn")%>&searchtype=<%=request.getParameter("searchtype")%>">Retailprice</a></th>
               <!--th>Match</th-->
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
            </tr>
            <%
               }
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
