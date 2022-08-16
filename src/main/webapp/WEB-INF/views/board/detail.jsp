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
	<h3>글 상세 페이지</h3>

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
			<tr>
				<td>${detail.boardNum}</td>
				<td>${detail.boardTitle}</td>
				<td>${detail.boardWriter}</td>
				<td>${detail.boardDate}</td>
				<td>${detail.boardHit}</td>
				
			</tr>
		</tbody>

	</table>
	
	<br>
	
	<table border="1">
		<thead>
			<tr>
				<th>글내용</th>
			</tr>
	</thead>
	<tbody>
		<tr>
			<td>${detail.boardContent}</tr>
		</tr>
		</tbody>
	</table>
	
	<c:if test="${detail.boardWriter eq sessionScope.member.username}">
		<a href="update.iu?boardNum=${detail.boardNum}">수정</a>
		<a href="delete.iu?boardNum=${detail.boardNum}">삭제</a>
	</c:if>
	
</body>
</html>