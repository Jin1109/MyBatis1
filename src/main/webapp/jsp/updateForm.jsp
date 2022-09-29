<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보수정.jsp</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
.container{width:500px; margin-top: 3em}
</style>
</head>
<body>
<div class="container">
   <form action="updatePro.net">
      <h1>정보 수정</h1>
      <hr>
   <div class="form-group">
      <b>아이디</b>
         <input type="text" name="id" value="${mem.id}" maxLength="10" readOnly class="form-control"><br>
      <b>Password</b>
         <input type="text" name="password" value="${mem.password}" class="form-control">
      </div>
   
   <div class="clearfix">
      <button class="btn btn-info" type="submit">변경</button>
      <button class="btn btn-warning" type="button" onclick="history.go(-1)">
         취소</button>
   </div>
   </form>
</div>
</body>
</html>