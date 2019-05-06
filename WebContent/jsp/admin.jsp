<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<title>Check</title>
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
    <a href="/JBCY/Profile" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-text-teal"><i class="fa fa-home fa-fw w3-margin-right"></i>Home</a> 
    <a href="/JBCY/Profile" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw w3-margin-right"></i>Profile</a> 
    <a href="jsp/uploadAppPage.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-star fa-fw w3-margin-right"></i>Upload</a>
    <% if (user.getRole() == 1) {%> 
    <a href="/JBCY/check" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-stack fa-fw w3-margin-right"></i>Check</a> 
    <% }%>
    <a href="${pageContext.request.servletContext.contextPath}/logout" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope fa-fw w3-margin-right"></i>Log out</a>
  </div>
  
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

  <!-- Header -->
  <header id="home">
    <a href="#"></a>
    <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
    <div class="w3-container">
    	<h1><b>Apps need to be checked</b></h1>
    </div>
  </header>
  
 
  <div class="w3-row-padding">
  <%@ page import="java.util.List" %>
    <%@ page import="model.App" %>
    <%@ page import="service.TransactionImpl" %>
    
    <% 
    	List<App> list = new TransactionImpl().checkApps();
    	for (App item : list) {
    %>
    	
    	<div class="w3-third w3-container w3-margin-bottom" id=<%= item.getId() %> onclick="app_select(<%= item.getId() %>)" >
		      
		      <div class="w3-container w3-white">
		        <p><b><%= item.getName() %> (<%= item.getPoints() %>)</b></p>
		        <p><%= item.getDescription() %></p>
		      </div>
		    </div> 
		<% } %>
    
    
    
  </div>
  

  <!-- Images of Me -->
  <div class="w3-row-padding w3-padding-16" id="memory">
    
  </div>

  <div class="w3-container w3-padding-large" style="margin-bottom:32px">
    <h4><b>Modify the apps</b></h4>
    <form class="w3-container" action="/JBCY/check" method="GET" enctype="multipart/form-data">
		<input id="action" name="action" type="hidden" value="delete">
    <% 
    	
    	for (App item : list) {
    %>
		<div class="w3-container w3-white">
		   <input type="checkbox" name="deleteApps" value="<%= item.getId() %>"><%= item.getName()%>  &nbsp;&nbsp; <%= item.getOwnerId()%> &nbsp;&nbsp; <%= item.getDescription() %>
		</div>   
		<% } %>
		<div class="w3-center w3-padding-16">
			<button class="w3-button w3-black w3-center" type="submit" name="publishBtn" >Publish</button>
			<button class="w3-button w3-black w3-center" type="submit" name="deleteBtn" >Delete</button>
			
		</div>
	</form>	
    <hr>
  </div>
  
  
  <div class="w3-black w3-center w3-padding-24">Powered by Team 13</div>
</div>

<script>
// Script to open and close sidebar
function app_select(id) {
	location.href = "/JBCY/check"+"?appId=" + id + "action=test";
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
