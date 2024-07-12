const express = require("express");
const { get } = require("http");
const app = express();


//no need of using function like this now 
// function ageCheck(age){
//   if (age >= 14) return true;
//   else return false;
// }



function isOldEnoughMiddleware(req,res,next) {
  const age = req.query.age;
  if(age >= 14) next();
  else{
    res.json({
      msg: "You are not old enough to ride these rides"
    })
  }
}

//Send query like http://localhost:3000/rides?age=63

// can also use app.use(isOldEnoughMiddleware);

app.get("/rides", isOldEnoughMiddleware, function(req ,res){
  res.json({
    msg: "Ride ridden"
  })
})

app.listen(3000);
