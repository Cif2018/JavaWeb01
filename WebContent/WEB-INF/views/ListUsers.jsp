<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style><%@include file="/WEB-INF/css/defaultStyle.css"%></style>

<title>The list with available users</title>
</head>
<body>

<h1 align="center">user & passwords:</h1>


<%
ArrayList<String[]> data=(ArrayList<String[]>)request.getAttribute("data");

for(String[] d:data){

	out.print("<h2 style=\"color:black; background-color: #CACFD2\">"+d[0]+" "+d[1]);

}
%>
<br>
<br>
<br>
<br>
<div align="center">
<form action="Login.do" method="post">
<input type="hidden" name="goBack" value="goBackAdmin">
<input type="submit" value="Go back">
</form>
</div>


</body>
</html>