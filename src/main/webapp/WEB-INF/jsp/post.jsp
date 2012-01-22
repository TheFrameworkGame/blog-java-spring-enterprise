<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h2><c:out value="${post.title}"/></h2>
	<p>${post.body}</p>
	<form method="post" action="<c:url value="/${post.slug}/newComment"/>">
		<p>E-mail: <input type="email" name="email"/></p>
		<textarea name="comment"></textarea>
		<p><input type="submit" value="Add comment"/></p>
	</form>
	<c:forEach items="${post.comments}" var="comment">
		<h3><c:out value="${comment.email}"/> (${comment.postDate})</h3>
		<p><c:out value="${comment.body}"/></p>
	</c:forEach>
</body>
</html>
