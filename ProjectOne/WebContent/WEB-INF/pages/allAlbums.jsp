<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>


<!-- <h1 id="h1" style="color:white;font-family:Georgia, 'Times New Roman', Times, serif;font-size:25px">ALBUMS</h1>
 --><img src="/ProjectOne/res/images/albums.png" alt="Image 01"
 style="width:300px;height:120px"/>
<div ><!-- style="background: -webkit-gradient(radial,20% 2%,0,20% 20%,400,from(#333),to(black));height:auto; opacity:0.7"> -->
<table style="font-family:Georgia, 'Times New Roman', Times, serif;font-size:20px;color:#fff">
<tr style="font-family:'Comic Sans MS', cursive;color:teal;">
<th>Album Art</th>
<th>Album Name</th>
<th>Release date</th>
</tr>
<c:forEach var="s" items="${albumList}">
<tr >
<td ><img src="${s.imagePath}" style="width:120px;height:120px;margin:10px; border:groove brown 1px"  onclick="albumClick(${s.albumId})"/></td>
<td style="color:#00FF33"><ul><label id="${s.albumId}"  onclick="albumClick(${s.albumId})">${s.albumName}</label></ul></td>
<td style="text-align:right;">${s.releaseDate}</td>

</c:forEach>
</table>
</div>
</body>
</html>