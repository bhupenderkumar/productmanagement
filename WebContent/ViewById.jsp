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
	<c:if test="${user ne null }">
	<h2>Product Home</h2>
	<div id="frm1">
		<form action="viewbyid">
			<table id="link">
				<tr>
					<th>Product id:<input type="test" name="txtid"
						value="${param.txtid }" /></th>
					<th><input type="submit" /></th>
				</tr>

			</table>
		</form>
	</div>
	<br>
	<div id="frm2" align="center">
		<c:if test="${aprod eq null }">
			<span class="err">No products found</span>
		</c:if>
		<c:if test="${aprod ne null }">
		<img src="images/${aprod.pimg}" height="200" width="200" />	
			<table id="tbl1">
				<tr>
					<th>Product id</th>
					<th>Product Name:</th>
					<th>category</th>
					<th>Price</th>
				</tr>
				<tr>
					<td>${aprod.pid }</td>
					<td>${aprod.pname }</td>
					<td>${aprod.cat }</td>
					<td>${aprod.price }</td>
				</tr>
			</table>
		</c:if>


	</div>
	</c:if>
	<c:if test="${user eq null }">
		<jsp:forward page="Login.jsp">
			<jsp:param value="You are not authorized" name="msg" /></jsp:forward>


	</c:if>
	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>