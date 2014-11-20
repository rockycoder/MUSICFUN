<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="/ProjectOne/res/scripts/swfobject.js"></script>
<script src="/ProjectOne/res/scripts/jquery.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/jquerys.js" type="text/javascript"></script>
<script src="/ProjectOne/res/scripts/index.js" type="text/javascript"></script>
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
<script src="/ProjectOne/res/scripts/jquery.tipsy.js"
	type="text/javascript"></script>

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
			"900", "485", "9.0.0", false, flashvars, params, attributes);
</script>

<script type="text/javascript">
	function clear_field() {
		document.getElementById("search").value = "";
	}
	function field() {
		document.getElementById("search").value = "Search";
	}
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
	});
</script>

<script type="text/javascript">
	function clear_field() {
		document.getElementById("search").innerHTML = "";
	}
	function field() {
		document.getElementById("search").innerHTML = "Search";
	}
</script>

</head>
<body id="home">


	<!-- <div id="templatemo_outer_wrapper">
		<div id="templatemo_wrapper">

			<div id="templatemo_middle" style="padding-right: -50px"> -->
				<div id="mid_slider" style="padding-right: -50px">
					<div id="flash_grid_slider"
						style="border-width: 1px; border: #000000">
						<a href="#" target="_blank" on> Flash XML Grid Slider </a> <br /> <br />
						<a href="http://www.adobe.com/go/getflashplayer"> <img
							src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif"
							alt="Get Adobe Flash player" />
						</a>
					</div>
				</div>
				

</body>
</html>