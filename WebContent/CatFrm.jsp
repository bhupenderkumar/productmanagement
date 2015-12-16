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
	<%@include file="Header.jsp"%>
	<section> <c:if test="${user ne null }">
		<h2>View By ID</h2>
		<div id="frm1">
			<form action="getbycat">
				Catergory <select name="txtcat">
					<c:forEach items="${catset }" var="str">
						<option value="${str}">${ str}</option>
					</c:forEach>
				</select> <input type="submit" value="search" />
			</form>
		</div>

		<hr />
	</c:if> </section>
	<c:if test="${user eq null }">
		<jsp:forward page="Login.jsp">
			<jsp:param value="You are not authorized" name="msg" /></jsp:forward>


	</c:if>
	<%@include file="Footer.jsp"%>
</body>
</html>