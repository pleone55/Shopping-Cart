<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/showProduct.css" type="text/css">
<meta charset="ISO-8859-1">
<title><c:out value="${product.getName()}"/></title>
</head>
<body>
	<div id="container">
		<h1><c:out value="${product.getName()}"/></h1>
		<br>
		<br>
		<ul>
			<c:forEach items="${product.getCategories()}" var="category">
				<li><a href="/categories/${category.id}"><c:out value="${category.getName()}"/></a></li>								
			</c:forEach>
		</ul>
		<form action="/products/<c:out value="${product.getId()}"/>" method="post">
			<input type="hidden" name="_method" value="put">
			<label for="category">Add Category:</label>
				<select name="id">
					<c:forEach items="${categories}" var="category">
						<option value="${category.getId()}" label="${category.getName()}" />
					</c:forEach>										
				</select>
			<input type="submit" value="Submit" class="btn btn-success"/>
		</form>
		<p>
			<a href="/dashboard">Back to home page</a> 
		</p>
	</div>
</body>
</html>