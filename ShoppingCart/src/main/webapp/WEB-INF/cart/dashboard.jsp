<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Dashboard</title>
</head>
<body>
	<div id="container">
		<h1>List of Products</h1>
		<table class="table">
    		<thead>
		      <tr>
		        <th>Name</th>
		        <th>Price</th>
		        <th>Action</th>
		      </tr>
		    </thead>
		    <tbody>
		    <c:forEach items="${products}" var="product">
		      <tr class="info">
		        <td><a href="/products/${product.id}">${product.name}</a></td>
		        <td>${product.price}</td>
		        <td><a href="/add/${product.id}">Add to Cart</a></td>
		      </tr>
		     </c:forEach>      
		   </tbody>
  		</table>
  		<p><a href="categories">Categories</a></p>
		<% if(session.getAttribute("productSesh") != null){ %>
		<p>
			<a href="cart">Show Cart</a>
		</p>
		<%
		}
		%>
	</div>
</body>
</html>