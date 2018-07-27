package com.obss.service;

import java.util.List;

import com.obss.model.Book;

public interface BookService {
	public Book getBook(Long bookID);

	public Book saveBook(Book book);

	public Book updateBook(Long bookID, Book book);

	public void deleteBook(Long bookID);
	
	public List<Book> get();
}
