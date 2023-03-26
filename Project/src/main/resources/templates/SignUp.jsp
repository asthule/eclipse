<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="signup" method="get">
<div>

<h1>Signup</h1>

<div class="item" ><input type="text" placeholder="Username" class="tb"  name="username" /></div>
	<div class="item" ><input type="text" placeholder="Password" class="tb"  name="password" /></div>
    <div class="item" ><input type="text" placeholder="Repeat Password" class="tb"  name="repassword" /></div>
	<div ><input type="submit" value="Signup" class="btn"  /></div>
	<h1>__________________</h1>
	 <br/>
	<h1> Have an account? </h1>
    <button class="btn"><a href="Login">Login</a></button>


</div>


</form>
</body>
</html>