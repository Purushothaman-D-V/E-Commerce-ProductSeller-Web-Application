<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>-- Sign Up --</title>

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
		<form action="signup" method="post" style="text-align: center;">
		<h1>Seller Details</h1>
		Seller ID : <input type="text" name="id"><br>
		Seller Name : <input type="text" name="name"><br>
		Seller Contact : <input type="text" name="contact"><br>
		Seller Email : <input type="text" name="email"><br>
		Seller Password : <input type="text" name="password"><br>
		<input type="submit" value="Submit">
		</form>
	</div>
</div>
</body>
</html>