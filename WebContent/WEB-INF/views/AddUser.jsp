<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style><%@include file="/WEB-INF/css/defaultStyle.css"%></style>

<title>Add a new user</title>
</head>
<body>

	<h1 align="center">Enter the new user credentials ...</h1>
	<tr>
		<td colspan="2">
			<form action="AddUserServlet" method="post">
				<table cellspacing="0" cellpadding="3">
					<tbody>
						<tr>
							<td class="row-right"><small>Enter name!: </small></td>
							<td class="row-left"><input type="text" name="name"
								size="20"></td>
						</tr>
						<tr>
							<td class="row-right"><small>Enter password!:</small></td>
							<td class="row-left"><input type="password" name="passwd"
								size="20"></td>
						</tr>
						<tr>
							<td class="row-right">&nbsp;</td>							
							<td class="row-left"><input type="submit" value="ADD NEW USER"></td>
						</tr>

					</tbody>

				</table>

			</form>
		</td>
	</tr>


	<h1 style="color: red; background-color: #CACFD2" align="center">${errorMsg}</h1>

</body>
</html>