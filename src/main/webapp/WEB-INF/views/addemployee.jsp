<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee | Add</title>
</head>
<body>

	<div a"src/main/webapp/WEB-INF/views/addemployee.jsp"lign="center">
	<a href="${pageContext.request.contextPath}/employee/employeeList"><h2>Click Here to check employees</h2></a>
		<div align = "center" style="color: green"> New Employee </div>
		<div clign = "center">
				<table cellspacing="0" cellpadding="6" border="1" width="60%">
							<tr>
								<td colspan="8" align="center">Employee Information</td>
							</tr>
							<tr>
								<td>
										<form:form method="POST" action="updateemployee">
												<table width = "100%">
												<tr>
															<td><form:label path="employeeId">Employee Id</form:label></td>
															<td><form:input path="employeeId" />
														</tr>
														<tr>
															<td><form:label path="firstName">First Name</form:label></td>
															<td><form:input path="firstName" />
														</tr>
														<tr>
															<td><form:label path="lastName">Last Name</form:label></td>
															<td><form:input path="lastName" />
														</tr>
														<tr>
															<td><form:label path="jobTitle">Job Title</form:label></td>
															<td><form:input path="jobTitle" />
														</tr>
														<tr>
																<td colspan="2">
																		<input type="submit" value="submit">
																</td>
														</tr>
												</table>
										</form:form>
								</td>
							</tr>
				</table>
		</div>
		
		<div>
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
		</div>
		
	</div>

</body>
</html>