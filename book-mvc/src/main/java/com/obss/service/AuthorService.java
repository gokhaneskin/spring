package com.obss.service;

import java.util.List;

import com.obss.model.Author;

public interface AuthorService {
	public Author getAuthor(Long authorID);

	public Author saveAuthor(Author author);

	public Author updateAuthor(Long authorID, Author author);

	public void deleteAuthor(Long authorID);
	public List<Author> get();
}
