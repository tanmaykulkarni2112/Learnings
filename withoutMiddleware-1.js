const express = require("express");
const { get } = require("http");
const app = express();

function ageCheck(age){
  if (age >= 14) return true;
  else return false;
}

//Send query like http://localhost:3000/rides?age=63
app.get("/rides", (req, res) => {
  if(ageCheck(req.query.age)) {
    res.json({
      msg: "Riden ridden"
    })
  } else {
    res.json({
      msg: "No rides for you"
    })
  }
})

// app.get("/rides", function(req,res){
//   res.json({
//     msg: "Ride ridden"
//   })
// })

app.listen(3000);
