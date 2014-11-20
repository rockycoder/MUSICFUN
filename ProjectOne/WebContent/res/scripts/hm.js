window.onload = initPage;

function initPage() {
  // find the thumbnails on the page
  thumbs = document.getElementById("song").getElementsByTagName("label");

  // set the handler for each image
  for (var i = 0; i < thumbs.length; i++) {
    lbl = thumbs[i];
    
    // create the onclick function
    lbl.onclick = function() {
      // find the image name
    	
      getDetails(this.id);
    }
  }
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

function getDetails(itemName) {
	  request = createRequest();
	  
	  if (request == null) {
	    alert("Unable to create request");
	    return;
	  }
	  
	  var url= "getSongs?songs="+escape(itemName);
	  request.open("GET", url, true);
	  request.onreadystatechange = displayDetails;
	  request.send(null);
	}


function displayDetails() {
	  if (request.readyState == 4) {
	    if (request.status == 200) {
	    	alert("hello");
	      detailDiv = document.getElementById("content");
	      detailDiv.innerHTML = request.responseText;
	    }
	  }
	}
