package com.bookshelves.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshelves.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
