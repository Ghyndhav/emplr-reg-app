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
			<h3>Save Employer Registration</h3>
			<form:form action="saveEmployerRegistration" modelAttribute="employerRegistration" method="POST">
				<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td>Employer Name:</td>
							<td><form:input path="emplrName"/></td>
						</tr>
						<tr>
							<td>FEIN:</td>
							<td><form:input path="fein"/></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><form:input path="email"/></td>
						</tr>
						<tr>
							<td>phone:</td>
							<td><form:input path="phone"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear;both;">
				<a href="${pageContext.request.contextPath}/employerRegistrationController/searchEmployerRegistrations">Back</a>
			</div>
		</div>
	
	
	</body>



</html>