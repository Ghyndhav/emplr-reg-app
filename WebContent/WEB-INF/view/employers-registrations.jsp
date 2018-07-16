<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Employer Registrations</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
		
			<h2>Employer Registration Details</h2>
		
		</div>
	
	</div>
	<div id="container">
	
		<div id="content">
			<input type="button" value="Add Employer Registration"
				   onclick="window.location.href='addEmployerRegistration'; return false"
				   class="add-button"
			/>
			<c:if test="${!empty allEmployerRegistrations}" >
				<table>
					<tr>
						<th>Employer Name</th>
						<th>FEIN</th>
						<th>Email</th>
						<th>Phone</th>
						<th></th>
					</tr>
					<c:forEach var = "employerReg" items="${allEmployerRegistrations}">
						<c:url var="updateLink" value="/employerRegistrationController/updateEmployerRegistration">
							<c:param name="employerRegistrationId" value="${employerReg.id}" />
						</c:url>
						<c:url var="deleteLink" value="/employerRegistrationController/deleteEmployerRegistration">
							<c:param name="employerRegistrationId" value="${employerReg.id}" />
						</c:url>
						
						
						<tr>
							<td>${employerReg.emplrName}</td>
							<td>${employerReg.fein}</td>
							<td>${employerReg.email}</td>
							<td>${employerReg.phone}</td>
							<td><a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onClick="if(!(confirm('Are you sure you want to delete Employer Registration?'))) return false">Delete</a>
							</td>
						</tr>					
					</c:forEach>
				</table>
			</c:if>
			<br><br>
			<form:form name="search" action="searchEmployer" method="post" >
			Search By Employer Name : <input type="text" name="emplrName" />
				<input type="submit" value="Search Employer Registration"
				   class="add-button"/>
			</form:form>
			<c:choose>
			<c:when test="${!empty employerRegistrations}" >
				<table>
					<tr>
						<th>Employer Name</th>
						<th>FEIN</th>
						<th>Email</th>
						<th>Phone</th>
						<th></th>
					</tr>
					<c:forEach var = "employerRegistration" items="${employerRegistrations}">
					<tr>
						<td>${employerRegistration.emplrName}</td>
						<td>${employerRegistration.fein}</td>
						<td>${employerRegistration.email}</td>
						<td>${employerRegistration.phone}</td>
						<c:url var="updateEmployerRegistrationLink" value="/employerRegistrationController/updateEmployerRegistration">
							<c:param name="employerRegistrationId" value="${employerRegistration.id}" />
						</c:url>
						<c:url var="deleteEmployerRegistrationLink" value="/employerRegistrationController/deleteEmployerRegistration">
							<c:param name="employerRegistrationId" value="${employerRegistration.id}" />
						</c:url>
						<td><a href="${updateEmployerRegistrationLink}">Update</a>
						|
						<a href="${deleteEmployerRegistrationLink}"
							onClick="if(!(confirm('Are you sure you want to delete Employer Registration?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>${message}</td>
					</tr>
				</table>
			</c:otherwise>
			</c:choose>
		</div>
	
	</div>
</body>

</html>