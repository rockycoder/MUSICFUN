<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="font-family:Georgia, 'Times New Roman', Times, serif;font-size: 20px; color:#ae6b1b;">
<ol>
<table>
<c:forEach var="s" items="${sList}">
<tr>
<td><li></td>
<td>
<label class="topsongclass" id="${s.songId}" onclick="clickedLabel(${s.songId});">${s.songName}</label>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td>
<label style="color:grey;font-size:14px">views:</label><label style="color:white">${s.hitCount}</label></li><br />
</td>
<td>
<img src="/ProjectOne/res/images/addd.png" title="Add to Songs" alt="add"  height="15" width="15" onclick="addPlaylist(${s.songId});"/>
</td>
</tr>
</c:forEach>
</table>
</ol>
</div>
 