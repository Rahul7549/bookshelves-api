package com.bookshelves.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookshelves.exception.ResourceNotFoundException;
import com.bookshelves.model.Book;
import com.bookshelves.repository.AuthorRepository;
import com.bookshelves.repository.BookRepository;


@Service
public class BookServiceImp {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired 
	AuthorRepository authorRepository;
	
	public ResponseEntity<?> getAllBook(){
		List<Book> bookList=bookRepository.findAll();
		if(!bookList.isEmpty()) {
			return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("No Book Available",HttpStatus.NOT_FOUND);
		}	
	}
	
	public ResponseEntity<Book> createBook(Long authorId,Book newBook){				
			Book book =authorRepository.findById(authorId).map(author ->{
				newBook.setAuthor(author);
				return bookRepository.save(newBook); 
			}).orElseThrow(() -> new ResourceNotFoundException("Not found Author with id = "+ authorId));			
		
			return new ResponseEntity<>(book, HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<Book> updateBook(Long bookId,Book newBook){
		Book book=bookRepository.findById(bookId)
		.orElseThrow(()-> new ResourceNotFoundException("Not found Book with id = "+bookId));
		book.setBookName(newBook.getBookName());
		book.setBookPrize(newBook.getBookPrize());
		book.setDescriptio(newBook.getDescriptio());
		book.setWrittenIn(newBook.getWrittenIn());
		return new ResponseEntity<>(bookRepository.save(book),HttpStatus.CREATED);
	}

	
	public ResponseEntity<?> deletBook(Long bookId) {
		 Book book= bookRepository.findById(bookId)
				 .orElseThrow(()->new ResourceNotFoundException("Not found Book with id = "+ bookId));
		bookRepository.deleteById(book.getBookid());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	
	public ResponseEntity<?> getBookById(Long bookId){
		Book book=bookRepository.findById(bookId)
				.orElseThrow(()->new ResourceNotFoundException("Not found Book with id = "+ bookId));
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
}
