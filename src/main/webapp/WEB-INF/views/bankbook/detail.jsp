<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail");
%>
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
	
	<% if(bankBookDTO != null){ %>

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
				<td><%= bankBookDTO.getBooknum() %></td>
				<td><%= bankBookDTO.getBookname() %></td>
				<td><%= bankBookDTO.getBookrate() %></td>
				<td><% if(bankBookDTO.getBooksale()==1){ %>
					판매중
				<%} else { %>
					판매금지
				<%}	%>
				</td>
			</tr>

		</tbody>
	
	
	</table>
	
	<% } else { %>
		<h3>Data가 없다</h3>
	<% } %>
</body>
</html>