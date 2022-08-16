<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글 수정 페이지</h3>

<form action="update.iu" method="post">
	<input type="text" value=${update.boardNum} name="boardNum"> <br>
제목 : <input type="text" name="boardTitle"><br>
내용 : <textarea rows=4 name="boardContent"></textarea>
<input type="submit" value="수정">
</form>
</body>
</html>