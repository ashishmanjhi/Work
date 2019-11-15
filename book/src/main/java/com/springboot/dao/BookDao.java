package com.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.model.Book;

public interface BookDao extends JpaRepository<Book, Integer>{
	
	public List<Book> findByAuthorAge(Integer age);

	public List<Book> findByAuthorAuname(String auname);

	public List<Book> findByAuthorAuid(Integer auid);

	public List<Book> findByAuthorAurating(Float rating);

	public Optional<Book> findByBkrating(Float bkrating);
	
	public List<Book> findByPriceLessThanAndAuthorAuratingGreaterThan(Integer price,Float rating);
	
	
	
	
//	@Query(value="SELECT *  FROM book left join author ON author.auid=book.author_auid WHERE book.price < :price and author.aurating > :aurating",nativeQuery=true)
//	public List<Book> findAllBooks(@Param(value = "price") int price,@Param(value = "aurating") float aurating);
	

}
