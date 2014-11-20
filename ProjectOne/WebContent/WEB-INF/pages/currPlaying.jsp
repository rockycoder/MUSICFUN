<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<STYLE type="text/css">
.abcde img {
	width: 10px;
	height: 10px;
}

#transform {
	width: 10px;
	height: 10px;
	-webkit-transform-style: preserve-3d;
	-webkit-transition: all 1.0s linear;
}

#transform:hover {
	-webkit-transform: rotateZ(15deg);
	-webkit-box-shadow: -5px 5px 5px #fff;
	-webkit-animation-iteration-count: infinite;
}
</STYLE>


<!-- <h1 style="float:left;font-family:Georgia, 'Times New Roman', Times, serif;font-size:25px;color:white">BEAT BOX</h1>
 -->
<img src="/ProjectOne/res/images/beatbox.png" alt="Image 01"
	style="width: 200px; height: 80px" />
<div>
	<div id="transform" class="abcde">
		<img src="${album.imagePath}" alt="Image 01"
			style="height: 200px; width: 200px; float: left; margin: 3px 20px 0 0; display: inline-block; border: 1px solid #000; padding: 4px; background: #383838; margin-bottom: 5px;"
			onclick="albumClick(${album.albumId});" />
	</div>

	<h3 class="latestsongs" class="col_w580 float_r">NOW PLAYING</h3>
	<div id="home_songs" style="padding-top: 30px; padding-left: 5px;">

		<label
			style="color: red; font-size: 20px; font-family: 'Palatino Linotype', 'Book Antiqua', Palatino, serif">Currently
			Playing:-</label> <label
			style="color: white; font-size: 18px; font-family: Georgia, 'Times New Roman', Times, serif">${song.songName}</label><br />
		<br /> <label
			style="color: red; font-family: 'Palatino Linotype', 'Book Antiqua', Palatino, serif; font-size: 20px;">Album
			Name:-</label> <label
			style="color: white; font-family: Georgia, 'Times New Roman', Times, serif; font-size: 18px;">${album.albumName}</label><br />
		<br /> <label
			style="color: red; font-family: 'Palatino Linotype', 'Book Antiqua', Palatino, serif; font-size: 20px;">Release
			Date:-</label> <label
			style="color: white; font-family: Georgia, 'Times New Roman', Times, serif; font-size: 18px;">${album.releaseDate}</label><br />
		<br />

	</div>
</div>


<%-- <c:forEach var="s" items="${song.artists}"> 
${s.artistName} &nbsp;&nbsp;
</c:forEach>--%>

<%-- <c:forEach var="item" items="${album.songs}">
<label id="${item.songId}" onclick="currPlay_Click("${item.songId}")>
${item.songName}&nbsp;&nbsp;&nbsp;&nbsp;${item.durationSecongs}
</label>
 </c:forEach>--%>

















