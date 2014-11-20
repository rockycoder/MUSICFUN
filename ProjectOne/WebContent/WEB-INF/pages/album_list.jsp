<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Project X</title>
<meta name="keywords"
	content="violet, web theme, free templates, website templates, CSS, HTML" />
<meta name="description"
	content="Violet Theme is a free CSS template provided by templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/swfobject.js"></script>

<script type="text/javascript">
	function clear_field() {
		document.getElementById("search").value = "";
	}
	function field() {
		document.getElementById("search").value = "Search";
	}
</script>
<script type="text/javascript">
	var flashvars = {};
	flashvars.xml_file = "photo_list.xml";
	var params = {};
	params.wmode = "transparent";
	var attributes = {};
	attributes.id = "slider";
	swfobject.embedSWF("flash_slider.swf", "flash_grid_slider", "900", "425",
			"9.0.0", false, flashvars, params, attributes);
</script>

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">
	/***********************************************
	 * Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	 * This notice MUST stay intact for legal use
	 * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	 ***********************************************/
</script>
<script type="text/javascript">
	
</script>

<script type="text/javascript">
	ddsmoothmenu.init({
		mainmenuid : "templatemo_menu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})
</script>

</head>
<body id="home">

	<div id="templatemo_outer_wrapper">
		<div id="templatemo_wrapper">

			<div id="templatemo_header">
				<div id="site_title">
					<h1></h1>
				</div>
				<div id="templatemo_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="index.html" class="selected"><span></span>Home</a></li>
						<li><a href="about.html" class="selected"><span></span>Albums</a>
							<ul>
								<li><a href="submenupage.html">English</a></li>
								<li><a href="submenupage.html">Hindi</a></li>
							</ul></li>

						<li><a href="blog.html" class="selected"><span></span>Login</a></li>
						<li><a href="blog.html" class="selected"><span></span>Register</a></li>
						&nbsp;&nbsp;

						<input type="text" id="search" onFocus="clear_field();"
							height="22px" onblur="field();" style="resize: none"
							value="Search"></input>
						<img src="images/search.png" width="20px" height="22px" />

					</ul>
					<br style="clear: left" />
				</div>
				<!-- end of templatemo_menu -->

				<div class="cleaner"></div>
			</div>
			<!-- end of templatemo header -->

			<div id="templatemo_middle" style="padding-right: -50px">
				<div id="mid_slider" style="padding-right: -50px">
					<div id="flash_grid_slider"
						style="border-width: 1px; border: #000000">
						<a href="#" target="_blank"> Flash XML Grid Slider </a> <br />
						<br /> <a href="http://www.adobe.com/go/getflashplayer"> <img
							src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif"
							alt="Get Adobe Flash player" />
						</a>
					</div>
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- end of middle -->

			<div id="templatemo_main">

				<div class="col_w901">
					<div class="col_w580 float_l">
						<h3 class="latestsongs">ALBUM SONGS</h3>
						<img src="images/page1-img1.jpg" alt="Image 01"
							class="image_wrapper image_fl" />
						
					</div>
					<div class="col_w280 float_r">


						<p>&nbsp;</p>
						<br /> <br /> <br /> <br /> <br /> <br />


					</div>
					<div class="cleaner"></div>
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- end of main -->

		</div>
		<!-- wrapper -->
	</div>


</body>
</html>