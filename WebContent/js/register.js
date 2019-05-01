function validationR()
{

	
	var name = document.getElementById("rname").value;
	var email = document.getElementById("remail").value;
	var password = document.getElementById("rpassword").value;
	var repeat = document.getElementById("rrepeat").value;
	if( name == null || name.length == 0 || /^\s+$/.test(name)||email == null || email.length == 0 || /^\s+$/.test(email) ||password == null || password.length == 0 || /^\s+$/.test(password)||repeat == null || repeat.length == 0 || /^\s+$/.test(repeat)) 
	{
		document.getElementById('errorsRegister').innerHTML = "<div class='w3-panel w3-pale-red w3-border'><p>Please fill all the fields.</p></div>";
		  return false;
	}
	if(password.localeCompare(repeat))
	{
		document.getElementById('errorsRegister').innerHTML = "<div class='w3-panel w3-pale-red w3-border'><p>The passwords are different.</p></div>";
		return false;
	}
	if(password.length < 6)
	{
		
		document.getElementById('errorsRegister').innerHTML = "<div class='w3-panel w3-pale-red w3-border'><p>The password should be at least 6 characters</p></div>";
		return false;
	}
	return true;
	
}
