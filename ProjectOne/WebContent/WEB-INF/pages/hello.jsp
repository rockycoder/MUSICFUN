<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>Rob's Rock 'n' Roll Memorabilia</title>
  <link rel="stylesheet" href="/ProjectOne/res/css/default.css" />
  <script src="/ProjectOne/res/scripts/hm.js" type="text/javascript"></script>
</head>

<body>
  <div id="wrapper">
    <img src="/res/images/bgDetailPane.png" alt="Rob's Rock 'n' Roll Memorabilia" 
         width="394" height="91" id="logotypeLeft" />
    <img src="/ProjectOne/WebContent/WEB-INF/pages/bgDetailPane.png" alt="Rob's Rock 'n' Roll Memorabilia" 
         width="415" height="92" id="logotypeRight" />
	
    <div id="introPane">
      <p>Are you looking for the perfect gift for the rock fan in your life? 
         Maybe you want a guitar with some history behind it, or a conversation 
         piece for your next big shindig. Look no further! Here you'll find all 
         sorts of great memorabilia from the golden age of rock and roll.</p>
      <p><strong>Click on an image to the left for more details.</strong></p>
    </div>

    <div id="thumbnailPane">
      <!-- <img src="/ProjectOne/WebContent/WEB-INF/pages/bgDetailPane.png" width="301" height="105" alt="guitar" 
           title="itemGuitar" id="itemGuitar" />
      <img src="/WEB-INF/pages/images/itemShades.jpg" alt="sunglasses" width="301" height="88" 
           title="itemShades" id="itemShades" />
      <img src="/WEB-INF/pages/images/itemCowbell.jpg" alt="cowbell" width="301" height="126" 
           title="itemCowbell" id="itemCowbell" />
      <img src="/WEB-INF/pages/images/itemHat.jpg" alt="hat" width="300" height="152" 
           title="itemHat" id="itemHat" /> -->
           
      <img src="<%=request.getContextPath()%>/res/images/bgDetailPane.png" width="301" height="105" alt="guitar" 
           title="itemGuitar" id="itemGuitar" />
    </div>

    <div id="detailsPane">
      <img src="/WEB-INF/pages/images/blank-detail.jpg" width="346" height="153" id="itemDetail" />
      <div id="description"></div>
    </div>
  </div>
</body>
</html>
