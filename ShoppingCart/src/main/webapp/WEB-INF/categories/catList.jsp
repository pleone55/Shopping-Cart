<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/catList.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List</title>
</head>
<body>
	<div class="container">
		<h2>Categories</h2>
		<hr/>
		<c:forEach items="${categories}" var="category">
			<ul>
				<li><a href="/categories/${category.id}">${category.name}</a></li>
			</ul>
		</c:forEach>
		<p>
			<a href="/dashboard">Back to home page</a> 
		</p>
	</div>
</body>
</html>