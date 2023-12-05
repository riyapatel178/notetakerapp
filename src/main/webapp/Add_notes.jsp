<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="Css/All_Style_jsp.jsp" %>
</head>
<body>
  <%@include file="Navbar.jsp" %>
  <br>
  <h2> Please fill your notes details</h2>
  <form action="Addnote" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" Style="font-weight: bold">Note Title</label>
    <input required type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp">

  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label" Style="font-weight: bold">Note Content</label>
    <textarea required id="content" name="content" placeholder="enter your content here" class="form-control" Style="height:300 px"></textarea>
  </div>
  <div class="container text-center" >
  <button type="submit" class="btn btn-primary">Add</button>
  </div>
</form>

</body>
</html>