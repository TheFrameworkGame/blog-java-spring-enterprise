<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<form:form commandName="post" name="post" action="update" method="POST">
		<p>
			Title:
			<form:errors path="title" cssClass="error" />
			<form:input path="title" size="80" />
		</p>
		<p>
			Slug:
			<form:errors path="slug" cssClass="error" />
			<form:input path="slug" size="80" />
		</p>
		<p>
			Tease:
			<form:errors path="tease" cssClass="error" />
			<form:textarea path="tease" />
		</p>
		<p>
			Body:
			<form:errors path="body" cssClass="error" />
			<form:textarea path="body" />
		</p>
		<p>
			Comments:
			<form:errors path="hasComments" cssClass="error" />
			<form:checkbox path="hasComments"/>
		</p>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>
