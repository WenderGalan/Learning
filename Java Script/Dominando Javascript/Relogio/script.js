const HOURHAND = document.querySelector("#hour");
const MINUTEHAND = document.querySelector("#minute");
const SECONDHAND = document.querySelector("#second");


date = new Date();
let hora = date.getHours();
let minuto = date.getMinutes();
let segundo = date.getSeconds();

let hrPosi = (hora * 360 / 12) + (minuto * (360/60)/12);
let minPosi = minuto * 360 / 60 + (segundo * 360 / 60)/60;
let segPosi = segundo * 360 / 60;

function rodaRelogio(){

  hrPosi = hrPosi + (3/360);
  minPosi = minPosi + (6/60);
  segPosi = segPosi + 6;

  HOURHAND.style.transform = "rotate(" + hrPosi + "deg)";
  MINUTEHAND.style.transform = "rotate(" + minPosi + "deg)";
  SECONDHAND.style.transform = "rotate(" + segPosi + "deg)";
}

var intervalo = setInterval(rodaRelogio, 1000);
