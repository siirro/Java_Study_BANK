<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 등록 페이지</h1>
		<form action="./add" method="post">
			<div>
				통장명 <input type="text" name="bookname">
			</div>
			<div>
				이자율 <input type="text" name="bookrate">
			</div>
			<input type="submit" value="등록">
			<button type="submit">add</button>
		</form>
</body>
</html>