<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="/ProjectOne/res/css/front.css" media="screen, projection" rel="stylesheet" type="text/css">

<img src="/ProjectOne/res/images/albumsongs.png" alt="Image 01"
 style="width:380px;height:100px"/>
<div class="col_w580 float_l">
	
	<img src="${pList.imagePath}" alt="Image 01"
		style="height: 200px; width: 200px; margin: 3px 30px 0 0; display: inline-block; border: 1px solid #000; padding: 4px; background: #383838; margin-bottom: 5px; margin-left:150px" />
</div>

<div class="col_w580 float_l" >
	<h2 style="color:white;font-family:Georgia, 'Times New Roman', Times, serif;font-size:25px">${pList.albumName}</h2>
	<table>
		<tr style="font-size:20px;font-family:'Comic Sans MS', cursive;margin:20px;color:teal;" >
			<th>Song Name</th>
			<th>Artists</th>
			<th>Genre</th>
			<th>Hits</th>
		</tr>
		<tr height="15px"></tr>
		<c:forEach var="s" items="${pList.songs}">
			<tr style="font-size:18px;color:#ae6b1b;font-family:Georgia, 'Times New Roman', Times, serif">
			
				<td style="width:200px;margin:10px"><label id="${s.songId}" title="${s.genre}"
					onclick="clickedAlbumSong(${s.songId});">${s.songName}</label></td>
				<td style="text-align:right;"><c:forEach var="k" items="${s.artists}">
${k.artistName} <br />




</c:forEach></td>
				<td style="text-align:right;">${s.genre}</td>
				<td style="text-align:right;">${s.hitCount}</td>
				<td><label><img src="/ProjectOne/res/images/addd.png" title="Add to Songs" alt="add"  height="15" width="15" onclick="addPlaylist(${s.songId});"/></label><br /></td>
				</tr>
				<tr height="10px"></tr>
		</c:forEach>
	</table>
</div>