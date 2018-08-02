






var hoje = new Date ();

var hojeMesmo = hoje.getMonth(); //base 0 por exe: janeiro = 0 , fevereiro = 1, março = 2
var esteAno = hoje.getFullYear(); //nao é base 0
var anoAtual = hoje.getYear();
var dataHoje =hoje.getDate();// dia da mês
var diaAtual = hoje.getDay();// dia da semana


var meuDia = new Date(1983,4,26);

console.log("Flavio nasceu em:",meuDia.getFullYear (),meuDia.getDay());



console.log(hojeMesmo,esteAno,anoAtual,dataHoje,diaAtual);




