const express = require("express");
const app = express();

app.get('/', (req, res)=>{
    res.status(200);
    res.send("Welcome to Sudoku Solver");
});

app.get("/test", (_req, res) =>  {
  res.status(200).send("Hello world")
})

module.exports = app;