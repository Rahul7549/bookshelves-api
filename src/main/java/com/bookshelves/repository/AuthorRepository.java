package com.bookshelves.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshelves.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{

}
