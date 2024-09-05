package com.unext.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unext.demo.model.Book;
//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {	
	List<Book> books = new ArrayList<>();
	
	public BookController() {
		books.add(new Book(10,"Spring in Action", 499.00));
		books.add(new Book(11,"Java in Action", 199.00));
		books.add(new Book(12,"Spring Primer", 399.00));
		books.add(new Book(13,"Kubernetes Essentials", 999.00));
	}
	
	@GetMapping
	public List<Book> getBooks(){
		return books;
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") int bookId) {
		return books.stream()
				.filter(book -> book.getBookId()== bookId)
				.findFirst()
				.get();
	}
	
	@PutMapping("/{bookId}")
	public Book updateBook(@PathVariable int bookId , @RequestBody Book otherBook) {
		Optional<Book> existingBook = books.stream()
				.filter(book -> book.getBookId() == bookId)
				.findFirst();
		
		if(existingBook.isPresent()) {
			Book updatedBook = existingBook.get();
			updatedBook.setTitle(otherBook.getTitle());
			updatedBook.setPrice(otherBook.getPrice());
			return updatedBook;
		}		
		return null;		
	}
	
	@PostMapping
	public boolean addBook(@RequestBody Book book) {
		boolean status = books.add(book);
		return status;		
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteBook(@PathVariable("id") int bookId ) {
		boolean status = books.removeIf(book -> book.getBookId()== bookId);
		return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
