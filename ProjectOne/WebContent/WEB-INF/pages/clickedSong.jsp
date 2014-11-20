<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
<div id="for_playlist">
 <audio id="audio_player" src="${surl}" autoplay="autoplay" controls="controls" style="width: 1350px; height: 50px;" onended="nextSongFromPlaylist();"></audio>
 <label id="${id}">${sname}</label>
 </div>
</body>
</html>



