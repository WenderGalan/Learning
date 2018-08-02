var minhaImagem = document.getElementById("imagemPrincipal");


 var arrayImagem = [ "praia.jpg","cidade.jpg","aviao.jpg"];


var imagemIndex = 0;


function mudaImagem() {

    minhaImagem.setAttribute ("src", arrayImagem[imagemIndex]);
    imagemIndex ++;

    if (imagemIndex >= arrayImagem.length){

        imagemIndex = 0;
    }


}

setInterval(mudaImagem,2000);
