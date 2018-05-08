<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Goal</title>
<style type="text/css">
.error{
color:#ff0000;
}

</style>
</head>
<body>
<h1> Add Goal Minutes</h1>
<form:form modelAttribute="goal">
<form:errors path="*" element="div"/>
	<table>
		<tr>
			<td><spring:message code="goal.text"/></td>
			<td><form:input path="minutes" cssErrorClass="error"/></td>
			<td><form:errors path="minutes" cssClass="error"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Enter Goal Minutes"/></td>
		</tr>
	</table>

</form:form>
</body>
</html>