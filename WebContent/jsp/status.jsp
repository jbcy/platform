<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="text-indent: 2em; margin-top: 30px;">  
The site will redirect to the new page in <span id="time">5</span> seconds. If the automatically redirecting fails, please click <a href="/profile" title="点击访问">here</a> to go.
</body>
<script type="text/javascript">    
    delayURL();      
    function delayURL() {   
        var delay = document.getElementById("time").innerHTML;  
 		var t = setTimeout("delayURL()", 1000);  
        if (delay > 0) {  
            delay--;  
            document.getElementById("time").innerHTML = delay;  
        } else {  
	     clearTimeout(t);   
	            window.location.href = "/JBCY/Home";  
	        }          
    }   
</script>  
</html>