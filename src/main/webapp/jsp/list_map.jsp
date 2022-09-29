<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트-list.jsp</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
   .container{width:500px; margin:0 auto}
   legent{text-align: center; color:#17a2b8}
</style>
<script src="js/jquery-3.6.0.js"></script>

</head>
<body>
<div class="container">
<fieldset>
<legend>회원 리스트</legend>
   <table class="table">
   <tr>
      <th>아이디</th><th>비밀번호</th><th>수정</th><th>삭제</th>   
   </tr>

	<c:forEach var="member" items="${list}">
		<tr>
			<td>${member.ID }</td>
			<td>${member.PASSWORD }</td>
			<td><button class="btn btn-info" type="button" data-id="${member.ID }">수정</button>
			</td>
			<td>
				<c:if test="${member.ID!='admin'}">
					<button class="btn btn-danger" type="button" data-id="${member.ID }">삭제</button>
				</c:if>
			</td>
		</tr>
	</c:forEach>
			</table>
   <a href="main.net">메인으로</a>
</fieldset>
</div>
<script>
   $(".btn-info").click(function(){
      var id=$(this).attr("data-id");
      location.href='updateForm.net?id='+id;
   })
   
   $(".btn-danger").click(function(){
      var id=$(this).attr("data-id");
      if(confirm("정말 삭제 하시겠습니까?")){
         location.href="delete.net?id="+id
      }
   })
</script>
</body>
</html>