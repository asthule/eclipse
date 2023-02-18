<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>These are the available flights</h1>

<table><tr><th>Flight Id</th>
<th>Source</th>
<th>Destination</th>
<th>Airline Company</th>
<th>Price</th>
</tr>

<tr>

<% session.setAttribute("source", request.getAttribute("source")); %>
<% session.setAttribute("destination", request.getAttribute("destination")); 

session.setAttribute("persons", request.getAttribute("persons"));
session.setAttribute("price", request.getAttribute("price"));
session.setAttribute("date", request.getAttribute("date"));
session.setAttribute("airline", request.getAttribute("airline"));%>

<td><%=request.getAttribute("FlightId") %></td>
<td><%=request.getAttribute("source") %></td>
<td><%=request.getAttribute("destination") %></td>
<td><%=request.getAttribute("airline") %></td>
<td><%=request.getAttribute("price") %></td>
</tr>





</table>

</body>
</html>