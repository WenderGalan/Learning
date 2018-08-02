var posicaoAtual = 0;
var seguraIntervalo;


function comecoAnimacao() {
    document.getElementById("info").style.position ="absolute";
     document.getElementById("info").style.left = "0px";
     document.getElementById("info").style.top = "100px";
    
    seguraIntervalo = setInterval(caixaAnimada, 50);
    
    
        
}

function caixaAnimada(){
    
    
    posicaoAtual += 5;
    document.getElementById("info").style.left = posicaoAtual + "px" ;
    
    
    if (posicaoAtual > 900) {
        
        
        clearInterval(seguraIntervalo);
        
        
            document.getElementById("info").style.position ="";
     document.getElementById("info").style.left = "";
     document.getElementById("info").style.top = "";
       
        
    }
    
    
    
}
    
    window.onload = function(){
        
        setTimeout (comecoAnimacao,3000);
    }
    
    
    
    
