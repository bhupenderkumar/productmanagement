
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
<h1>Product Management</h1>
<c:if test="${user ne null }">
<h5 align="right"><a href="logout">logout</a> Hi ${user.username}</h5>
</c:if>
<c:if test="${user eq null }">
<h5 align="right"><a href="Login.jsp">login</a></h5>
</c:if>
	</header>
	