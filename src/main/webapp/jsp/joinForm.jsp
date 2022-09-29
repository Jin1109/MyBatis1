<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<!doctype html>
<html>
<head>
<title>joinForm.jsp</title>
<link href="css/login.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.6.0.js"></script>

</head>
<body>
	<form action="joinPro.net" method="post">
		<h1>회원가입</h1>
		<hr>
		<b>아이디</b> 
			<input type="text" name="id" placeholder="Enter id" maxLength="10" required> 
		
		<b>Password</b> 
			<input type="password" name="password" placeholder="Enter password" maxLength="10" required>

		<div class="clearfix">
			<button type="submit" class="join">회원가입</button>
			<button type="reset" class="cancel">취소</button>
		</div>
	</form>
</body>
</html>