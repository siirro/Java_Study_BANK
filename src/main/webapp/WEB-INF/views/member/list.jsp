
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Search Result</h1>	

	
	
	
	<table border="1">
		<thead>
			<tr>
				<th>username</th>
				<th>password</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach begin="0" end="10" var="i">
		<h3>${pageScope.i}</h3>
		</c:forEach>

		<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${pageScope.dto.username}</td>
				<td>${pageScope.dto.password}</td>
				<td>${pageScope.dto.name}</td>
				<td>${pageScope.dto.email}</td>
				<td>${pageScope.dto.phone}</td>
			</tr>
		</c:forEach>
	
			
			<%-- 
				<% for(BankmembersDTO bankmembersDTO:ar) { %>
				<tr>
				
					<td><%= bankmembersDTO.getUsername() %></td>
					<td><%= bankmembersDTO.getPassword() %></td>
					<td><%= bankmembersDTO.getName() %></td>
					<td><%= bankmembersDTO.getEmail() %></td>
					<td><%= bankmembersDTO.getPhone() %></td>
					
				</tr>
				<% } %>
				--%>

		</tbody>
	
	
	</table>
	 
</body>
</html>