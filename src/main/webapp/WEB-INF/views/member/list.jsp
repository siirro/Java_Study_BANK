<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankmembers.BankmembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
ArrayList<BankmembersDTO> ar = (ArrayList<BankmembersDTO>)request.getAttribute("list");
%>
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
			
				<% for(BankmembersDTO bankmembersDTO:ar) { %>
				<tr>
				
					<td><%= bankmembersDTO.getUsername() %></td>
					<td><%= bankmembersDTO.getPassword() %></td>
					<td><%= bankmembersDTO.getName() %></td>
					<td><%= bankmembersDTO.getEmail() %></td>
					<td><%= bankmembersDTO.getPhone() %></td>
					
				</tr>
				<% } %>

		</tbody>
	
	
	</table>
</body>
</html>