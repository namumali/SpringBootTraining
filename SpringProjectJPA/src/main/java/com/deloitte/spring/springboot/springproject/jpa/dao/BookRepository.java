package com.deloitte.spring.springboot.springproject.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.springboot.springproject.jpa.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	

}
