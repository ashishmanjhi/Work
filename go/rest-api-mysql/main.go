package main

import (
	"database/sql"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"

	_ "github.com/go-sql-driver/mysql"
	"github.com/gorilla/mux"
)

// Book Struct
type Book struct {
	ID    string `json:"id"`
	Isbn  string `json:"isbn"`
	Title string `json:"title"`
	auid  int    `json:"auid"`
}

//Author Struct
type Author struct {
	Firstname string  `json:"firstname"`
	Lastname  string  `json:"lastname"`
	Age       int     `json:"age"`
	Rating    float32 `json:"rating"`
	auid      int     `json:"auid"`
}

func dbConn() (db *sql.DB) {
	dbDriver := "mysql"
	dbUser := "root"
	dbPass := "root"
	dbName := "test"
	db, err := sql.Open(dbDriver, dbUser+":"+dbPass+"@/"+dbName)
	if err != nil {
		panic(err.Error())
	}
	return db
}

//book var a slice
var books []Book

// get all books
func getBooks(w http.ResponseWriter, r *http.Request) {

	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	selDB, err := db.Query("SELECT * FROM Book")
	if err != nil {
		panic(err.Error())
	}

	for selDB.Next() {
		var book Book
		err = selDB.Scan(&book.ID, &book.Isbn, &book.Title, &book.auid)
		if err != nil {
			panic(err.Error())
		}
		fmt.Print(book.ID + " " + book.Isbn + " " + book.Title + " ")
		fmt.Println(book.auid)
		json.NewEncoder(w).Encode(book)
	}
	defer db.Close()
}

// get single books
func getBook(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	params := mux.Vars(r)
	result, err := db.Query("SELECT ID, Isbn, Title, auid FROM book WHERE ID = ?", params["id"])
	if err != nil {
		panic(err.Error())
	}
	var book Book
	for result.Next() {
		err := result.Scan(&book.ID, &book.Isbn, &book.Title, &book.auid)
		if err != nil {
			panic(err.Error())
		}
	}
	json.NewEncoder(w).Encode(book)
	defer db.Close()
}

// create books
func createBooks(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()

	stmt, err := db.Prepare("INSERT INTO Book(ID,Isbn,Title,auid) VALUES(?,?,?,?)")
	if err != nil {
		panic(err.Error())
	}
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		panic(err.Error())
	}
	keyVal := make(map[string]string)
	json.Unmarshal(body, &keyVal)
	id := keyVal["id"]
	isbn := keyVal["isbn"]
	title := keyVal["title"]
	auid := keyVal["auid"]
	_, err = stmt.Exec(id, isbn, title, auid)
	if err != nil {
		panic(err.Error())
	}
	defer db.Close()
}

// update books not working
func updateBooks(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	params := mux.Vars(r)
	stmt, err := db.Prepare("UPDATE book SET Isbn=?,Title = ? WHERE ID = ?")
	if err != nil {
		panic(err.Error())
	}
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		panic(err.Error())
	}
	keyVal := make(map[string]string)
	json.Unmarshal(body, &keyVal)
	isbn := keyVal["isbn"]
	title := keyVal["title"]
	_, err = stmt.Exec(isbn, title, params["id"])
	if err != nil {
		panic(err.Error())
	}

	json.NewEncoder(w).Encode(books)
	defer db.Close()
}

// delete books
func deleteBooks(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	params := mux.Vars(r)
	stmt, err := db.Prepare("DELETE FROM Book WHERE ID = ?")
	if err != nil {
		panic(err.Error())
	}
	_, err = stmt.Exec(params["id"])
	if err != nil {
		panic(err.Error())
	}
	defer db.Close()
}

// get all authors
func getAuthors(w http.ResponseWriter, r *http.Request) {

	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	selDB, err := db.Query("SELECT * FROM Author")
	if err != nil {
		panic(err.Error())
	}

	for selDB.Next() {
		var author Author
		err = selDB.Scan(&author.Firstname, &author.Lastname, &author.Age, &author.Rating, &author.auid)
		if err != nil {
			panic(err.Error())
		}
		//fmt.Fprintf(author.Firstname + " " + author.Lastname + " " + author.Age + " " + author.auid + " " + author.Rating)
		json.NewEncoder(w).Encode(author)
	}
	defer db.Close()
}

// get single author
func getAuthor(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	params := mux.Vars(r)
	result, err := db.Query("SELECT Firstname,Lastname,Age,Rating,auid FROM author WHERE auid = ?", params["id"])
	if err != nil {
		panic(err.Error())
	}
	var author Author
	for result.Next() {
		err := result.Scan(&author.Firstname, &author.Lastname, &author.Age, &author.Rating, &author.auid)
		if err != nil {
			panic(err.Error())
		}
	}
	json.NewEncoder(w).Encode(author)
	defer db.Close()
}

// create author
func createAuthor(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()

	stmt, err := db.Prepare("INSERT INTO Author(Firstname,Lastname,Age,Rating,auid) VALUES(?,?,?,?,?)")
	if err != nil {
		panic(err.Error())
	}
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		panic(err.Error())
	}
	keyVal := make(map[string]string)
	json.Unmarshal(body, &keyVal)
	firstname := keyVal["firstname"]
	lastname := keyVal["lastname"]
	age := keyVal["age"]
	rating := keyVal["rating"]
	auid := keyVal["auid"]
	_, err = stmt.Exec(firstname, lastname, age, rating, auid)
	if err != nil {
		panic(err.Error())
	}
	defer db.Close()
}

// update author not working
func updateAuthor(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	params := mux.Vars(r)
	stmt, err := db.Prepare("UPDATE author SET Firstname=?,Lastname = ?,Age=?,Rating=? WHERE auid = ?")
	if err != nil {
		panic(err.Error())
	}
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		panic(err.Error())
	}
	keyVal := make(map[string]string)
	json.Unmarshal(body, &keyVal)
	firstname := keyVal["firstname"]
	lastname := keyVal["lastname"]
	age := keyVal["age"]
	rating := keyVal["rating"]
	_, err = stmt.Exec(firstname, lastname, age, rating, params["id"])
	if err != nil {
		panic(err.Error())
	}
	json.NewEncoder(w).Encode(books)
	defer db.Close()
}

// delete author
func deleteAuthor(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	params := mux.Vars(r)
	stmt, err := db.Prepare("DELETE FROM Author WHERE auid = ?")
	if err != nil {
		panic(err.Error())
	}
	_, err = stmt.Exec(params["id"])
	if err != nil {
		panic(err.Error())
	}
	defer db.Close()
}

// Book by author id
func getBookAuthorById(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	params := mux.Vars(r)
	selDB, err := db.Query("SELECT * FROM Book WHERE auid=?", params["id"])
	if err != nil {
		panic(err.Error())
	}

	for selDB.Next() {
		var book Book
		err = selDB.Scan(&book.ID, &book.Isbn, &book.Title, &book.auid)
		if err != nil {
			panic(err.Error())
		}
		json.NewEncoder(w).Encode(book)
	}
	defer db.Close()
}

//find books with author
func getBookAuthor(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	db := dbConn()
	selDB, err := db.Query("SELECT b.Id,b.Isbn,b.Title,a.Firstname,a.Lastname,a.Age,a.Rating FROM Book AS b join Author AS a on b.auid=a.auid")
	if err != nil {
		panic(err.Error())
	}
	book := &Book{}
	for selDB.Next() {
		author := &Author{}
		err = selDB.Scan(&book.ID, &book.Isbn, &book.Title, &author.Firstname, &author.Lastname, &author.Age, &author.Rating)
		if err != nil {
			panic(err.Error())
		}
		//json.NewEncoder(w).Encode(book)
	}
	defer db.Close()
}

func main() {

	r := mux.NewRouter()

	//Route Handler Book
	r.HandleFunc("/api/books", getBooks).Methods("GET")
	r.HandleFunc("/api/book/{id}", getBook).Methods("GET")
	r.HandleFunc("/api/book", createBooks).Methods("POST")
	r.HandleFunc("/api/book/{id}", updateBooks).Methods("PUT")
	r.HandleFunc("/api/book/{id}", deleteBooks).Methods("Delete")

	//Route Handler Author
	r.HandleFunc("/api/authors", getAuthors).Methods("GET")
	r.HandleFunc("/api/author/{id}", getAuthor).Methods("GET")
	r.HandleFunc("/api/author", createAuthor).Methods("POST")
	r.HandleFunc("/api/author/{id}", updateAuthor).Methods("PUT")
	r.HandleFunc("/api/author/{id}", deleteAuthor).Methods("Delete")

	//Route Handler others
	r.HandleFunc("/api/book/author/{id}", getBookAuthorById).Methods("GET")
	r.HandleFunc("/api/book/author", getBookAuthor).Methods("GET")
	log.Fatal(http.ListenAndServe(":8000", r))
}
