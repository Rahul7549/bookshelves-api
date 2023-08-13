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
		
		
		
//		Author authorObjAuthor=new Author(121236,"Rahul12","bihar");
//		System.out.println( authorObjAuthor.getAuthorid()+" - "+authorObjAuthor.getAuthorname());
		Author author=authorRepository.save(newAuthor);
				return new ResponseEntity<>(author,HttpStatus.OK);
	}
	
}
