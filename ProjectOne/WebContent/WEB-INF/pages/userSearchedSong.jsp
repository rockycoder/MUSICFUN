<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="s" items="${sList}">
	<label class="topsongclass" id="${s.songId}"
		style="color: fuchsia; font-size: 20px; font-family: Georgia, 'Times New Roman', Times, serif; padding: 5px;"
		onclick="clickedLabel(${s.songId});">${s.songName}</label>
		<label><img src="/ProjectOne/res/images/addd.png" title="Add to Songs" alt="add"  height="15" width="15" onclick="addPlaylist(${s.songId});"/></label><br />
	<br />

</c:forEach>



