<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>Access <a href="secured">secured page</a></p>
<!-- 
<table class="niceTable">
	<caption>List of ExceptionResolvers</caption>
	<thead><tr><td class="niceTableCell">Bean Name</td></tr></thead>
	<tbody>
		<c:forEach items="${beans }" var="bean">
			<tr><td class="niceTableCell"><c:out value="${bean }" /></td></tr>
		</c:forEach>
	</tbody>
</table>
 -->
<security:authorize access="isAuthenticated()">
	        	            <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
</security:authorize>

</body>
</html>
