<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="insert_album" method="post" action="inserted_album">

			<table>
				<tr>
					<td colspan="2"><form:errors path="*" cssStyle="color : red;" />
					</td>
				</tr>
				<tr>
					<td><form:label path="albumName">Album Name</form:label></td>
					<td><form:input path="albumName" /></td>
				</tr>
				<tr>
					<td><form:label path="imagePath">Image Path</form:label>
					</td>
					<td><form:input path="imagePath" />
					</td>
				</tr>
				<tr>
					<td><form:label path="language">Language</form:label>
					</td>
					<td><form:input path="language" /></td>
				</tr>
				<tr>
					<td><form:label path="releaseDate">Release Date(yyyy-mm-dd)</form:label></td>
					<td><form:input path="releaseDate" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add Album Details" />
					</td>
				</tr>
			</table>
		</form:form>
</body>
</html>