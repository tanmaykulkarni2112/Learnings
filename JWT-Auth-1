const jwt = require("jsonwebtoken");

const value= {
    name: "tanmay",
    accountNumber: 23123123
}

//creating the token for the value and with secret as the passkey for encoding and decoding!
const token = jwt.sign(value,"secret");
// console.log(token);

const verifiedValue = jwt.verify("eyJhbGciOiJIUzI1NiIs..............MzNzQ0OX0.edDFqYavSXNJ3iph_D95B9CTJb2onZOd-TV5xDvFz-E","secret");

console.log(verifiedValue);
