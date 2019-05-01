<!DOCTYPE html>
<html>
<title>JBCY</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-metro.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="./style/home.css">
<body>

<!-- Header / Home-->
<header class="w3-display-container w3-wide bgimg " id="home">
  <div class="w3-display-middle w3-text-white w3-center">
    <h1 class="w3-jumbo"><b>JBCY Platform</b></h1>
    <h2><b>Easy student life</b></h2>
  </div>
</header>

<!-- Navbar (sticky bottom) -->
<div class="w3-bottom w3-hide-small">
  <div class="w3-bar w3-white w3-center w3-padding w3-opacity-min w3-hover-opacity-off">
    <a href="#home" style="width:25%" class="w3-bar-item w3-button">Home</a>
    <a href="#description" style="width:25%" class="w3-bar-item w3-button">Description</a>
    <a href="#login" style="width:25%" class="w3-bar-item w3-button">Log in</a>
    <a href="#join" style="width:25%" class="w3-bar-item w3-button w3-hover-black">Join</a>
  </div>
</div>
<!-- About description -->
<div class="w3-container w3-padding-64 w3-light-gray w3-grayscale-min" id="description">
  <div class="w3-content">
    <h1 class="w3-center w3-text-grey"><b>JBCY</b></h1>
    
    <p> The JBCY platform help app developers to offer their services to the students of the University of Sheffield
    By being keen on an Easy Student Life. The development team provides two apps, Module rating and Second-hand selling.
    The apps which serve in the same purpose are welcome.
    </p><br>
		
 
  </div>
</div>


<!-- Login information -->
<div class="w3-container w3-padding-64 w3-light-gray w3-grayscale-min  " id="login">
<div class="w3-panel w3-pale-yellow w3-display-container w3-border">

  <span>${messages}</span>
</div>

  <div class="w3-content">
    <h1 class="w3-text-grey w3-center"><b>Welcome back!</b></h1>
    <form class="w3-container" action="login" method="post" >
	<label>Email</label>
	<input class="w3-input" type="email" id="lemail" name="lemail">
	
	<label>Password</label>
	<input class="w3-input" type="password" id="lpassword" name="lpassword">
	<div class="w3-center w3-padding-16">
	<button class="w3-button w3-black w3-center" type="submit" name="btn" value="l">Log in</button>
	</div>
	
	</form>
  </div>
</div>

<!-- Registration section -->
<div class="w3-container w3-padding-64 w3-metro-dark-green w3-center w3-wide" id="join">
  <h1>JOIN US TODAY!</h1>

  <p class="w3-xlarge">
    <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-round w3-black " style="padding:8px 60px">JOIN</button>
  </p>
</div>

<!-- Registration modal -->
<div id="id01" class="w3-modal">
  <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="padding:32px;max-width:600px">
    <div class="w3-container w3-white ">
    
    	<div id="errorsRegister">
    	</div>
      <h1 class="w3-wide w3-center">Registration</h1>
      <form class="w3-padding-16"   action="Register" method="post" onsubmit="return validationR()">
      	<label>Name</label>
		<input class="w3-input" type="text" name="rname" id="rname">
		<label>Email</label>
		<input class="w3-input" type="email" name="remail" id="remail">
		<label>Password</label>
		<input class="w3-input" type="password" name="rpassword" id="rpassword">
     	<label>Repeat Password</label>
		<input class="w3-input" type="password" name="rrepeat" id="rrepeat">
		<br>
		  <div class="w3-row">
	        <div class="w3-half">
	          <button type="submit" name="btn"  value="r"  class="w3-button w3-block w3-green">Join</button>
	        </div>
	        <div class="w3-half">
	          <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-block w3-red">Cancel</button>
	        </div>
	      </div>
		
      </form>
     
    </div>
  </div>
</div>

<!-- Footer -->
<footer class="w3-center w3-black w3-padding-48">
  <p>Powered by team 13</p>
</footer>
<div class="w3-hide-small" style="margin-bottom:32px"></div>

<script src="./js/register.js"></script>

</body>
</html>
