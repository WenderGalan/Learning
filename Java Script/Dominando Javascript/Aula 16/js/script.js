

var tituloPrincipal = document.getElementById("mainTitle");
console.log("Este elemento é do tipo: ",tituloPrincipal.nodeType);
console.log("O conteudo do html é: ", tituloPrincipal.innerHTML);
console.log("Quantos child nodes ",tituloPrincipal.childNodes);

var meuslinks = document.getElementsByTagName("a");
console.log("Quantidade de links ",meuslinks.length);