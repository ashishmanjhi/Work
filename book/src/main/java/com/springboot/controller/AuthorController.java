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


	@RequestMapping("/author")
	@RestController
	public class AuthorController {
		
		@Autowired
		private AuthorDao authordao;
		
		@GetMapping(value = "/authors")
		public List<Author> getAuthor(){
			return authordao.findAll();
		}
		@PostMapping("/Author")
		public String createAuthor(@RequestBody List<Author> author) {
			authordao.saveAll(author);
			return "Author created:" + author.size();
		}
		
		@GetMapping("/Author/{id}")
		public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable(value = "id") Integer bkid) {

			Optional<Author> bk = authordao.findById(bkid);

			if (bk == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(bk);
		}
		
		@DeleteMapping("/Author/{id}")
		public ResponseEntity<Author> deleteAuthor(@PathVariable(value="id") Integer id){
			
			Optional<Author> bbb=authordao.findById(id);
			if(bbb==null) {
				return ResponseEntity.notFound().build();
			}
			 authordao.deleteById(id);
			
			return ResponseEntity.ok().build();
	     }
		
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
