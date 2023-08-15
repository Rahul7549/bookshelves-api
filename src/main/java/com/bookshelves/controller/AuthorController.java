package com.bookshelves.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bookshelves.serviceImp.AuthorServiceImp;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
@Transactional
public class AuthorController {

	
	@Autowired
	AuthorServiceImp authorServiceImp;
	
	@GetMapping("/author")
	public ResponseEntity<?> getAllAuthor(){
		return authorServiceImp.getAllAuthor();
	}
	
	@PostMapping("/author")
	public ResponseEntity<?> createAuthor(@RequestBody Author newAuthor){
		return authorServiceImp.createAuthor(newAuthor);
	}
	
	
	@PutMapping("/author/{authorId}")
	public ResponseEntity<?> updateAuthor(@PathVariable Long authorId,@RequestBody Author newAuthor){
		return authorServiceImp.updateAuthor(newAuthor, authorId);
	}
	
	@DeleteMapping("/author/{authorId}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long authorId){
		return authorServiceImp.deleteAuthor(authorId);
	}
	
	@GetMapping("/author/{authorId}")
	public ResponseEntity<?> getAuthorById(@PathVariable Long authorId){
		return authorServiceImp.getAuthorById(authorId);
	}
}
