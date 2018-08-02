var myRequest;




if (window.XMLHttpRequest) { // firefox , safari e etc.
    myRequest = new XMLHttpRequest();
    
    
}else if (window.ActiveXObject) { //se não IE
     myRequest = new ActiveXObject ("Microsoft.MXLHTTP");
    
}
    
    myRequest.onreadystatechange = function() {
        
        
        console.log("Nos fomos Chamados!");
        console.log(myRequest.readyState);
        
    };
//abrir arquivo e enviar
myRequest.open ('GET', 'simples.txt', true);

myRequest.send(null);

    
    
