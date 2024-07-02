const express = require("express");
const app = express();
app.use(express.json()); // This middleware parses JSON bodies

//
app.post("/health-checkup", function(req, res) {
  if (!req.body || !req.body.kidneys) {
    return res.status(400).send("Kidneys field is missing from the request body.");
  }

  const kidneys = req.body.kidneys;
  const kidneyLength = kidneys.length;

  res.send("Your kidney length is " + kidneyLength);
});

app.listen(3000, () => {
  console.log("Server is running on port 3000");
});
