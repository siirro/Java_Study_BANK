<%@page import="com.iu.start.bankBook.BankBookDAO"%>
<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
//BankBookDAO bankbookDAO = new BankBookDAO();
//ArrayList<BankBookDTO> ar = bankbookDAO.getList();

ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list 페이지 인덱스에 에태그걸어서 저게나와야함 -->
	
	<a href="./detail">Detail</a>
	<!-- /bankbook/detail jsp:detail.jsp로 이동-->
	<!-- link 주소는 상대경로 작성 -->
	
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th><th></th>
			</tr>
		</thead>
		<tbody>
			<% for(BankBookDTO bankBookDTO :ar){ %>
				<tr>
					<td><a href="./detail?bookNum=<%= bankBookDTO.getBooknum()%>"> <%= bankBookDTO.getBookname() %></a></td>
					<td><%= bankBookDTO.getBookrate() %></td>
				</tr>
			<%} %>
			
		
		
		</tbody>
	
	
	</table>
	
	<a href="./add">상품등록</a>
	
</body>
</html>