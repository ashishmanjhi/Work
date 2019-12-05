package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Author;

// Author Repository
public interface AuthorDao extends JpaRepository<Author, Integer>{

}
