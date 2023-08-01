<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
	<title>Login here</title>
	<link rel="stylesheet" href="Login3.css">
	<script src = "Validation.js"></script>
</head>
	
	
	<body>
		
		<h1>My Airlines</h1>	
		<hr>
		<h2>Login Here</h2>	
		<form action ="Dashboard.html">
			<label>Enter username</label> <input  type=text     onkeyup="clearNameErrMsg()" id="uname"><span id="nameErr"></span><br>
			<label>Enter password</label> <input  type=password onkeyup="clearPassErrMsg()" id="upass"><span id="passErr"></span><br>	
			Not a member yet? Click <a href="Register.html">Here</a> to register<br>	
			Reset password? Click <a href="ResetPassword.html">Here</a><br>	
			Forgot password? Click <a href="ForgotPassword.html">Here</a><br>	
			
			<button onclick="return validate();" type="submit">Login</button>	<br>
		</form>
		
			<button onclick="clearForm()" style="background-color: lightgreen">Clear</button>
		
		
		
	</body>

</html>
