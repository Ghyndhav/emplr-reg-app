<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Employer Registration Form</title>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Employer Registration</h2>
			</div>
		</div>
		<div id="container">
			<h3>Employer Registration Details</h3>
			<form:form action="saveEmployerRegistration" modelAttribute="employerRegistration" method="POST">
				<form:hidden path="${employerRegistration.id}"/>
				<table>
					<tbody>
						<tr>
							<td>Employer Name:</td>
							<td>${employerRegistration.emplrName}</td>
						</tr>
						<tr>
							<td>fein:</td>
							<td>${employerRegistration.fein}</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td>${employerRegistration.email}</td>
						</tr>
						<tr>
							<td>Phone</td>
							<td>${employerRegistration.phone}</td>
						</tr>
						<tr>
							<td><label></label></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear;both;">
				<a href="${pageContext.request.contextPath}/employerRegistrationController/searchEmployerRegistrations">Back to list</a>
			</div>
		</div>
	
	
	</body>



</html>