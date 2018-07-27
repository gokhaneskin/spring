package com.obss.model;

public class Book {
	private long bookID;
	private String title;
	private int page;
	private Author authorID;
	public long getBookID() {
		return bookID;
	}
	public void setBookID(long bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Author getAuthorID() {
		return authorID;
	}
	public void setAuthorID(Author authorID) {
		this.authorID = authorID;
	}
}
