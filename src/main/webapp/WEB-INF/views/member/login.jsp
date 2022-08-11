<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	
	<div>
		<form action="./login" method="post">
			ID <input type="text" name="username"> <br>
		    PW <input type="password" name="password">
		    <input type="submit" value="로그인">
		    <input type="reset">
		    이미지 절대경로
		        <img src="/images/jssdf.jpg">
   		</form>
	</div>
	
</body>
</html>


