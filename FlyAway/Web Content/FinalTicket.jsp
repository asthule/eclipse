<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Booking Done Successfully.Happy Journey</h1>
<h1>Thank You <%=request.getAttribute("passengerName").toString() %>for booking with FlyAway!</h1>
<h1>Your Ticket</h1>

Passenger's Name: <%=request.getAttribute("passengerName").toString() %>
Destination: <%=request.getAttribute("destination").toString() %>
Departure Date: <%=request.getAttribute("date").toString() %>
Airways: <%=request.getAttribute("airline").toString() %>

<input type="submit" value="Submit">


</body>
</html>