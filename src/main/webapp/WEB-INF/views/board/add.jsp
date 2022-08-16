<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>작성 페이지</h3>
	
	<form action="add.iu" method="post">

	작성자 : <input type="text" readonly value="${sessionScope.member.username}" name="boardWriter"><br>
	제목 : <input type="text" name="boardTitle"><br>
	내용<br>
	<textarea rows="10" name="boardContent"></textarea>
	<input type="submit" value="등록">
	</form>
	
</body>
</html>