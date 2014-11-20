<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    		<STYLE type="text/css">
			@-webkit-keyframes resize {
				0% {
					height:20px;
					width:20px;
					opacity:0.7;
				}
				50% {
					height:25px;
					width:25px;
					opacity:0.4;
				}
			}
	
			#heart:hover {
				-webkit-animation-name: resize;
				-webkit-animation-duration: 1s;
				-webkit-animation-iteration-count: 2;
				-webkit-animation-direction: alternate;
				-webkit-animation-timing-function: cubic-bezier(0,0.5,0,0);
			}

		

			.bcd img{
				height:20px;
				width:20px;
				opacity:1;
			}

		</STYLE>
    
    
    
<div style="font-family:Georgia, 'Times New Roman', Times, serif;font-size: 20px; color:#ae6b1b;">
<ol>
<c:forEach var="s" items="${sList}">
<li>
<label class="topsongclass" id="${s.songId}" onclick="clickedLabel(${s.songId});">${s.songName}</label>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="/ProjectOne/res/images/Heart.jpg" title="Hits: ${s.hitCount}" id="heart" class="bcd" style="width:20px;height:20px"/>
<br /><br />
</c:forEach>
</ol>
</div>
 