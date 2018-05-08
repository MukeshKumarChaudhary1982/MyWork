<%-- <%@taglib prefix="c" uri="Http://Java.Sun.Com/JSP/Jstl/Core"%> --%>

<html>
<head>
<title>Fitness Tracker Custom Login Form</title>
</head>

<body onload='document.f.j_username.focus()'>
<h3>Fitness Tracker Custom Login Page</h3>
	<%-- <c:if test="${not empty error} }">
		<div>
			Your Login Was Unsucessfull.</br>
			caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].messsage }
		</div>
	</c:if> --%>
	<form action="j_spring_security_check" name="f" method="post">
		<table>
			<tr>
				<td>User:</td>
				<td><input type="text" name="j_username" value=""></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="submit"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" name="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>