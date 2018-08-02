
/*document.onclick = function(){
    
    
    alert("Voce clicou em algum lugar do documento");
};*/
function prepararEventos() {

document.getElementById("paragrafo1").onclick = function(){
    
    alert("voce clicou no paragrafo 1");
}

}

window.onload = function() {
    
    prepararEventos();
}