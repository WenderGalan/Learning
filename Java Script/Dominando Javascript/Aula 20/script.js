var campoEmail = document.getElementById("email");

campoEmail.onfocus = function() {
    if (campoEmail.value== "Digite Seu e-mail") {
        campoEmail.value="";
    }
    
    };


campoEmail.onblur = function() {
    
    if( campoEmail.value  == "") {
        
        campoEmail.value = "Digite Seu e-mail";
    }
};

