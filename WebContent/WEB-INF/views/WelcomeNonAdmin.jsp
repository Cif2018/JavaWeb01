<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style><%@include file="/WEB-INF/css/defaultStyle.css"%></style>

<title>${name} page</title>
</head>
<body>
<h1 align="center">Welcome ${name}!</h1>


<div>
<br>

<ol type="A">

  <li><a href="HandleOptions?option=checkTickets">Check Ticket List</a></li>
  <li><a href="HandleOptions?option=listNetworkElements">List Network Elements</a></li>
  <li><a href="HandleOptions?option=dashboard">Dashboard</a></li>

</ol>  
</div>

<div align="center">
<form action="Login.do" method="get">
<input type="submit" value="Logout">
</div>


</body>
</html>