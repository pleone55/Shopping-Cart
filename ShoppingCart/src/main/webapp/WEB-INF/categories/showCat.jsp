<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/showCat.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Info</title>
</head>
<body>
	<div class="container">
		<h2>Category</h2>
	<hr/>
		<p>
			Name : ${category.name}
		</p>
		<h2>Products in this category</h2>
		<p>
			<c:forEach items="${category.products}" var="catPro">
				<ul>
					<li>${catPro.name}</li>
				</ul>
			</c:forEach>
		</p>
		<p>
			<a href="/categories">Back to categories</a>
			<br><br> 
			<a href="/dashboard">Back to home page</a> 
		</p>
	</div>
</body>
</html>