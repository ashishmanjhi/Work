var express = require('express');

var app = express();
const mysql = require('mysql2');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root', //username
  password: 'root', //passwword
  database: 'carbejdo'
});
var server = app.listen(8081, function () {
  
   console.log("server is running");
})
app.use(express.static('carbejdo'));
/*----------------All addtional fuctions goes after this------------------*/


//1.Login

app.get('/login', function (req, res) {
  
   var user=req.query.uid;
   var pwd=req.query.pwd;

var result ="";
console.log(user+""+pwd);
connection.query("SELECT * FROM `emp` WHERE `empid`=? AND `pwd`=? ",[user,pwd], function (err, rs, fields) {
   if(err)
  {
	result="Invalid username or password";
  }
	
  else
  {	  
		result=rs ;
  }
  res.send(result);
  
});
connection.end();


});

//2.insert car details

app.get('/cardetail', function (req, res) {
  

  var carId=req.query.carid;
  var Model=req.query.model;
  var color=req.query.ccolor;
  var year=req.query.year;
  var rate=req.query.rate;
  var Manufacturer=req.query.manufact;
  var Type=req.query.ctype;
  var sale=req.query.opt;
  var custId=req.query.custid;
   
carId,Model,color,year,rate,Manufacturer,Type,sale,custId
var result ="";
connection.query('INSERT INTO car values(?,?,?,?,?,?,?,?,?)', [carId,Model,color,year,rate,Manufacturer,Type,sale,custId],(err, rs) => {
  if(err)
    result="not ok";
  else
  {   
    result=rs.affectedRows ;
    console.log(result);

    
  }
  res.send(result);
  
});
connection.end();


});






