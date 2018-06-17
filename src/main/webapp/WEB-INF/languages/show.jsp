<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${lang.name}</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<p>${lang.name}</p>
<p>${lang.creator}</p>
<p>${lang.version}</p>
<a href = "/languages/${lang.id}/edit">Edit</a>
<form action = "/languages/${lang.id}" method = "post">
<input type = "hidden" name = "_method" value = "delete">
<button>Delete</button></form>
</body>
</html>