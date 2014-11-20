<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html><!--  PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Project X</title>
<meta name="keywords"
	content="violet, web theme, free templates, website templates, CSS, HTML" />
<meta name="description"
	content="Violet Theme is a free CSS template provided by templatemo.com" />
<link href="/ProjectOne/res/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="/ProjectOne/res/css/front.css" media="screen, projection" rel="stylesheet" type="text/css">

<script type="text/javascript" src="/ProjectOne/res/scripts/swfobject.js"></script>
<script src="/ProjectOne/res/scripts/jquery.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/jquerys.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/userHome.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/userAlbum.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/playlistSong.js" type="text/javascript"></script>
<script type="text/javascript">
        $(document).ready(function() {

            $(".signin").click(function(e) {
                e.preventDefault();
                $("fieldset#signin_menu").toggle();
                $(".signin").toggleClass("menu-open");
            });

            $("fieldset#signin_menu").mouseup(function() {
                return false
            });
            $(document).mouseup(function(e) {
                if($(e.target).parent("a.signin").length==0) {
                    $(".signin").removeClass("menu-open");
                    $("fieldset#signin_menu").hide();
                }
            });            

        });
</script>


<!-- <script type="text/javascript">
function clear_field() {
	document.getElementById("search").value = "";
}
/* function field() {
	document.getElementById("search").value = "Search Song"; */

</script> -->
<script type="text/javascript">
        $(document).ready(function() {

            $(".register").click(function(e) {
                e.preventDefault();
                $("fieldset#register_menu").toggle();
                $(".register").toggleClass("menu-open");
            });

            $("fieldset#register_menu").mouseup(function() {
                return false
            });
            $(document).mouseup(function(e) {
                if($(e.target).parent("a.register").length==0) {
                    $(".register").removeClass("menu-open");
                    $("fieldset#register_menu").hide();
                }
            });            

        });
</script>
<script src="/ProjectOne/res/scripts/jquery.tipsy.js" type="text/javascript"></script>
<script type='text/javascript'>
    $(function() {
	  $('#forgot_username_link').tipsy({gravity: 'w'});   
    });
</script>

  

<script type="text/javascript">
			var flashvars = {};
			flashvars.xml_file = "/ProjectOne/res/images/slider/photo_list.xml";
			var params = {};
			params.wmode = "transparent";
			var attributes = {};
			attributes.id = "slider";
			swfobject.embedSWF("/ProjectOne/res/flash_slider.swf", "flash_grid_slider", "900", "425", "9.0.0", false, flashvars, params, attributes);
</script>

<script type="text/javascript">
function clear_field()
{
document.getElementById("search").value="" ;
}
function field()
{
document.getElementById("search").value="Search" ;
}

</script>
        
<link rel="stylesheet" type="text/css" href="/ProjectOne/res/css/ddsmoothmenu.css" />

<script type="text/javascript" src="/ProjectOne/res/scripts//jquery.min.js"></script>
<script type="text/javascript" src="/ProjectOne/res/scripts//ddsmoothmenu.js">


</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>
<script type="text/javascript">
     var contextPath = "<%=request.getContextPath()%>";
</script>
</head>
<body id="home">
<c:if test="${user==null}">
<jsp:forward page="toIndex"></jsp:forward>
</c:if>

<div id="templatemo_outer_wrapper">
    <div id="templatemo_wrapper">
    
        <div id="templatemo_header">
        <div id="site_title"><h1></h1></div>
           
            <div id="templatemo_menu" class="ddsmoothmenu">
                <ul>
                    <li><a href="#" class="selected"><span></span>Home</a></li>
                    <li><a href="#" class="selected"><span></span>Albums</a>
                        <ul>
                           <li><a href="#"  onclick="onEnglish();">English</a></li>
								<li><a href="#"  onclick="onHindi();">Hindi</a></li>
                        </ul>
                    </li>
                   
                                   
                   <input type="text" id="search" onFocus="clear_field();"
							height="15px"
							style="resize: none; margin-bottom: 30px; top: 10px;"
							value="Search Song" />
						<img src="/ProjectOne/res/images/search.png" width="20px"
							height="16px"  onclick="onSearchClick();"/>
                </ul>
             </div>
             <span id="listenerName" style="float:right; margin-right:-450px; text-align:center">${user.name}</span>
             <span id="listenerId" style="float:right; margin-right:-450px; text-align:center" hidden="true" title="${user.listenerId}"></span>
             <span style="float:right; margin-right:-540px; text-align:center"> <a href="user/logout">Logout</a><!-- <input type="button" id="logout" value="Log Out" /> --></span>
             
             	
                
              <br style="clear: left" />
            
            <div class="cleaner"></div>
        </div> <!-- end of templatemo header -->
        
        <div id="templatemo_middle" style="padding-right:-50px">
          <div id="mid_slider" style="padding-right:-50px">
                <div id="flash_grid_slider" style=" border-width:1px ; border:#000000">
                    <a href="#" target="_blank">
                        Flash XML Grid Slider
                    </a>
                    <br /><br />
                    <a href="http://www.adobe.com/go/getflashplayer">
                        <img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" />
                    </a>
                </div>
            </div>
            <div class="cleaner"></div>
        </div> <!-- end of middle -->
        
        <div id="templatemo_main">
        <div class="col_w901">
        
             <div class="col_w540 float_l" style=" border: groove 1px #FF6600; border-radius:5px; padding:4px;width:475px;">
                
                    <h2 style="font-variant:small-caps;font-family:Georgia, 'Times New Roman', Times, serif; color:#FFFFFF">BEAT BOX</h2>
                   
                       <div id="home_songs" >
                       
                      <img src="/ProjectOne/res/images/page1-img1.jpg" alt="Image 01"
								class="image_wrapper image_fl" />
                       <h3 class="latestsongs">NOW PLAYING</h3>
                       </div>
                    <div class="topsingers"></div>
                    <cite></cite>
                
                </div> 
  
                <div class="col_w320 float_r" style=" border: groove 1px #FF6600; border-radius:5px; padding:4px">
                
                     <h2 style="font-variant:small-caps;font-family:Georgia, 'Times New Roman', Times, serif; color:#FFFFFF">RECOMMENDED SONGS</h2>
                    <p>&nbsp;</p>
                    <div class="recommended_songs">
                   
                    <jsp:include page="user/recSong1" />
                    </div>
                    <cite></cite>
                
                </div>  
                <div class="cleaner"></div>   
          </div>
            
            <div class="cleaner"></div>
        
        
   
             <div class="col_w901">
        
              <div class="col_w540 float_l" style=" border: groove 1px #FF6600; border-radius:5px; padding:4px">
                
                    <h2 style="font-variant:small-caps;font-family:Georgia, 'Times New Roman', Times, serif; color:#FFFFFF">YOUR PLAYLIST</h2>
                   
                    <div class="topsingers" id="user_playlist"> <p>&nbsp;</p>
                    <jsp:include page="user/playlist" /></div>
                    <cite></cite>
                
                </div>  
                
    
                
               <div class="col_w320 float_r" style=" border: groove 1px #FF6600; border-radius:5px; padding:4px ; width:400px">
                
                    <h2 class="col_w903" style="font-variant:small-caps;font-family:Georgia, 'Times New Roman', Times, serif; color:#FFFFFF">MOST VIEWED SONGS</h2>
                    <jsp:include page="user/nowPlaying" />                
                    
                    <p>&nbsp;</p>
                    <!-- <div class="topsingers"></div> -->
                    <cite></cite>
                
                </div>  
               
          </div>
          </div>
          	<div class="latestalbums" style="margin-top:430px;boder-top:groove thick #FFF">
					LATEST ALBUMS
					<div>
						<br />
						<marquee onmouseover="this.stop();" onmouseout="this.start();"
							behavior="alternate" >
							<jsp:include page="latestAlbums" />
						</marquee>
					</div>
					<div class="cleaner"></div>
				</div>
        </div> <!-- end of main -->
  
    </div> <!-- wrapper -->
    <footer style="color: #000">
			<br /> <br />
			<div class="con_tit_01"></div>

			<div id="templatemo_footer_wrapper">

				<div id="templatemo_footer">
					<div id="player_div">
						
					</div>
					<br /> <br /> Copyright © 2013 MUSIC.COM| <a href="#"
						target="_parent">Contact Us</a>
					<div id="rawat" style="white-space: pre">
						<a href="#" target="_parent"></a>
					</div>
				</div>
			</div>
		</footer>
   
</div>
</div>

</body>
</html>