<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
	
		<% String message = (String)request.getAttribute("message"); %>
		
		<% if(message!= null){ %>
		<h1> <%= message %> </h1>
		<% } %>
	
		<form action="addproduct" method="post" enctype="multipart/form-data">
			ID 			 : <input type="text" name="id"><br>
			Name 		 : <input type="text" name="name"><br>
			Price  		 : <input type="text" name="price"><br>
			Brand 		 : <input type="text" name="brand"><br>
			Discount     : <input type="text" name="discount"><br>
			Choose Image : <input type="file" name="file"><br>
			<input type="submit" value="ADD">
		</form>
	</div>
</div>

</body>
</html>