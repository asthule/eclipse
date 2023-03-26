<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="SearchResults" method="get">
<div>
<h1 class="item">Search</h1>

<div class="item" ><input type="text" placeholder="search" class="tb"  name="search" /></div>
	<div class="item" >
        <div style="color:white; margin: 10px; text-align:center;">Search Products</div> 
        <select class="tb" name="searchoption">
        <option value="id">Search By Product Id</option>
        <option value="pname">Search by Product Name</option>
        </select></div>
	<div ><input type="submit" value="Search" class="btn"  /></div>


</div>
</body>
</html>