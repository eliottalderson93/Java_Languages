<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${lang.name} Edit</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<form action = "/languages/${lang.id}" method = "post">
<input type = "hidden" name = "_method" value = "delete">
<button>Delete</button>
</form>
<a href = "/languages">Dashboard</a>
<form:form action = "/languages/${lang.id}" method = "post" modelAttribute = "language">
	<input type = "hidden" name = "_method" value = "put">
	<form:input name = "id" path = "id" type = "hidden" value = "${lang.id}"/>
	<form:label path = "name">Name: </form:label><form:errors path = "name"/><form:input type = "text" name = "name" id = "1" value = "${lang.name }" path = "name"/>
	<form:label path = "creator">Creator: </form:label><form:errors path = "creator"/><form:input type = "text" name = "creator" id = "2" value = "${lang.creator }" path = "creator"/>
	<form:label path = "version">Version: </form:label><form:errors path = "version"/><form:input type = "number" step = "0.1" name = "version" id = "3" value = "${lang.version }" path = "version"/>
	<input type = "submit" value = "Submit"/>
</form:form>
</body>
</html>