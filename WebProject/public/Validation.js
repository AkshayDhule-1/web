/**
 * 
 */
function checkEmptyField(fieldId) {
  alert('checkEmptyField ' + fieldId);
}

function validate() {

  var x= document.getElementsByName('uname').value;
  var y = document.getElementById('upass').value;

  console.log('value of x ' + x);
  console.log('value of y ' + y);

  if (x === "") {
	
    document.getElementById("nameErr").innerHTML = "Username cannot be blank";
    return false;
  }

  if (y === "") {
    document.getElementById("passErr").innerHTML = "Password cannot be blank";
    return false;
  }

  if (y.length < 8) {
	  alert("Password must be at least 8 characters long");
    return false;
  }

  if (!/[A-Z]/.test(y)) {
	  alert("Password must contain at least one uppercase letter");
    return false;
  }
 
  if (!/[a-z]/.test(y)) {
	  alert("Password must contain at least one lowercase letter");
    return false;
  }

  if (!/\d/.test(y)) {
	  alert("Password must contain at least one digit");
    return false;
  }


  
  const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
  var ueamil = document.getElementById('uemail').value;
  if(ueamil==""){
	  	alert("Email cannot be blank");
		document.getElementById("uemail").innerHTML = "Email cannot be blank";
    	return false;  
  }
  
  if (!emailRegex.test(ueamil)) {
    return false;
  }
	
  var date = document.getElementById(udob).value;
  const currentDate = new Date();
  if(currentDate==null){
	return false;
   }
	
   if(date>currentDate){
	return false;
   }

    return true;
}

function validateRegistration()
{

	  const emailRegex =  /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	  var mail = document.getElementById('uemail').value;
	  
	  if(mail ===""){  	
			document.getElementById("uemail").innerHTML = "Email cannot be blank";
	    	return false;  
	  }
	  
	  if (!emailRegex.test(mail)) {
		alert("Email is wrong..");
	    return false;
	  }
	  
	if(validate()==false){
		return false;
	}

	  return true;
}


function clearTheForm() {
  document.getElementById('uname').value = "";
  document.getElementById('upass').value = "";
}

function clearNameErrMsg() {
  document.getElementById('nameErr').innerHTML = "";
}

function clearPassErrMsg() {
  document.getElementById('passErr').innerHTML = "";
}
