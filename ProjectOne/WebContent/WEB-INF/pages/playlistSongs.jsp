<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
<c:forEach var="s" items="${slist}">
<tr>
<td>
<label class="topsongclass" id="${s.songId}"  style="color:fuchsia;font-size:20px;font-family:Georgia, 'Times New Roman', Times, serif;padding:5px;" onclick="clickedLabel(${s.songId});">${s.songName}</label>
</td>
<td>
<img src="/ProjectOne/res/images/remove.jpg" title="Remove from playlist" alt="remove"  height="15" width="15" onclick="removeFromPalylist(${s.songId});"/><br />
</td>
</tr>
</c:forEach>
</table>