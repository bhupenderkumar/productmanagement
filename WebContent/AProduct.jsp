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
	<%@include file="Header.jsp"%>
	<c:if test="${login ne null}">
	<section>
	<h2>View By ID</h2>
	<div id="frm1">
		<form action="viewid">
			Product Id 
			<input type="text" value="${param.txtid }" name="txtid" id="txtid" /> <input
				type="submit" value="search" />
		</form>
	</div>
	<c:if test="${aprod eq null}">
	<span class="err">
	 Product not found
	</span>
	</c:if>
	<c:if test="${aprod ne null}">
	    <div id="frm1">
	    <img src="images/${aprod.pimg}" height="200" width="200"/>
	</div>
	</c:if>
	<table id="link">
	<tr>
	<td>Product Id</td>
	<td>${aprod.pid}</td>
	</tr>
	
	<tr>
	<td>Product Name</td>
	<td>${aprod.pname}</td>
	</tr>
	
	<tr>
	<td>Price</td>
	<td>${aprod.price}</td>
	</tr>
	
	<tr>
	<td>Category</td>
	<td>${aprod.cat}</td>
	</tr>
	
	</table>
	
	</c:if>
<c:if test="${login eq null}">
    <jsp:forward page="Login.jsp">
    <jsp:param value="You are not authenticated" name="msg"/>
    </jsp:forward>		
</c:if>	
<hr />
	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>







