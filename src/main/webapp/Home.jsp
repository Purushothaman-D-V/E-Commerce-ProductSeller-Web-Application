<%@page import="dao.ProductDao"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  page import= "java.util.List" %>
<%@  page import= "dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>-- Home --</title>

	<style>
		.container{
		display: flex;
		justify-content: center;
		align-items: center;
		height: auto;
		}
		.content{
		text-align: center:
		}
	</style>

</head>
<body>
<% HttpSession session1 = request.getSession(); %>
<% String email = (String)session.getAttribute("email"); %>
<% if(email!=null){ %>
	<div class="container">
		<div class="content">
			<button><a href = "AddProduct.jsp">AddProduct</a></button><br>
			<button></button><br>
			
			<table border="1px">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Brand</th>
					<th>Discount</th>
					<th>Image</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				
				<% ProductDao productdao = new ProductDao(); %>
				<% List<ProductDto> products = productdao.findAll(); %>
				
				<% //List<ProductDto> products = (List)request.getAttribute("products"); %>
				<% for(ProductDto p :products) {%>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getName() %></td>
					<td><%= p.getPrice() %></td>
					<td><%= p.getBrand() %></td>
					<td><%= p.getDiscount() %></td>
					<% String base64image = new String(Base64.getEncoder().encode(p.getImage())); %>
					<td><img src="data:image/jpeg;base64, <%= base64image %>" height="100px" width="100px" src=""></td>
					<td><button><a href = "edit?id=<%= p.getId() %>">Edit</button></td>
					<td><button><a href = "delete?id=<%= p.getId() %>">Delete</a></button>
				</tr>
				<% } %>
				
			</table>
			
			<button><a href = "logout">Logout</button>
			
		</div>
	</div>
<% }else{ %>

<% request.setAttribute("message", "Login is Required"); %>
<% RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp"); %>
<% dispatcher.include(request, response); %>
	
<% } %>


</body>
</html>