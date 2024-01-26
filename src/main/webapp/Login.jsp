<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>-- User Login __</title>

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
		<h5> <%= message %> </h5>
		<% } %>
		
			<form action="login" method="post" style="text-align: center;">
				Email : <input type="text" name="email"><br>
				Password : <input type="text" name="password"><br>
				<input type="submit" value="Login">
			</form>
	</div>
</div>
</body>
</html>