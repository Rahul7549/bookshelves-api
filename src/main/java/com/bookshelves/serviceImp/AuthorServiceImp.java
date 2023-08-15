package com.bookshelves.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookshelves.exception.ResourceNotFoundException;
import com.bookshelves.model.Author;
import com.bookshelves.repository.AuthorRepository;

@Service
public class AuthorServiceImp {

	
	@Autowired
	AuthorRepository authorRepository;
	
	
	public ResponseEntity<?> getAllAuthor(){
		List<Author> authorList=authorRepository.findAll();
		if(!authorList.isEmpty()) {
			return new ResponseEntity<>(authorList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No Author available",HttpStatus.NO_CONTENT);
		}
	}
	
	
	public ResponseEntity<?> createAuthor(Author newAuthor){
		Author author=authorRepository.save(
				new Author(newAuthor.getAuthorid(),newAuthor.getAuthorname(),newAuthor.getAuthoraddress()));
				return new ResponseEntity<>(author,HttpStatus.OK);
	}
	
	
	public ResponseEntity<?> updateAuthor(Author newAuthor,Long authorId){
		Author updatedAuthor=authorRepository.findById(authorId)
				.map(author->{
					author.setAuthoraddress(newAuthor.getAuthoraddress());
					author.setAuthorname(newAuthor.getAuthorname());
					author.setUpdatedOn(newAuthor.getUpdatedOn());
					return authorRepository.save(author);
				})
				.orElseThrow(() -> new ResourceNotFoundException("No Author available with Id -"+authorId));
		return new ResponseEntity<>(updatedAuthor,HttpStatus.OK);
	}
	
	public ResponseEntity<?> deleteAuthor(Long authorId){
		authorRepository.findById(authorId)
		.orElseThrow(() -> new ResourceNotFoundException("No Author available with Id -"+authorId));
		authorRepository.deleteById(authorId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	public ResponseEntity<?> getAuthorById(Long authorId) {
		Author author=authorRepository.findById(authorId)
				.orElseThrow(()-> new ResourceNotFoundException("No Author available with Id -"+authorId));
		return new ResponseEntity<>(author,HttpStatus.OK);
	}
}
