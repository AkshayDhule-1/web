function checkEmptyField(fieldId) {
  alert('checkEmptyField ' + fieldId);
}

function validate() {
  //var x = document.getElementById('uname').value;
  var x= document.getElementsByName('uname').values;
  var y = document.getElementById('upass').value;

  console.log('value of x ' + x);
  console.log('value of y ' + y);

  if (x === "") {
     alert(")
    document.getElementById("nameErr").innerHTML = "Username cannot be blank";
    return false;
  }

  if (y === "") {
    document.getElementById("passErr").innerHTML = "Password cannot be blank";
    return false;
  }
	
  // Password must be at least 8 characters long
  if (y.length < 8) {
    return false;
  }

  // Password must contain at least one uppercase letter
  if (!/[A-Z]/.test(y)) {
    return false;
  }

  // Password must contain at least one lowercase letter
  if (!/[a-z]/.test(y)) {
    return false;
  }

  // Password must contain at least one digit
  if (!/\d/.test(y)) {
    return false;
  }


  
  const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
  var ueamil = document.getElementById('ueamil').value;
  if(ueamil==""){
		document.getElementById("emailError").innerHTML = "Email cannot be blank";
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
