<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Project X</title>
<meta name="keywords"
	content="violet, web theme, free templates, website templates, CSS, HTML" />
<meta name="description"
	content="Violet Theme is a free CSS template provided by templatemo.com" />
<link href="/ProjectOne/res/css/templatemo_style.css" rel="stylesheet"
	type="text/css" />
<link href="/ProjectOne/res/css/front.css" media="screen, projection"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="/ProjectOne/res/scripts/swfobject.js"></script>
<script src="/ProjectOne/res/scripts/jquery.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/jquerys.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/index.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/album.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/playlistSong.js" type="text/javascript"></script>

<script>

	function on_page_load() {

		alert(hllo);
		var logger = ${msg};
		if (logger != null) {
			error_menu();
		}

	}
	
	function error_menu() {

		$("fieldset#signin_menu").toggle();
		$(".signin").toggleClass("menu-open");

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$(".signin").click(function(e) {

			if ($(e.target).parent("a.forgot").length == 0) {
				$(".forgot").removeClass("menu-open");
				$("fieldset#forgot_menu").hide();
			}

			if ($(e.target).parent("a.register").length == 0) {
				$(".register").removeClass("menu-open");
				$("fieldset#register_menu").hide();
			}

			e.preventDefault();
			$("fieldset#signin_menu").toggle();
			$(".signin").toggleClass("menu-open");
		});

		$("fieldset#signin_menu").mouseup(function() {
			return false
		});
		$(document).mouseup(function(e) {
			if ($(e.target).parent("a.signin").length == 0) {
				$(".signin").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
			}
		});

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$(".register").click(function(e) {

			if ($(e.target).parent("a.signin").length == 0) {
				$(".signin").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
			}

			if ($(e.target).parent("a.forgot").length == 0) {
				$(".forgot").removeClass("menu-open");
				$("fieldset#forgot_menu").hide();
			}

			e.preventDefault();
			$("fieldset#register_menu").toggle();
			$(".register").toggleClass("menu-open");
		});

		$("fieldset#register_menu").mouseup(function() {
			return false
		});
		$(document).mouseup(function(e) {
			if ($(e.target).parent("a.register").length == 0) {
				$(".register").removeClass("menu-open");
				$("fieldset#register_menu").hide();
			}
		});

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$(".forgot").click(function(e) {

			if ($(e.target).parent("a.signin").length == 0) {
				$(".signin").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
			}

			e.preventDefault();
			$("fieldset#forgot_menu").toggle();
			$(".forgot").toggleClass("menu-open");

		});

		$("fieldset#forgot_menu").mouseup(function() {
			return false
		});
		$(document).mouseup(function(e) {
			if ($(e.target).parent("a.forgot").length == 0) {
				$(".forgot").removeClass("menu-open");
				$("fieldset#forgot_menu").hide();
			}
		});

	});
</script>

<script src="js/jquery.tipsy.js" type="text/javascript"></script>
<script type='text/javascript'>
	$(function() {
		$('#forgot_username_link').tipsy({
			gravity : 'w'
		});
	});
</script>



<script type="text/javascript">
	var flashvars = {};
	flashvars.xml_file = "/ProjectOne/res/images/slider/photo_list.xml";
	var params = {};
	params.wmode = "transparent";
	var attributes = {};
	attributes.id = "slider";
	swfobject.embedSWF("/ProjectOne/res/flash_slider.swf", "flash_grid_slider",
			"1000", "515", "9.0.0", false, flashvars, params, attributes);
</script>

<script type="text/javascript">
function clear_field() {
	document.getElementById("search").value = "";
}
/* function field() {
	document.getElementById("search").value = "Search Song"; */

</script>

<link rel="stylesheet" type="text/css"
	href="/ProjectOne/res/css/ddsmoothmenu.css" />

<script type="text/javascript"
	src="/ProjectOne/res/scripts/jquery.min.js"></script>
<script type="text/javascript"
	src="/ProjectOne/res/scripts/ddsmoothmenu.js">
	
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
<%-- <%
	System.out.println("in index");
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			Cookie coo = cookies[i];
			if (coo.getName().equals("name")) {
				System.out.println("in index");
				response.addCookie(coo);
				RequestDispatcher rd = request
						.getRequestDispatcher("/userHome");
				rd.forward(request, response);
			}
		}
	}
%> --%>
</head>
<body id="home" onload="on_page_load();">


	<div id="templatemo_outer_wrapper">
		<div id="templatemo_wrapper">

			<div id="templatemo_header">
				<div id="site_title">
					<h1 style="background:url('/ProjectOne/res/images/header_logo.png') no-repeat" id="heartinf" class="abcd"></h1>
				</div>

				<div id="templatemo_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="toIndex" class="selected"><span></span>Home</a></li>
						<li><a href="#" class="selected"><span></span>Albums</a>
							<ul>
								<li><a href="#" onclick="onEnglish();">English</a></li>
								<li><a href="#" onclick="onHindi();">Hindi</a></li>
							</ul></li>


						<input type="text" id="search" onFocus="clear_field();"
							height="15px" onblur="field();"
							style="resize: none; margin-bottom: 30px; top: 10px;"
							value="Search Song" />
						<img src="/ProjectOne/res/images/search.png" width="20px"
							height="16px"  onclick="onSearchClick();"/>
					</ul>
				</div>
				<span id="topnav" class="topnav"
					style="float: right; margin-right: -450px; text-align: center">
					<a href="login" class="signin"><span>&nbsp;&nbsp;&nbsp;Sign
							in</span></a>
				</span> <span id="topnav" class="topnav"
					style="float: right; margin-right: -540px; text-align: center">
					<a href="login" class="register"><span>&nbsp;&nbsp;&nbsp;Register</span></a>
				</span> <br style="clear: left" />

				<fieldset id="signin_menu">
					<form method="post" id="signin" action="user/login">
						<p>
							<label for="username">Username or email</label> <input
								id="username" name="username" value="" title="username"
								tabindex="4" type="text">
						</p>
						<p>
							<label for="password">Password</label> <input id="password"
								name="password" value="" title="password" tabindex="5"
								type="password">
						</p>
						<br>
						<label style="color: red">${msg}</label><br>
						<p class="remember">

							<input id="signin_submit" value="Sign in" tabindex="6"
								type="submit" onclick="checkRemember();"> <input
								id="remember" name="remember_me" value="1" tabindex="7"
								type="checkbox" /> <label for="remember">Remember me</label>
						</p>
						<span id="topnav" class="topnav"> <a href="login"
							class="forgot"><span>Forgot your password?</span></a>
						</span>

					</form>
				</fieldset>


				<fieldset id="register_menu">
					<form method="post" id="register" action="register">
						<p>
							<label for="username">Register</label> <label for="username">Username</label>
							<input id="username" name="username" value="" title="username"
								tabindex="4" type="text" /> <label for="email">Email</label> <input
								id="email" name="email" value="" title="email" tabindex="4"
								type="text" />
						</p>
						<p>
							<label for="password">Password</label> <input id="password"
								name="password" value="" title="password" tabindex="5"
								type="password" /> <label for="cpassword">Confirm
								Password</label> <input id="cpassword" name="cpassword" value=""
								title="cpassword" tabindex="5" type="password" />
						</p>
						<p class="remember">
							<input id="register_submit" value="Register" tabindex="6"
								type="submit" />
						</p>
					</form>
				</fieldset>
				
		

				<fieldset id="forgot_menu">
					<form method="post" id="forgot"
						action="user/forgotPassword">
						<label for="email">Email</label> <input id="email" name="email"
							value="" title="email" tabindex="4" type="text">
						<p class="remember">
							<input id="forgot_submit" value="Send Password to Email-Id"
								tabindex="6" type="submit">

						</p>
					</form>
				</fieldset>
				
				<div class="cleaner"></div>
				<span style="float:right;">
			<p style="color:red;font-family: fantasy;" align="right">
			<%if(request.getParameter("msg")!= null)
				out.print("***"+request.getParameter("msg"));
			if(request.getParameter("msg1")!= null)
				out.print("***"+request.getParameter("msg1"));
			if(request.getParameter("msg2")!= null)
				out.print("***"+request.getParameter("msg2"));
				%></p>
			</span>
			</div>
			<!-- end of templatemo header -->
			<div id="middle_div">
				<div id="templatemo_middle" style="padding-right: -50px">
					<div id="mid_slider" style="padding-right: -50px">
						<div id="flash_grid_slider"
							style="border-width: 1px; border: #000000">
							<a href="#" target="_blank"> Flash XML Grid Slider </a> <br /> <br />
							<a href="http://www.adobe.com/go/getflashplayer"> <img
								src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif"
								alt="Get Adobe Flash player" />
							</a>
						</div>
					</div>
					<div class="cleaner"></div>
				</div>
				<!-- end of middle -->

				<div id="templatemo_main">

					<div class="col_w900" id="albumsnext">
						<div class="col_w580 float_l" id="currentSongDetails"><!-- 
							<h1 style="font-family: Georgia, 'Times New Roman', Times, serif;color:white">MUSIC.COM</h1> -->
							<img src="/ProjectOne/res/images/cmusic.png" alt="Image 01"
							 style="width:400px;height:100px"/>
							<!-- <h3 style="font-family: Georgia, 'Times New Roman', Times, serif;color:white">Your Hotspot To Latest Music</h3>
							 --><br />
							 <br />
							<img src="/ProjectOne/res/images/equalizer.gif" alt="Image 01"
								class="image_wrapper image_fl" style="width:380px;height:200px"/>

							<img src="/ProjectOne/res/images/playit.png" alt="Image 01"
							 style="width:200px;height:50px"/>
							

						</div>

						<div class="col_w280 float_r">

							<!-- <h2
								style="font-size:25px;font-variant: small-caps; font-family: Georgia, 'Times New Roman', Times, serif; color: #FFFFFF">MOST
								VIEWED SONGS</h2> -->
								<img src="/ProjectOne/res/images/mostview.png" alt="Image 01"
							 style="width:350px;height:30px"/>
							<p>&nbsp;</p>
							<div class="topsingers">
								<jsp:include page="nowPlaying" />
							</div>
							<br /> <cite></cite>

						</div>
						<div class="cleaner"></div>
					</div>
					<div class="latestalbums">
						<img src="/ProjectOne/res/images/latestalbum.png" alt="Image 01"
							 style="width:300px;height:50px"/>
						<div>
							<br />
							<marquee onmouseover="this.stop();" onmouseout="this.start();"
								behavior="alternate">
								<jsp:include page="latestAlbums" />
							</marquee>
						</div>
						<div class="cleaner"></div>
					</div>
					<!-- end of main -->

				</div>
				<!-- wrapper -->
			</div>
		</div>
		<footer style="color: #000">
			<br /> <br />
			<div class="con_tit_01"></div>

			<div id="templatemo_footer_wrapper">

				<div id="templatemo_footer">
					<div id="player_div">
						<!-- <audio id="audio_player" src="" autoplay="autoplay"
						controls="controls" style="width: 1350px; height: 50px;"></audio> -->
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
</body>
</html>