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


@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookDao dao;
	
	@PostMapping("/Book")
	public String createBook(@RequestBody List<Book> books) {
		dao.saveAll(books);
		return "Book created:" + books.size();
	}
	
	@GetMapping("/Books")
	public List<Book> getBooks() {
		return (List<Book>) dao.findAll();
	}

	@GetMapping("/Book/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable(value = "id") Integer bkid) {

		Optional<Book> bk = dao.findById(bkid);

		if (bk == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bk);
	}
	
	@GetMapping("/Books/bkrating/{rating}")
	public ResponseEntity<Optional<Book>> getBookByRating(@PathVariable(value = "rating") Float bkrating) {

		Optional<Book> bk = dao.findByBkrating(bkrating);

		if (bk == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bk);
	}
	
	@DeleteMapping("/Book/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable(value="id") Integer bkid){
		
		Optional<Book> bbb=dao.findById(bkid);
		if(bbb==null) {
			return ResponseEntity.notFound().build();
		}
		((CrudRepository<Book, Integer>) dao).deleteById(bkid);
		
		return ResponseEntity.ok().build();
     }
	
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
	
	// Searching books by author age
	@GetMapping("/Books/Author-age/{age}")
	public List<Book> getBooksByAuthorAge(@PathVariable("age") Integer age){
		return dao.findByAuthorAge(age);
	}
	
	//Searching books by author name
	@GetMapping("/Books/Author-name/{name}")
	public List<Book> getBooksByAuthorName(@PathVariable("name") String name){
		return dao.findByAuthorAuname(name);
	}
	
	//Searching books by author id
	@GetMapping("/Books/Author-id/{id}")
	public List<Book> getBooksByAuthorId(@PathVariable("id")Integer id){
			return dao.findByAuthorAuid(id);
		}
		
		//Searching books by author rating
	@GetMapping("/Books/Author-rating/{rating}")
	public List<Book> getBooksByAuthorRating(@PathVariable("rating")Float rating){
			return dao.findByAuthorAurating(rating);
		}
	
	@GetMapping("/Books/{price}/Author/{aurating}")
	public List<Book> getBookPriceLessThanAndAuthorRatingGreaterThan(@PathVariable("price")Integer price,@PathVariable("aurating")Float aurating){
	return dao.findByPriceLessThanAndAuthorAuratingGreaterThan(price, aurating);
	}
	
//	@GetMapping("/Books/{price}/Author/{aurating}")
//	public List<Book> getAllBooksUnderPriceAndAboveAuthorRating(@PathVariable("price")Integer price,@PathVariable("aurating")Float aurating){
//		return dao.findAllBooks(price, aurating);
//	}
	
	
}
