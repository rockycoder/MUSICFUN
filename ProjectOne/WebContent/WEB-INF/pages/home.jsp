<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/ProjectOne/res/scripts/hm.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>

<center>
<div id="song">		
<h3>Songs List-Top Ten</h3>
<c:forEach var="p" items="${tensongs}">

<b> <label id="${p.songId}">${p.songName}</label></b>
<a href="getSongs" >kj</a>
</c:forEach>
<a href="nowPlaying">Display Song List</a>
</div>
</center>
<div id="content"></div>
	
<video src=""></video>
</body>
</html>