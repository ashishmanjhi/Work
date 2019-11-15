package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="book", catalog = "book2")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bkid")
	private int bkid;
	
	@NotNull
	@Column(name = "bkname")
	private String bkname;
	
	@NotNull
	@Column(name = "bkrating")
	private float bkrating;
	
	@NotNull
	@Column(name = "price")
	private int price;
	
	@ManyToOne
	private Author author;
	

	public Book() {}


	public int getBkid() {
		return bkid;
	}
	public Book setBkid(int bk_id) {
		this.bkid = bk_id;
		return this;
	}
	public int getPrice() {
		return price;
	}
	public Book setPrice(int price) {
		this.price = price;
		return this;
	}
	
	public String getBkname() {
		return bkname;
	}
	public Book setBkname(String bk_name) {
		this.bkname = bk_name;
		return this;
	}
	public float getBkrating() {
		return bkrating;
	}
	public Book setBkrating(float bk_rating) {
		this.bkrating = bk_rating;
		return this;
	}
	
	@Override
	public String toString() {
		return "Book [bk_id=" + bkid + ", bk_name=" + bkname + ", bk_rating=" + bkrating + ", price=" + price
				+ "]";
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
