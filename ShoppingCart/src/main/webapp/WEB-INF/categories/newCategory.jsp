<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/category.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="dashboard">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="form-box">
			<form:form action="/categories/new" method="post" modelAttribute="category">
				<h1>New Category</h1>
				<p>
					<form:label path="name">Name:</form:label> 
					<form:input path="name"/>
					<form:errors path="name"/>
				</p>
				<input type="submit" value="Submit" class="btn btn-success"/>
			</form:form>
		</div>
	</div>
</body>
</html>