/**
 * 
 */
function checkEmptyField(fieldId) {
  alert('checkEmptyField ' + fieldId);
}

function validate() {
  var x = document.getElementById('uname').value;
  
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
  
    return true;
}



 function validateAge() {
	 		
	 		
	 		 var z= document.getElementsByName('udob').value;
	
	/*		if(z==undefined){
				  document.getElementById("dateErr").innerHTML = "Date cannot be empty";
    		return false;
			}
				console.log('Z value is : '+z);
				*/
            
            var dobInput = document.getElementById('udob').value;
            var dob = new Date(dobInput);
            var today = new Date();

            var age = today.getFullYear() - dob.getFullYear();

            if (today.getMonth() < dob.getMonth() || (today.getMonth() === dob.getMonth() && today.getDate() < dob.getDate())) {
                age--;
            }

            document.getElementById('udob').textContent = "Age: " + age;

            if (age > 18) {
                return true;
            } else {
                alert('You must be 18+');
                return false;
            }
        }



function validateRegistration()
{
	
	var eml = document.getElementById('uemail').value;
  //var x= document.getElementsByName('uname').value;
 

  	if (eml === "") {
    	document.getElementById("emailError").innerHTML = "Email cannot be blank";
    	return false;
 	 }
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
	  
	  
	var z= document.getElementsByName('udob').value;
	console.log(z);
	
	if(!validate()){
		return false;
	}
	
	if(!validateAge()){
		return false;
	}


	  return true;
}

function clearForm() {
	document.getElementById('uemail').value = "";
  document.getElementById('uname').value = "";
  document.getElementById('upass').value = "";
  
}

function clearNameErrMsg() {
  document.getElementById('nameErr').innerHTML = "";
}

function clearPassErrMsg() {
  document.getElementById('passErr').innerHTML = "";
}
