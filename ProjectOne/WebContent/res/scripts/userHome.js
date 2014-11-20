var sid;
var lid;
function clickedLabel(id) {
	lid = document.getElementById("listenerId").title;

	getSrc(id, lid);
	sid = id;

}

function createRequest() {
	try {
		request = new XMLHttpRequest();
	} catch (tryMS) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (otherMS) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = null;
			}
		}
	}
	return request;
}

function getSrc(id, lid) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/play?sid=" + escape(id) + "&lid=" + escape(lid);

	request.open("GET", url, true);

	request.onreadystatechange = playSong;

	request.send(null);
}

function playSong() {

	if (request.readyState == 4) {
		if (request.status == 200) {
			player = document.getElementById("player_div");
			player.innerHTML = request.responseText;

			getCurrentSong(sid);
		}
	}

}

function getCurrentSong(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/currPlaying?sid=" + escape(id);

	request.open("GET", url, true);

	request.onreadystatechange = getSong;

	request.send(null);

}

function getSong() {

	if (request.readyState == 4) {
		if (request.status == 200) {

			current = document.getElementById("home_songs");

			current.innerHTML = request.responseText;
			RecommendedSongs();

		}
	}
}

function RecommendedSongs() {

	createRecommendedSongs();
}

function createRecommendedSongs() {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/recSong?lid=" + escape(lid);

	request.open("GET", url, true);

	request.onreadystatechange = getRecommendedSongs;

	request.send(null);

}

function getRecommendedSongs() {

	if (request.readyState == 4) {
		if (request.status == 200) {

			current = document.getElementById("recommended_songs");

			current.innerHTML = request.responseText;
			RecommendedSongs();

		}
	}
}

/* ==================english-Hindi ============================================ */

var albumid;
function onEnglish() {
	AlbumList("English");

}

function onHindi() {
	AlbumList("Hindi");
}
function FlashEnglish(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/album_english?sid=" + escape(id);

	request.open("GET", url, true);

	request.onreadystatechange = getFlashEnglish;

	request.send(null);
}

function getFlashEnglish() {

	if (request.readyState == 4) {
		if (request.status == 200) {
			player = document.getElementById("templatemo_middle");
			player.innerHTML = request.responseText;

			albumid = "English";
			/* FlashEnglish(albumid); */

		}
	}

}

function AlbumList(id) {
	lid = document.getElementById("listenerId").title;
	createAlbumList(id);
}

function createAlbumList(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/allAlbums?lang=" + escape(id);

	request.open("GET", url, true);

	request.onreadystatechange = getAlbums;

	request.send(null);

}

function getAlbums() {

	if (request.readyState == 4) {
		if (request.status == 200) {

			current = document.getElementById("home_songs");

			current.innerHTML = request.responseText;

		}
	}
}

/* ===========================album click=================================== */

/* ===========================user playlist=================================== */

function addPlaylist(id) {
	lid = document.getElementById("listenerId").title;
	/* createPlaylistArray(); */
	createPlaylist(id);
}

function createPlaylist(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/addSong?sid=" + escape(id) + "&lid=" + escape(lid);

	request.open("GET", url, true);

	request.onreadystatechange = getCreatedPlaylist;

	request.send(null);

}

function getCreatedPlaylist() {

	if (request.readyState == 4) {
		if (request.status == 200) {

			current = document.getElementById("user_playlist");

			current.innerHTML = request.responseText;

		}
	}
}

function removeFromPalylist(id) {
	lid = document.getElementById("listenerId").title;
	/* createPlaylistArray(); */
	createRemovePlaylist(id);
}

function createRemovePlaylist(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/removeSong?sid=" + escape(id) + "&lid=" + escape(lid);

	request.open("GET", url, true);

	request.onreadystatechange = getRemovedPlaylist;

	request.send(null);

}

function getRemovedPlaylist() {

	if (request.readyState == 4) {
		if (request.status == 200) {

			current = document.getElementById("user_playlist");

			current.innerHTML = request.responseText;

		}
	}
}

/* user album handling............................................ */
function albumClick(id) {
	lid = document.getElementById("listenerId").title;
	createAlbumMost(id);

}

function createAlbumMost(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/yourAlbum?aid=" + escape(id);

	request.open("GET", url, true);

	request.onreadystatechange = getAlbumMost;

	request.send(null);

}

function getAlbumMost() {

	if (request.readyState == 4) {
		if (request.status == 200) {

			current = document.getElementById("home_songs");

			current.innerHTML = request.responseText;

		}
	}
}

function clickedAlbumSong(id) {
	lid = document.getElementById("listenerId").title;
	getAlbumSrc(id);

}

function createRequest() {
	try {
		request = new XMLHttpRequest();
	} catch (tryMS) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (otherMS) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = null;
			}
		}
	}
	return request;
}

function getAlbumSrc(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/play?sid=" + escape(id) + "&lid=" + escape(lid);

	request.open("GET", url, true);

	request.onreadystatechange = playSongAlbum;

	request.send(null);
}

function playSongAlbum() {

	if (request.readyState == 4) {
		if (request.status == 200) {

			player = document.getElementById("player_div");
			player.innerHTML = request.responseText;

		}
	}

}

/*
 * ===============playlist
 * playing===================================================
 */
var labels;
var playlistSongId;
var j = 0;
function createPlaylistArray() {

	labels = document.getElementById("user_playlist").getElementsByTagName(
			"label");
	songs = document.getElementById("for_playlist").getElementsByTagName(
			"label");
	song_id = songs[0].id;

	for ( var i = 0; i < labels.length; i++) {
		if (labels[i].id == song_id) {

			j = i + 1;
			break;
		}

	}
}

function nextSongFromPlaylist() {

	createPlaylistArray();
	nextSongId = labels[j].id;

	createPlaylistSong(nextSongId);

}

function createPlaylistSong(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}
	playlistSongId=id;
	var url = "user/playPlaylist?sid=" + escape(id);

	request.open("GET", url, true);

	request.onreadystatechange = playPlaylistSong;

	request.send(null);
	
}

function playPlaylistSong() {

	if (request.readyState == 4) {
		if (request.status == 200) {
			player = document.getElementById("player_div");
			player.innerHTML = request.responseText;
			getCurrentSong(playlistSongId);

		}
	}

}

/* ==============searching in user home ==================================== */

function onSearchClick() {

	searchText = document.getElementById("search").value;

	if (searchText != "Search Song" && searchText != null
			&& searchText.length != 0 && searchText != " ") {

		sendText(searchText);

	}

}

function sendText(id) {

	request = createRequest();
	if (request == null) {
		alert("Unable to create request");
		return;
	}

	var url = "user/search?sText=" + escape(id);

	request.open("GET", url, true);

	request.onreadystatechange = getSearchedResult;

	request.send(null);

}

function getSearchedResult() {

	if (request.readyState == 4) {
		if (request.status == 200) {

			current = document.getElementById("home_songs");

			current.innerHTML = request.responseText;
			

		}
	}
}
