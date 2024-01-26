<html>
<head>

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
		<h2>Hello User!</h2>
		
		<% String message = (String)request.getAttribute("message"); %>
		
		<% if(message!= null){ %>
		<h1> <%= message %> </h1>
		<% } %>
		
		<button><a href = "Login.jsp">Login</a></button><br>
		<button><a href = "SignUp.jsp">SignUp</a></button>
	</div>
</div>
</body>
</html>
