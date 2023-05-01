package com.deloitte.spring.springboot.springproject.jpa.service;

import java.util.List;

import com.deloitte.spring.springboot.springproject.jpa.entity.Book;

public interface BookService {


	List<Book> getAllBooks ();
	
	Book getBookById(long id);
	
	Book saveBook (Book book);
	
	void deleteBook (long id);
}