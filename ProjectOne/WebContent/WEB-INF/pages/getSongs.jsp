<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello world
<%
out.println(request.getParameter("songs"));
%>
<audio src='/ProjectOne/res/songs/<%=request.getParameter("songs")%>.mp3' autoplay="autoplay" controls="controls" ></audio>
</body>
</html>