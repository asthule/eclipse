<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Passenger Booking Details</h1>

<table><tr><th>Passenger's Name</th>
<th>EmailId</th>
<th>Source</th>
<th>Destination</th>
<th>Date</th>
<th>Airways</th>

<tr>
<td><%=request.getAttribute("passengerName") %></td>
<td><%=request.getAttribute("emailId") %></td>
<td><%=request.getAttribute("source") %></td>
<td><%=request.getAttribute("destination") %></td>
<td><%=request.getAttribute("date") %></td>
<td><%=request.getAttribute("airline") %></td>
</tr>
</table>
<br/>

<a href="Password.html">Change Password</a><br>

<a href="login.html">Login</a>









</table>

</body>
</html>