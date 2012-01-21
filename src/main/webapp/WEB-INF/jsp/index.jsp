<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h2>Hello World!</h2>
	<p><a href="<c:url value="/admin/"/>">admin</a></p>
	<c:forEach items="${posts}" var="post">
		${post.title} ${post.tease}
	</c:forEach>
</body>
</html>
