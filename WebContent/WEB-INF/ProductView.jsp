<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Management</title>
<link href="prod.css" rel="stylesheet">
</head>
<body>
	<%@include file="../Header.jsp"%>
	<section>

	<h2>Product List</h2>
	<table id="tbl1">
		<tr>
			<th>IMG</th>
			<th>ID</th>
			<th>Product Name</th>
			<th>price</th>
			<th>category</th>
		</tr>

		<c:forEach items="${prodList}" var="p">
			<tr>
				<td><img src="images/${p.pimg}" /></td>
				<td>${p.pid}</td>
				<td>${p.pname}</td>
				<td>${p.price}</td>
				<td>${p.cat}</td>
			</tr>
		</c:forEach>

	</table>
	<div align="center">
		<c:forEach begin="1" end="${link}" varStatus="p">
			<a href="viewall?pg=${p.count}">${p.count}</a>
		</c:forEach>
	</div>
	<div align="left">
	<c:if test="${currpage eq 1}">
		<a href="prev" style="display: none">Prev</a>
	</c:if> <c:if test="${currpage ne 1}">
		<a href="prev">Prev</a>
		</div>
		<div align="right">
	</c:if> <c:if test="${currpage eq link}">
		<a href="next" style="display: none">next</a>
	</c:if> <c:if test="${currpage ne link}">
		<a href="next">next</a>
	</c:if>
	</div> </section>

	<%@include file="../Footer.jsp"%>
</body>
</html>