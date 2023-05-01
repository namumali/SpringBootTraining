package com.deloitte.spring.springboot.springproject.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor  
@Table(name="Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
	
    @Column(name="title")
    private String title;
    
    @Column(name="author")
    private String author;
    
    @Column(name="price")
    private BigDecimal price;
    
    @Column(name="publicationDate")
    private LocalDate publicationDate;
    
	public Book(String title, String author, BigDecimal price, LocalDate publicationDate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publicationDate = publicationDate;
	}
    
    
}
