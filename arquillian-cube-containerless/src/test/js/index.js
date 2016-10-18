var express = require('express');

var app = express();

app.get('/', function(req, res){
    res.send('Hello World from NodeJS!');
});

app.listen(8080);
