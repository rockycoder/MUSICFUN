<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<STYLE type="text/css">
			
			.area {
				border-bottom: 6px solid #dbdfcd;
				height: 500px;
				position: relative;
			}

			.item {
				width: 240px;
				height:200px;
				opacity:0.9;
				border-radius:5px 5px 5px 5px;
			}

			.area .item {
				-webkit-transition: all 0.5s linear;
			}

			.item:hover,
			.item:focus {
				-webkit-border-radius:500px;

			}	
		</STYLE>



<c:forEach var="s" items="${aList}">
<span class="area">
<img  id="${s.albumId}" src="${s.imagePath}" height=160 width=140 onclick="albumClick(${s.albumId});" class='item' />
</span>
</c:forEach>