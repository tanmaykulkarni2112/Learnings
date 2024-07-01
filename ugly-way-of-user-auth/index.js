const express = require("express");
const app = express();

app.get("/health-checkup", function (req, res) {
  const kidneyId = req.query.kidneyId;
  const username = req.headers.username;
  const password = req.headers.password;

  if (username != "Tanmay" || password != "pass") {
    res.status(403).json({
      msg: "User does not exist",
    });
    return;
  }

  if (username == "Tanmay" && password == "pass") {
    if (kidneyId == 1 || kidneyId == 2) {
      res.json({
        msg: "Your kidney is Fine!",
      });
      return;
    }
    //   res.status(403).json({
    //    msg : "User does not exist", 
    //   });
    //   return;
    // }

    if (kidneyId != 1 && kidneyId != 2) {
      res.status(411).json({
        msg: "Wrong input",
      });
      return;
    }
  }

  res.send("Your heart is healthy");
});

app.listen(3000, () => {
  console.log("Server is running on port 3000");
});
