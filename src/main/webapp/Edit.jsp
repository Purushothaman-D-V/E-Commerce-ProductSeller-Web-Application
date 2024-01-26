<%@page import="java.util.Base64"%>
<%@page import="dto.ProductDto"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateProduct</title>

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
<div class="container">
	<div class="content">
	<% //ProductDao productdao = new ProductDao(); %>
	<% ProductDto productdto = (ProductDto)request.getAttribute("product"); %>
	
	
		<form action="updateproduct" method="post" enctype="multipart/form-data">
			ID 			 : <input type="text" name="id" value="<%= productdto.getId() %>" readonly="true"><br>
			Name 		 : <input type="text" name="name" value="<%= productdto.getName() %>"><br>
			Price  		 : <input type="text" name="price" value="<%= productdto.getPrice() %>"><br>
			Brand 		 : <input type="text" name="brand" value="<%= productdto.getBrand() %>"><br>
			Discount     : <input type="text" name="discount" value="<%= productdto.getDiscount() %>"><br>
			
			
			<% String base64image = new String(Base64.getEncoder().encode(productdto.getImage())); %>
			<img src="data:image/jpeg;base64, <%= base64image %>" >
				
			Choose Image : <input type="file" name="file" ><br>
			<input type="submit" value="Update ">
		</form>
	</div>
</div>

</body>
</html>