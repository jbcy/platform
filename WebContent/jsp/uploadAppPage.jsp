<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<title>Upload Your App</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./style/home.css">
<body class="w3-light-grey w3-content" style="max-width:1600px">
<!-- Sidebar/menu -->
<jsp:useBean id="user" type="model.User" scope="session"/>
<jsp:useBean id="peanut" type="model.Peanut" scope="session"/>
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container">
    <a href="#" onclick="w3_close()" class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey" title="close menu">
      <i class="fa fa-remove"></i>
    </a>
     <!-- <img src="/w3images/avatar_g2.jpg" style="width:45%;" class="w3-round"> --><br><br>
	<h4><b><jsp:getProperty name="user" property="name"/></b></h4>
   <h5>Points: <b><jsp:getProperty name="peanut" property="points"/></b></h5>
    
  </div>
  <div class="w3-bar-block">
    <a href="/JBCY/Profile" onclick="w3_close()" class="w3-bar-item w3-button w3-padding "><i class="fa fa-th-large fa-fw w3-margin-right"></i>Home</a> 
    <a href="/JBCY/Profile" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw w3-margin-right"></i>Memory</a> 
    <a href="jsp/uploadAppPage.jsp" class="w3-bar-item w3-button w3-padding w3-text-teal"><i class="fa fa-star fa-fw w3-margin-right"></i>Upload</a>
    <a href="/JBCY/logout" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope fa-fw w3-margin-right"></i>Logout</a>
  </div>
  
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">
<header id="home">
    <a href="#"><img src="/w3images/avatar_g2.jpg" style="width:65px;" class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
    <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
    <div class="w3-container">
	    <h6>${status}</h6>
	    <h1><b>Start to gain more points</b></h1>
	    
    </div>
  </header>
  
  <div class="w3-container w3-padding-large" style="margin-bottom:32px">
    <h3>App Detail</h3>
     <form class="w3-container" action="/JBCY/uploadApp" method="POST" enctype="multipart/form-data">
		
		<label>Name</label>
		<input class="w3-input" type="text" id="name" name="name">
		<label>Description</label>
		<input class="w3-input" type="text" id="description" name="description">
		<label>How many peanut points it will cost</label>
		<input class="w3-input" type="number" id="points" name="points">
		<label>Name of Your Database</label>
		<input class="w3-input" type="text" id="database" name="database">
		<label>Your .sql file</label>
		<input class="w3-input" type="file" id="sql" name="sql" size="60">
		<label>Your app's war</label>
		<input class="w3-input" type="file" id="app" name="app" size="60">
		<div class="w3-center w3-padding-16">
			<button class="w3-button w3-black w3-center" type="submit" name="btn" >Upload</button>
		</div>
	
	</form>
    
  </div>
  
  
  <div class="w3-black w3-center w3-padding-24 w3-display-bottommiddle">Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-opacity">team 13</a></div>

<!-- End page content -->
</div>

<script>
// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}
</script>

</body>
</html>
