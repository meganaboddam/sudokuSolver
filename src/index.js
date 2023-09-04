const app = require( "./app");
const PORT = process.env.PORT || 3000;
const axios = require('axios').default
const express = require('express')
const cors = require('cors')
app.use(cors())
require('dotenv').config()
app.use(express.json())

app.post('/solve', (req, res) => {
  console.log(req.body)
  const options = {
    method: 'POST',
    data: {
      puzzle: req.body.numbers
    }
  };
  axios.request(options).then((response) => {
    console.log(response.data)
    res.json(response.data)
  }).catch((error) => {
    console.error(error)
  })
})

app.listen(PORT, () => console.log(`server running on PORT ${PORT}`))
