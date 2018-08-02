
var novoH1 = document.createElement("h1");
var novoParagrafo = document.createElement("p");


//para adicionar conteudo, nos usamos innerHTML

novoH1.innerHTML = " Este é um novo H1";
novoParagrafo.innerHTML = "Este é um paragrafo inserido atraves do javascript";


document.getElementById("informacoes").appendChild(novoH1);
document.getElementById("informacoes").appendChild(novoParagrafo);

