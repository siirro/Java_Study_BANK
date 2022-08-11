<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%
//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail");
%> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail</h1>
	
	로그인은 상대경로
	<a href="../member/login">Login</a>
	
	조인은 절대경로
	<a href="/member/join">Join</a>
	
	<a href="./list">리스트보기</a>
	
	<a href="./update?booknum=${detail.booknum}">수정</a>
	
	<a href="./delete?booknum=${detail.booknum}">삭제</a>

	<table border="1">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Rate</th>
				<th>Sale</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.detail.getBooknum()}</td>
				<td>${requestScope.detail.bookname}</td>
				<td>${detail.bookrate}</td>
				<td>${detail.booksale}
				
				
				</td>
			</tr>

		</tbody>
	
	
	</table>
	

</body>
</html>