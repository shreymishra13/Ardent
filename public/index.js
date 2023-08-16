


const passwords= document.querySelector("#password") ;


const confirmationPassword= document.querySelector("#confirmation-password") ;

confirmationPassword.onkeyup=function (){
  const passwordStatus = document.querySelector("#password-status");

if(passwords.value===confirmationPassword.value){
    passwordStatus.innerHTML="Password matched";
    passwordStatus.classList.add("password-matched");
    passwordStatus.classList.remove("password-not-matched");
  }
  else{
    passwordStatus.innerHTML="Password doesn't matched";
    passwordStatus.classList.add("password-not-matched");
    passwordStatus.classList.remove("password-matched");
  }

}