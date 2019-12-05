package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.BookDao;
import com.springboot.model.Book;


/** The BookController class provides methods to get book details.*/
@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookDao dao;

	/**This PostMapping method creates a new book in the database.*/
	@PostMapping("/Book")
	public String createBook(@RequestBody List<Book> books) {
		dao.saveAll(books);
		return "Book created:" + books.size();
	}

	/**This GetMapping method provides the list of all the books in the database.*/
	@GetMapping("/Books")
	public List<Book> getBooks() {
		return (List<Book>) dao.findAll();
	}

	/**This GetMapping method provides detail of an book with a particular id in the database.*/
	@GetMapping("/Book/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable(value = "id") Integer bkid) {

		Optional<Book> bk = dao.findById(bkid);

		if (bk == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bk);
	}

	/**This GetMapping method provides detail of an book with a particular book rating in the database.*/
	@GetMapping("/Books/bkrating/{rating}")
	public List<Book> getBookByRating(@PathVariable(value = "rating") Float bkrating) {

		return  dao.findByBkrating((Float) bkrating);
	}

	/**This DeleteMapping method delete an book with a particular id in the database.*/
	@DeleteMapping("/Book/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable(value="id") Integer bkid){

		Optional<Book> bbb=dao.findById(bkid);
		if(bbb==null) {
			return ResponseEntity.notFound().build();
		}
		((CrudRepository<Book, Integer>) dao).deleteById(bkid);

		return ResponseEntity.ok().build();
	}
	
	/**This PutMapping method update the details of an book with a particular id in the database.*/
	@PutMapping("/Book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(value="id") Integer bkid,@RequestBody Book book){
		Optional<Book> bbb=dao.findById(bkid);

		if(bbb==null) 
		{	return ResponseEntity.notFound().build();   }

		book.setBkname(book.getBkname());
		book.setBkrating(book.getBkrating());
		book.setPrice(book.getPrice());
		book.setAuthor(book.getAuthor());		
		Book updateBook=dao.save(book);
		return ResponseEntity.ok().body(updateBook);
	}

	/**This GetMapping method provides detail of an books with a particular author age in the database.*/
	@GetMapping("/Books/Author-age/{age}")
	public List<Book> getBooksByAuthorAge(@PathVariable("age") Integer age){
		return dao.findByAuthorAge(age);
	}

	/**This GetMapping method provides detail of an books with a particular author name in the database.*/
	@GetMapping("/Books/Author-name/{name}")
	public List<Book> getBooksByAuthorName(@PathVariable("name") String name){
		return dao.findByAuthorAuname(name);
	}

	/**This GetMapping method provides detail of an book with a particular author id in the database.*/
	@GetMapping("/Books/Author-id/{id}")
	public List<Book> getBooksByAuthorId(@PathVariable("id")Integer id){
		return dao.findByAuthorAuid(id);
	}

	/**This GetMapping method provides detail of an book with a particular author rating in the database.*/
	@GetMapping("/Books/Author-rating/{rating}")
	public List<Book> getBooksByAuthorRating(@PathVariable("rating")Float rating){
		return dao.findByAuthorAurating(rating);
	}

	/**This GetMapping method provides detail of an book with book price less than and author rating greater than  in the database.*/
	@GetMapping("/Book/{price}/Author/{aurating}")
	public List<Book> getBookPriceLessThanAndAuthorRatingGreaterThan(@PathVariable("price")Integer price,@PathVariable("aurating")Float aurating){
		return dao.findByPriceLessThanAndAuthorAuratingGreaterThan(price, aurating);
	}
}
