const express = require("express");
const jwt = require("jsonwebtoken");
const mongoose = require("mongoose");
const jwtPassword = "123456";

const app = express();
app.use(express.json());

mongoose.connect(  "mongodb+srv:fefefefefefoiiw.mongodb.net/userappnew",
);

const User = mongoose.model("User", {
  name: String,
  username: String,
  pasword: String,
});

// normal way of doing it 
// const user = new User({
//   name: "Tanmay",
//   email: "oqibz@example.com",
//   password: "123456"
// })

// but this can also be done in the routes
app.post("/users", async (req,res) =>{
  const username = req.body.username;
  const password = req.body.password;
  const name = req.body.name;
})

const existingUser = await User.findOne({username: username});
if(existingUser) {
  return res.send("User already exists!");
}

user.save();
res.send("User created successfully!");
