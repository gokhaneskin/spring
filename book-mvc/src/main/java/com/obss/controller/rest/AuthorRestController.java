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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.obss.model.Author;

import com.obss.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorRestController {
	@Autowired
	private AuthorService authorService;

	@GetMapping
	public List<Author> get() {
		return authorService.get();
	}

	@GetMapping("/{id}")
	public Author getAuthor(@PathVariable Long id) {
		System.out.println("---GET author" + id);
		return authorService.getAuthor(id);
	}

	@PostMapping
	public void addAuthor(@RequestBody Author author) {
		System.out.println("POST Author");
		authorService.saveAuthor(author);
	}

	@PutMapping("/{id}")
	public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
		System.out.println("PUT Author");
		return authorService.updateAuthor(id, author);
	}

	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable Long id) {
		System.out.println("DELETE Author");
		authorService.deleteAuthor(id);
	}
}
