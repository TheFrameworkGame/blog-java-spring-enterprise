<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h2>Hello World!</h2>
	<p><a href="<c:url value="/admin/"/>">admin</a></p>
	<c:forEach items="${posts}" var="post">
		<h3><a href="<c:url value="/${post.slug}"/>">${post.title}</a> (${post.postDate})</h3>
		<p>${post.tease}</p>
	</c:forEach>
</body>
</html>
