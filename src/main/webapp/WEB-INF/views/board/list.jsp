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
	
	<c:if test="${not empty sessionScope.member}">
	<div>
	<a href="add.iu">글 작성</a>
	</div>
	</c:if>
	<br>
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
				<td>${boarddto.boardNum}</td>
				<td><a href="./detail.iu?boardNum=${pageScope.boarddto.boardNum}">${boarddto.boardTitle}</a></td>
				<td>${boarddto.boardWriter}</td>
				<td>${boarddto.boardDate}</td>
				<td>${boarddto.boardHit}</td>
			</tr>
		</c:forEach>

		</tbody>

	</table>

</body>
</html>