<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<a href="<c:url value="/admin/new"/>">new post</a>
	<c:forEach items="${posts}" var="post">
		${post.title} ${post.tease}
	</c:forEach>
</body>
</html>
