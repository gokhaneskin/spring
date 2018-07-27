package com.obss.dao;

import java.util.List;

import com.obss.model.Author;

public interface AuthorDao {
	public Author getAuthor(long authorID);
	public Author saveAuthor(Author author);
	public Author updateAuthor(Long authorID,Author author);
	public void deleteAuthor(Long authorID);
	public List<Author> get();
}
