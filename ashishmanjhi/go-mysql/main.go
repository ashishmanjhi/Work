package main

import(
	"fmt"
	"database/sql"
	_"github.com/go-sql-driver/mysql"
)

type User struct {
	Name string `json:"name"`
}


func main(){

fmt.Println("Go mysql")

db,err:=sql.Open("mysql","root:root@tcp(127.0.0.1:3306)/test")

if err !=nil {
	panic(err.Error())
}

defer db.Close()


results,err:=db.Query("Select name from user")
if err !=nil {
	panic(err.Error())
}

for results.Next(){
	var user User

	err=results.Scan(&user.Name)
	if err !=nil {
		panic(err.Error())
	}

	fmt.Println(user.Name)
}

// insert,err:=db.Query("Insert into user values('Ashish')")
// if err !=nil {
// 	panic(err.Error())
// }

// defer insert.Close()

// fmt.Println("successfull insertion in user table")

}
