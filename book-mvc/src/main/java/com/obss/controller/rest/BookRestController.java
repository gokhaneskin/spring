package com.obss.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obss.model.Book;
import com.obss.service.BookService;

@RestController
@RequestMapping("/book")
public class BookRestController {
	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> get(){
		return bookService.get();
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {
		System.out.println("GET Book");
		return bookService.getBook(id);
	}

	@PostMapping
	public void addBook(@RequestBody Book book) {
		System.out.println("POST Book");
		bookService.saveBook(book);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id,@RequestBody Book book)	{
			System.out.println("PUT Book");
			return bookService.updateBook(id, book);
	}
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		System.out.println("DELETE Book");
		bookService.deleteBook(id);
	}
}
