
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Query" %>
<%@ page import="com.provider.FactoryProvider" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.entities.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All notes</title>
<%@include file="Css/All_Style_jsp.jsp" %>
</head>
<body>
 <%@include file="Navbar.jsp" %>
 <br>
 <h2>All Your Notes</h2>
 
 <div class="row">
 <div class="col-12">
 <%
 	
 	Session s = FactoryProvider.getFactory().openSession();
 	Query q = s.createQuery("from Note");
 	List<Note> list = q.list();
 	for(Note note:list){
 	%>
 	
 	<div class="card" >
  <div class="card-body">
   <img src="notepad.png" style="max-width:90px" class="card-img-top pl-1 pt-4" alt="...">
    <h5 class="card-title"><%=note.getTitle()%></h5>
    <p class="card-text"><%=note.getContent() %></p>
    <p class="card-text"><%=note.getAddeddate() %></p>
    <a href="delete?note_id=<%= note.getId() %>"  class="btn btn-danger">Delete</a>
    <a href="Edit.jsp?note_id=<%= note.getId() %>" class="btn btn-danger">Update</a>
  </div>
</div>	
 	<%
 		
 	}
 	
 		s.close();
 	
 
 
 %>
 
 
 
 </div>
 
 </div> 
 
 

</body>
</html>