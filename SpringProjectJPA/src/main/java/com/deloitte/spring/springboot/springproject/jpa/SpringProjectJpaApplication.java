package com.deloitte.spring.springboot.springproject.jpa;

import org.springframework.boot.SpringApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.deloitte.spring.springboot.springproject.jpa.service.BookService;
import com.deloitte.spring.springboot.springproject.jpa.entity.Book;

@SpringBootApplication
public class SpringProjectJpaApplication {
	

	public static void main(String[] args) {
		
		ApplicationContext appContext = SpringApplication.run(SpringProjectJpaApplication.class, args);
		BookService bookService = appContext.getBean(BookService.class);
		
		// Creating Scanner Object to read input
        Scanner input = new Scanner(System.in);
        
		//Menu 
		System.out.println("MENU");
        System.out.println("1: Display List of all books");
        System.out.println("2: Add a new book");
        System.out.println("3: Update an existing book");
        System.out.println("4: Delete a book");
        System.out.println("5: Exit program");
        System.out.print("Enter your selection : ");
 
        int option = 0;
        
     // Do - While loop
        do {
            
            option = input.nextInt();
 
            // Switch case
            switch (option) {
 
            // Case 1
            case 1:
               List<Book> book = bookService.getAllBooks();
               System.out.println(book);
               
                break;
 
            // Case 2
            case 2:
            	System.out.println("Enter the book title:");
            	String title = input.next();
            	System.out.println("Enter the book price:");
            	BigDecimal price = input.nextBigDecimal();
            	System.out.println("Enter the book author:");
            	String author = input.next();
            	System.out.println("Enter the book Publication Date(like DD/MM/YYYY):");
    			String pDate = input.next();
    			String[] array1 = pDate.split("/");
    			int day = Integer.parseInt(array1[0]);
    			int month = Integer.valueOf(array1[1]);
    			int year = Integer.parseInt(array1[2]);			
    			LocalDate publicationDate = LocalDate.of(year, month, day);
    			Book book1 = new Book(title,author,price,publicationDate);
    		    Book b = bookService.saveBook(book1);
    		    System.out.println("Book Added sucessfully" + " " + b);
    		    
    		    
                break;
 
            // Case 3
            case 3:
            	System.out.println("Enter the book id to update:");
            	long bookId = input.nextLong();
            	Book bDisplay =bookService.getBookById(bookId);
            	System.out.println(bDisplay);
            	System.out.println("Enter the book title:");
            	String title1 = input.next();
            	System.out.println("Enter the book price:");
            	BigDecimal price1 = input.nextBigDecimal();
            	System.out.println("Enter the book author:");
            	String author1 = input.next();
            	System.out.println("Enter the book Publication Date(like DD/MM/YYYY):");
    			String pDate1 = input.next();
    			String[] array2 = pDate1.split("/");
    			int day1 = Integer.parseInt(array2[0]);
    			int month1 = Integer.parseInt(array2[1]);;
    			int year1 = Integer.parseInt(array2[2]);			
    			LocalDate publicationDate1 = LocalDate.of(year1, month1, day1);
    			
    			Book book2 = new Book(title1,author1,price1,publicationDate1);
    			Book b1 = bookService.saveBook(book2);
    			System.out.println("Book Updated sucessfully" + " " + b1);
    			
    			
                break;
 
            // Case 4
            case 4:
            	System.out.println("Enter the id of book to delete");
            	long bookId1 = input.nextLong();
                bookService.deleteBook(bookId1);
                System.out.println("Book deleted sucessfully");
 
                List<Book> b2 = bookService.getAllBooks();
                System.out.println(b2);
                break;
 
            // Case 5
            case 5:
            	System.out.println(
                        "\n Thank you for using the program. Goodbye!\n");
                    System.exit(0);
                break;
 
            // Case 6: Default case
            default:

                System.out.println("\nInvalid input\n");
                break;
 
            }
            }
        
 
        // Checking condition
        while (option != 6) ;
        	
        input.close();
        }
    }
        
	
