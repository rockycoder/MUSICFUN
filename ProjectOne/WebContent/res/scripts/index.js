/*window.onload = initPage;

function initPage() {
  
}
*/

var sid;

function clickedLabel(id)
{
	getSrc(id);
	sid=id;
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



function getSrc(id) {
	
    request = createRequest();
    if (request == null) {
        alert("Unable to create request");
        return;
    }
    
    var url = "play?sid="+escape(id);
    
    request.open("GET", url, true);
    
    request.onreadystatechange = playSong;
    
    request.send(null);
}

function playSong() {
	

	
    if (request.readyState == 4) {
        if (request.status == 200) {
            player = document.getElementById("player_div");
            player.innerHTML=request.responseText;
            
            window.navigator="#player_div";
            getCurrentSong(sid);
        }
    }
    
   
}
	 

function getCurrentSong(id)
{

	 request = createRequest();
	    if (request == null) {
	        alert("Unable to create request");
	        return;
	    }
	    
	    var url = "currPlaying?sid="+escape(id);
	    
	    request.open("GET", url, true);
	    
	    request.onreadystatechange = getSong;
	    
	    request.send(null);
	
}


function getSong()
{
	
	if (request.readyState == 4) {
        if (request.status == 200) {
        
            current = document.getElementById("currentSongDetails");
           
            current.innerHTML=request.responseText;
            window.navigator="#currentSongDetails";
        }
    }
}

/*==================english-Hindi ============================================*/


var albumid;
function onEnglish()
{
	AlbumList("English");
	
}

function onHindi()
{
	AlbumList("Hindi");
}
function FlashEnglish(id) {
	
    request = createRequest();
    if (request == null) {
        alert("Unable to create request");
        return;
    }
    
    var url = "album_english?sid="+escape(id);
    
    request.open("GET", url, true);
    
    request.onreadystatechange = getFlashEnglish;
    
    request.send(null);
}

function getFlashEnglish() {
	

    if (request.readyState == 4) {
        if (request.status == 200) {
            player = document.getElementById("templatemo_middle");
            player.innerHTML=request.responseText;
            window.navigator="#currentSongDetails";
            albumid="English";
            
            /*FlashEnglish(albumid);*/
            
        }
    }
    
   
}

function AlbumList(id)
{
	createAlbumList(id);
}


function createAlbumList(id)
{

	 request = createRequest();
	    if (request == null) {
	        alert("Unable to create request");
	        return;
	    }
	    
	    var url = "allAlbums?lang="+escape(id);
	    
	    request.open("GET", url, true);
	    
	    request.onreadystatechange = getAlbums;
	    
	    request.send(null);
	
}


function getAlbums()
{
	
	if (request.readyState == 4) {
        if (request.status == 200) {
        
            current = document.getElementById("currentSongDetails");
           
            current.innerHTML=request.responseText;
            window.navigator="#currentSongDetails";
        }
    }
}

/*==================english page ============================================*/



/*===========================album click===================================*/
function albumClick(id)
{
	
	createAlbumMost(id);
}

function createAlbumMost(id)
{

	 request = createRequest();
	    if (request == null) {
	        alert("Unable to create request");
	        return;
	    }
	    
	    var url = "yourAlbum?aid="+escape(id);
	    
	    request.open("GET", url, true);
	    
	    request.onreadystatechange = getAlbumMost;
	    
	    request.send(null);
	
}


function getAlbumMost()
{
	
	if (request.readyState == 4) {
        if (request.status == 200) {
        
            current = document.getElementById("currentSongDetails");
           
            current.innerHTML=request.responseText;
            window.navigator="#currentSongDetails";
        }
    }
}
/*===========================searching ===================================*/


function onSearchClick()
{
	
	searchText=document.getElementById("search").value;
	
	
	if(searchText!="Search Song" &&  searchText!=null && searchText.length!=0 &&  searchText!=" ")
		{
		
		sendText(searchText);
		
		}
	
	
}



function sendText(id)
{
	
	
	 request = createRequest();
	    if (request == null) {
	        alert("Unable to create request");
	        return;
	    }
	    
	    var url = "search?sText="+escape(id);
	    
	    request.open("GET", url, true);
	    
	    request.onreadystatechange = getSearchedResult;
	    
	    request.send(null);
	
	
}

function getSearchedResult()
{
	
	if (request.readyState == 4) {
        if (request.status == 200) {
        
            current = document.getElementById("currentSongDetails");
           
            current.innerHTML=request.responseText;
            
        }
    }
}


