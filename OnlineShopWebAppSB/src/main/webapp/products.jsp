<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  session="false" import="com.phoenix.data.Product,java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<%@ include file="header.html" %>
<body bgcolor="pink">

	
	<%
		HttpSession session = request.getSession(false);
		if(session!=null)
		{	%>
			<p>Dear <%=session.getAttribute("user") %> Choose your favourite products</p>
			
			<% List<Product> products=(List<Product>)session.getAttribute("products"); %>
			<table border="1">
				<tr>
					<td>Product Id</td>
					<td>Name</td>
					<td>Brand</td>
					<td>Price</td>
				</tr>
				<% for(Product product:products){ %>
				<tr>
					<td><%= product.getId() %></td>
					<td><%= product.getName() %></td>
					<td><%= product.getBrand() %></td>
					<td><%= product.getPrice() %></td>
				</tr>
				<%} %>
			
			</table>
	
	
	<% 	}else {	%>
			
			<h2 style="color:red;">Sorry! session expired</h2>
			
	<%	} %>
	
	

	
</body>
<%@ include file="footer.html" %>
</html>