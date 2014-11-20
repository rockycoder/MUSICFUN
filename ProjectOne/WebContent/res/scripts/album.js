

function clickedAlbumSong(id)
{
	
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
    
    var url = "play?sid="+escape(id);
    
    request.open("GET", url, true);
    
    request.onreadystatechange = playSongAlbum;
    
    request.send(null);
}

function playSongAlbum() 
{
	

	
    if (request.readyState == 4) {
        if (request.status == 200) {
        	
            player = document.getElementById("player_div");
            player.innerHTML=request.responseText;
            
           
            
        }
    }
    
   
}

