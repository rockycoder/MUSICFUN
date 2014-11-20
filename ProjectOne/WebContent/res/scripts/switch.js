/*window.onload = initPage;

function initPage() {
    // find the thumbnails on the page
    lbl = document.getElementById("album");

 alert("inpage");

        // create the onclick function
        lbl.onclick= function () {
            alert("clicked")
            getSrc(this.id);
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

function getSrc(id) {
    request = createRequest();
    if (request == null) {
        alert("Unable to create request");
        return;
    }
    var url = "switch";
    request.open("GET", url, true);
    request.onreadystatechange = playSong;
    request.send(null);
}

function playSong() {
    if (request.readyState == 4) {
        if (request.status == 200) {
            player = document.getElementById("main");
            player.innerHTML = request.responseText;
        }
    }
}
*/