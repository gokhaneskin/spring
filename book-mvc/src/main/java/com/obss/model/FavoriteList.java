package com.obss.model;

public class FavoriteList {
	private User userID;
	private Book bookID;
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}
	public Book getBookID() {
		return bookID;
	}
	public void setBookID(Book bookID) {
		this.bookID = bookID;
	}
}
