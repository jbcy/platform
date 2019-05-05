<!DOCTYPE html>
<html>
<title>JBCY</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-metro.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="./style/home.css">
<body class="w3-light-gray w3-grayscale-min">




<!-- Login information -->
<div class="w3-container w3-padding-64 w3-light-gray w3-grayscale-min  " id="login">
<div class="w3-panel w3-pale-yellow w3-display-container w3-border">

  <span>${messages}</span>
</div>

  <div class="w3-content">
  <div>
  </div>
    <h1 class="w3-text-grey w3-center"><b>Reset Password</b></h1>
    <form class="w3-container" action="resetPass" method="post" >
	<label>Email</label>
	<input class="w3-input" type="email" id="email" name="email">
	
	<div class="w3-center w3-padding-16">
	<button class="w3-button w3-black w3-center" type="submit" name="btn" value="l">Reset</button>
	</div>
	</form>
  </div>
  <a href="/JBCY/"  class="w3-display-bottommiddle w3-padding-24">Have not register yet?, go back</a>
</div>





<!-- Footer -->
<footer class="w3-center w3-black w3-padding-48 footerUpload">
  <p>Powered by team 13</p>
</footer>
<div class="w3-hide-small" style="margin-bottom:32px"></div>

<script src="./js/register.js"></script>

</body>
</html>
