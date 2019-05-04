<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<title>Welcome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
</style>

<body class="w3-light-grey w3-content" style="max-width:1600px">
<!-- Sidebar/menu -->
<jsp:useBean id="user" type="model.User" scope="session"/>
<jsp:useBean id="peanut" type="model.Peanut" scope="session"/>
<jsp:useBean id="apps" class="model.AppType" scope="session"/>

<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container">
    <a href="#" onclick="w3_close()" class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey" title="close menu">
      <i class="fa fa-remove"></i>
    </a>
	<h4><b><jsp:getProperty name="user" property="name"/></b></h4>
   <h5>Points: <b><jsp:getProperty name="peanut" property="points"/></b></h5>
    
  </div>
  <div class="w3-bar-block">
    <a href="#home" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-text-teal"><i class="fa fa-home fa-fw w3-margin-right"></i>Home</a> 
    <a href="#memory" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw w3-margin-right"></i>Memory</a> 
    <a href="${pageContext.request.servletContext.contextPath}/logout" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope fa-fw w3-margin-right"></i>Log out</a>
  </div>
  
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

  <!-- Header -->
  <header id="home">
    <a href="#"><img src="/w3images/avatar_g2.jpg" style="width:65px;" class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
    <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
    <div class="w3-container">
    <%@ page import="model.App" %>
    <h1><b><jsp:getProperty name="apps" property="type"/> Apps</b></h1>
    <div class="w3-section w3-bottombar w3-padding-16">
    <form action="appType" method="GET">
      <span class="w3-margin-right">Filter:</span> 
      <button name="all" class="w3-button w3-white">ALL</button>
      <button name="newForMe" class="w3-button w3-white"><i class="fa fa-diamond w3-margin-right"></i>New for me</button>
      <button name="joined" class="w3-button w3-white w3-hide-small"><i class="fa fa-photo w3-margin-right"></i>Joined</button>
	</form>
    </div>
    </div>
  </header>
  
  <!-- First Photo Grid-->
  <div class="w3-row-padding">
  <%@ page import="java.util.List" %>
    <%@ page import="model.App" %>
    <% 
    	List<App> list = null;
    	if (apps.getType().equals("All")) {
    		list = apps.getAll();
    	} else if (apps.getType().equals("Joined")) {
    		list = apps.getJoined();
    	} else if (apps.getType().equals("NewForMe")) {
    		list = apps.getNewForMe();
    	}
    	for (App item : list) {
    %>
    	
    	<div class="w3-third w3-container w3-margin-bottom" id=<%= item.getId() %> onclick="app_select(<%= item.getId() %>)" >
		      
		      <div class="w3-container w3-white">
		        <p><b><%= item.getName() %></b></p>
		        <p><%= item.getDescription() %></p>
		      </div>
		    </div> 
		<% } %>
    
    
    
  </div>
  

  <!-- Images of Me -->
  <div class="w3-row-padding w3-padding-16" id="memory">
    
  </div>

  <div class="w3-container w3-padding-large" style="margin-bottom:32px">
    <h4><b>Record</b></h4>
    
    <%@ page import="java.util.List" %>
    <%@ page import="model.Record" %>
    <% 
    	List<Record> temp = (List<Record>) session.getAttribute("records");
    	for (Record item : temp) {
    %>
    
    	<div class="w3-third w3-container w3-margin-bottom">
		      
		      <div class="w3-container w3-white">
		        <p><b><%= item.getStatement() %></b></p>
		        <p><%= item.getTime() %></p>
		      </div>
		    </div> 
		<% } %>
    <hr>
  </div>
  <!-- profile Section -->
  <div class="w3-container w3-padding-large w3-grey">
    <h4 id="contact"><b>Profile</b></h4>
    <div class="w3-row-padding w3-center w3-padding-24" style="margin:0 -16px">
      <div class="w3-third w3-dark-grey">
        <p><i class="fa fa-envelope w3-xxlarge w3-text-light-grey"></i></p>
        <p><jsp:getProperty name="user" property="email"/></p>
      </div>
      <div class="w3-third w3-teal">
        <p><i class="fa fa-user w3-xxlarge w3-text-light-grey"></i></p>
        <p><jsp:getProperty name="user" property="name"/></p>
      </div>
      <div class="w3-third w3-dark-grey">
        <p><i class="fa fa-money w3-xxlarge w3-text-light-grey"></i></p>
        <p><jsp:getProperty name="peanut" property="points"/></p>
      </div>
    </div>
    <div class="w3-panel w3-pale-yellow w3-display-container w3-border">

  <span>${messages}</span>
</div>
    <h3>Change password</h3>  
     <form class="w3-container" action="changePass" method="post" >	
	<label>Old Password</label>
	<input class="w3-input" type="password" id="password" name="password">
	<label>New Password</label>
	<input class="w3-input" type="password" id="newPassword" name="newPassword">
	<label>Repeat New Password</label>
	<input class="w3-input" type="password" id="rpassword" name="rpassword">
	<div class="w3-center w3-padding-16">
	<button class="w3-button w3-black w3-center" type="submit" name="btn" >Change</button>
	</div>	
	</form> 
    
  </div>

  <!-- Footer -->
<footer class="w3-container w3-padding-32 w3-dark-grey">
	<div class="w3-row-padding">
	   <div class="w3-third">
	      <h3>FOOTER</h3>
	      <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
	      <p>Powered by team 13</p>
	    </div>
	    <div class="w3-third">
	      <h3>Extra Function</h3>
	      <ul class="w3-ul w3-hoverable">
	        <li class="w3-padding-16">
	         <a href="jsp/uploadAppPage.jsp">
	          <span class="w3-large">Upload your own apps</span><br>
	          <span>Upload your own apps to gain more peanut points</span></a>
	        </li>
	        <li class="w3-padding-16">
	          <img src="/w3images/gondol.jpg" class="w3-left w3-margin-right" style="width:50px">
	          <span class="w3-large">Ipsum</span><br>
	          <span>Praes tinci sed</span>
	        </li> 
	      </ul>
	    </div>
	</div>
</footer>
  <div class="w3-black w3-center w3-padding-24">Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-opacity">team 13</a></div>
</div>

<script>
// Script to open and close sidebar
function app_select(id) {
	location.href = "appSelection"+"?appId="+id;
	
	
}
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
