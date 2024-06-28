let circum;
let radius;
const pi = 3.14;

document.getElementById("mySubmit").onclick = function(){
    
    
    //console.log(2*pi*radius);
    document.getElementById("myH1").textContent = `calculated the circumference`;
    radius = document.getElementById("myText").value;
    radius = Number(radius);
    circum = 2*pi*radius;
    document.getElementById("myH3").textContent = `Found the circumference is ${circum}`;
}
//radius = window.prompt("Enter the radius");
