package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.AuthorDao;
import com.springboot.model.Author;


/** The AuthorController class provides methods to get author details.*/
/**
 * @author Ashish.manjhi
 *
 */
@RequestMapping("/author")
@RestController
public class AuthorController {

	@Autowired
	private AuthorDao authordao;

	/**This GetMapping method provides the list of all the authors in the database.*/
	/**
	 * @return author list
	 */
	@GetMapping(value = "/authors")
	public List<Author> getAuthor(){
		return authordao.findAll();
	}
	
	/**This PostMapping method creates a new author in the database.*/
	/**
	 * @param author
	 * @return 
	 */
	@PostMapping("/Author")
	public String createAuthor(@RequestBody List<Author> author) {
		authordao.saveAll(author);
		return "Author created:" + author.size();
	}

	/**This GetMapping method provides detail of an author with a particular id in the database.*/
	@GetMapping("/Author/{id}")
	public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable(value = "id") Integer bkid) {

		Optional<Author> bk = authordao.findById(bkid);

		if (bk == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bk);
	}
	
	/**This DeleteMapping method delete an authors with a particular id in the database.*/
	@DeleteMapping("/Author/{id}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable(value="id") Integer id){

		Optional<Author> bbb=authordao.findById(id);
		if(bbb==null) {
			return ResponseEntity.notFound().build();
		}
		authordao.deleteById(id);

		return ResponseEntity.ok().build();
	}
	
	/**This PutMapping method update the details of an authors with a particular id in the database.*/
	@PutMapping("/Author/{id}")
	public ResponseEntity<Author> createOrUpdateAuthor(@RequestBody Author author, @PathVariable Integer id)
	{	  
		Optional<Author> employee = authordao.findById(id);   
		if(employee.isPresent())
		{
			author.setAge(author.getAge());
			author.setAuname(author.getAuname());
			author.setAurating(author.getAurating());
			author = authordao.save(author);             
			return ResponseEntity.ok().build();
		} else {
			author = authordao.save(author);
			return ResponseEntity.notFound().build();
		}
	}
}
