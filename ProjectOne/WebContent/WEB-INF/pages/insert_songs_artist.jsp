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

<form:form modelAttribute="insert_songs" method="post" action="inserted_songdetails">

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
					<td><form:label path="art.artistName">Artist Name</form:label></td>
					<td><form:input path="art.artistName" /></td>
				</tr>
				<tr>
					<td><form:label path="s.durationSeconds">Duration</form:label>
					</td>
					<td><form:input path="s.durationSeconds" />
					</td>
				</tr>
				<tr>
					<td><form:label path="s.songName">Song Name</form:label>
					</td>
					<td><form:input path="s.songName" /></td>
				</tr>
				<tr>
					<td><form:label path="s.genre">Genre</form:label></td>
					<td><form:input path="s.genre" /></td>
				</tr>
				<tr>
					<td><form:label path="s.fileLocation">file Location</form:label></td>
					<td><form:input path="s.fileLocation" /></td>
				</tr>
				<tr>
					<td><form:label path="s.hitCount">Hit Count</form:label></td>
					<td><form:input path="s.hitCount" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add Song Details" />
					</td>
				</tr>
			</table>
		</form:form>
</body>
</html>