<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page session="false" %>
<html>
<head>
	<title>Secured Page</title>
	<link href="resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>
	You have been granted access!  
</h1>

<p>  The time on the server is ${serverTime}. <br><br>
<table class="niceTable">
	<tbody>
	   <tr><td class="niceTableCell">UserName</td><td class="niceTableCell"><security:authentication property="principal.username"/></td></tr>
	   <tr><td class="niceTableCell">Password</td><td class="niceTableCell"><security:authentication property="principal.password"/></td></tr>
	   <c:if test="${extendedUserDetails }">
		   <tr><td class="niceTableCell">Phone</td><td class="niceTableCell"><security:authentication property="principal.phone"/></td></tr>
		   <tr><td class="niceTableCell">Email</td><td class="niceTableCell"><security:authentication property="principal.email"/></td></tr>
	   </c:if>
	   <tr><td class="niceTableCell">Roles</td><td class="niceTableCell"><security:authentication property="principal.authorities"/></td></tr>
	</tbody>

</table>

</p>
<p>
<security:authorize access="isAuthenticated()">
	        	            <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
</security:authorize>

</p>
</body>
</html>
