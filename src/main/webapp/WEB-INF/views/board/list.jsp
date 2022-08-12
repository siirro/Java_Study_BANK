<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글목록 페이지</h3>
	글번호, 글제목, 작성자, 작성날짜, 조회수
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		
		<tbody>
		
		<c:forEach items="${requestScope.list}" var="boarddto">
			<tr>
				<td>${pageScope.dto.bookrate}</td>
				<td><a href="./detail.iu?booknum=${pageScope.dto.booknum}">${pageScope.dto.bookname}</a></td>
				<td>${pageScope.dto.bookrate}</td>
				<td>${pageScope.dto.booksale}</td>
			</tr>
		
		</c:forEach>

		</tbody>

	</table>

</body>
</html>