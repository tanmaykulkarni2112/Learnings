//taking input in the form of windown prompt!
// let username = window.prompt("Whats your username");
// console.log(username);


let username;
//use of onclick 
document.getElementById("MySubmit").onclick = function(){
    username = document.getElementById("MyText").value;
    console.log(username);
    //update the h1 real time like seen before in doc
    document.getElementById("myH1").textContent = `Hello ${username}`;
}