var segundosRestantes;
var intervalHandle ;


function resetaPagina(){
    document.getElementById("inputArea").style.display = "block";
        
    
}

function tick () {
    //pegar o h1
    
    var exibeTempo = ducument.getElementById("tempo");
    
    // trasnformar segundos em MM;SS
    
    var minuto = Math.floor(segundosRestantes/60);
    var segundo = segundosRestantes - (minuto * 60);
    
    //
    
    
    
    
    
}