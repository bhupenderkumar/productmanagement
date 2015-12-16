<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Management</title>
<link href="prod.css" rel="stylesheet">

</head>
<body>
<%@include file="Header.jsp" %>
<section>
<h2>Product Home </h2>
	<table id="link">
		<tr>
			<td><a href="viewall?pg=1">View Products</a></td>
			<td><a href="CatFrm.jsp">View Products BY Category</a></td>
		</tr>
		<tr>
			<td><a href="ViewById.jsp">View Products By ID</a></td>
			<td><a href="AddProduct.jsp">Add Products</a></td>
		</tr>
	</table>${rows}
	<div id="frm1">
	<span class="err">
	<c:if test="${rows ne null }">
	<c:if test="${rows >0 }">
	product inserted
	</c:if>
	<c:if test="${rows == 0 }">
	Products id already existed
	</c:if>
	</c:if>
	
	</span></div>
</section>
<%@include file="Footer.jsp" %>
</body>
</html>