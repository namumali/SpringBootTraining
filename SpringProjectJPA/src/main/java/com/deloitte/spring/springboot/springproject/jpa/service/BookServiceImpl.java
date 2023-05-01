package com.deloitte.spring.springboot.springproject.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.springboot.springproject.jpa.dao.BookRepository;
import com.deloitte.spring.springboot.springproject.jpa.entity.Book;
@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(long id) {
		 Optional<Book> bookById = bookRepository.findById(id);
		 Book book = bookById.isPresent() ? bookById.get():null;
		 return book;
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
		
	}

	@Override
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
		
	}

}
