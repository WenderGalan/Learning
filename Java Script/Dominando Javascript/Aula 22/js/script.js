function preparaEventos (){
    document.getElementById("formulario1").onsubmit = function(){
        // prevenir o envio do formulario se o usuario nao informou e-mail
        
        if(document.getElementById("email").value== ""){
            
            document.getElementById("mensagemErro").innerHTML = "Por favor informe um e-mail! ";
            // impedir o envio do formulario
            
            return false;
        }else{
            //permitir o envio do email
            document.getElementById("mensagemErro").innerHTML= "";
            return true;
            
            
        }
            
            
            
        }
        
        
        
        
        
    }
    
window.onload = function (){
    
    preparaEventos();
}
    
    
    
    
    
    
    
    
