<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<%@ include file="/jsp/include.jsp"%>

</head>
<body style="background-color: #ffffff;">
	<div id="top_header"></div>
	<div id="header">
		<h1>Please Login</h1>
	</div>
	<div id="body" >
		<form:form name="myForm" id="myForm" method="post">
			<center >
				<label>Username</label>
				<form:input path="userName" />
				</br></br> <label> Password </label>
				<form:password path="password" />
				</br> </br> <input type="submit" value="Save" />
		</form:form>
		</center>
	</div>
</body>
</html>