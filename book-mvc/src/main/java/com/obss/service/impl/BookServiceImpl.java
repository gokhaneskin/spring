package com.obss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.obss.dao.BookDao;
import com.obss.model.Book;
import com.obss.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;
	
	public Book getBook(Long bookID) {
		return bookDao.getBook(bookID);
	}

	public Book saveBook(Book book) {
		return bookDao.saveBook(book);
	}

	public Book updateBook(Long bookID, Book book) {
		return bookDao.updateBook(bookID, book);
	}

	public void deleteBook(Long bookID) {
		bookDao.deleteBook(bookID);
	}

	public List<Book> get() {
		// TODO Auto-generated method stub
		return bookDao.get();
	}

}
