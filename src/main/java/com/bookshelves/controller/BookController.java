package com.bookshelves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelves.model.Author;
import com.bookshelves.model.Book;
import com.bookshelves.serviceImp.AuthorServiceImp;
import com.bookshelves.serviceImp.BookServiceImp;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api")
@Transactional
public class BookController {
	
	@Autowired
	BookServiceImp bookServiceImp;
	
	
 
	@GetMapping("/book")
	public ResponseEntity<?> getAllBook(){
		return bookServiceImp.getAllBook();
	}
	
	
	@PostMapping("/book/{authorId}")
	public ResponseEntity<?> createBook(@PathVariable Long authorId, @RequestBody Book newBook){
		return bookServiceImp.createBook(authorId,newBook);
	}
	
	@PutMapping("/book/{bookId}")
	public ResponseEntity<?> updateBook(@PathVariable Long bookId ,@RequestBody Book newBook){
		return bookServiceImp.updateBook(bookId,newBook);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteBook(Long BookId){
		return bookServiceImp.deletBook(BookId);
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable Long bookId){
		return bookServiceImp.getBookById(bookId);
	}
	
}
