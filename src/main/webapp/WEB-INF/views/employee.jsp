<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<h1 style="color:green; text-align:center;">
	Check the Employee List
</h1>
<a href="${pageContext.request.contextPath}/employee/addemployee"><h2>Click Here to add employee</h2></a>
<table cellspacing="0" cellpadding="6" border="1">
	<tr>
	<td>First Name</td>
	<td>Last Name</td>
	<td>Job Title</td>
	<td>Delete</td>
	</tr>
	<c:forEach var="employee" items="${employeeList }" >
		<tr>
			<td>${ employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.jobTitle}</td>
			<td><a href="${pageContext.request.contextPath}/employee/delete/${employee.employeeId}" >delete</a></td>
		</tr>
		
	
	</c:forEach>
</table>

</body>
</html>