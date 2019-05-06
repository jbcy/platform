var msg = document.getElementById("messageSpan").innerText;
console.log(msg);
if(!msg.localeCompare("Success! we send an email with your new password."))
{
	window.setTimeout(myTimer, 1500);

}

function myTimer() 
{
	 window.location.href = "/JBCY"; 
}