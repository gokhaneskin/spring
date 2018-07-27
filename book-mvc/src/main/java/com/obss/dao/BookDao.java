package com.obss.dao;


import java.util.List;

import com.obss.model.Book;

public interface BookDao {
	public Book getBook(Long bookID);
	public Book saveBook(Book book);
	public Book updateBook(Long bookID,Book book);
	public void deleteBook(Long bookID);
	public List<Book> get();
}
