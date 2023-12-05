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
<title>Note Edit</title>
<%@include file="Css/All_Style_jsp.jsp" %>
</head>
<body>
<%@include file="Navbar.jsp" %>
<h1>Edit your Note</h1>
<%
int noteId = Integer.parseInt(request.getParameter("note_id").trim());
FactoryProvider factory = new FactoryProvider();
Session s = factory.getFactory().openSession();
Note note = s.get(Note.class, noteId);
%>

<form action="Updatenote" method="post">
<input value=<%=note.getId() %> name="note_id" type="hidden">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label"  Style="font-weight: bold">Note Title</label>
    <input required type="text" class="form-control" id="title" name="title" value="<%=note.getTitle() %>" aria-describedby="emailHelp">

  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label" Style="font-weight: bold">Note Content</label>
    <textarea required id="content" name="content"  class="form-control" 
     Style="height:300 px" rows="" cols=""><%=note.getContent() %></textarea>
  </div>
  <div class="container text-center" >
  <button type="submit" class="btn btn-success">Save</button>
  </div>
</form>

</body>
</html>