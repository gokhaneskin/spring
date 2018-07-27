package com.obss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.obss.dao.AuthorDao;
import com.obss.model.Author;
import com.obss.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	@Qualifier("authorDao")
	private AuthorDao authorDao;

	public Author getAuthor(Long authorID) {
		return authorDao.getAuthor(authorID);

	}

	public Author saveAuthor(Author author) {
		return authorDao.saveAuthor(author);
	}

	public Author updateAuthor(Long authorID, Author author) {
		return authorDao.updateAuthor(authorID, author);
	}

	public void deleteAuthor(Long authorID) {
		authorDao.deleteAuthor(authorID);

	}

	@Override
	public List<Author> get() {
		return authorDao.get();
	}

}
