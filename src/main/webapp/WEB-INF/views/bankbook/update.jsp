<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>
	
	
	<form action="./update.iu" method = "post">

		<input type="text" name="booknum" readonly value="${update.booknum}">
		<div>
			Name : <input type = "text" name="bookname">
		</div>
		<div>
			Rate : <input type="text" name="bookrate">
		</div>
		
		<input type="submit" value="수정">
	
	</form>
</body>
</html>