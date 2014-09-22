<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${not empty param.login_error}">
	<div id="errors" class="error" style="font-size: large; width:100%">
		<p>Failed Login: ${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
	</div>	
</c:if>

<br/><br/><br/><br/>

<form action="<c:url value='/j_spring_security_check'/>" method="post">
	<fieldset>
		<legend style="font-size: medium;">User Login</legend>
		<ul>
			<li>
				<label for="j_username">Username</label>
				<div class="control">
					<input type='text' id='j_username' name='j_username' value='<c:out value="${user}"/>'/>
				</div>
			</li>
			<li>
				<label for="j_password">Password</label>
				<div class="control">
					<input type='password' id='j_password' name='j_password'/>
				</div>
			</li>
			<li class="confirm">
				<label>
					<input type="checkbox" name="_spring_security_remember_me"/>
					Remember Me
				</label>
			</li>
		</ul>
		<button type="submit">Login</button>
	</fieldset>
</form>

</body>
</html>