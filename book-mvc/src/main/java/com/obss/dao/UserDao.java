package com.obss.dao;

import com.obss.model.User;

public interface UserDao {
	public User getUser(String userName);
	public User saveUser(User user);
	public User updateUser(String userName,User user);
	public void deleteUser(String userName);
}
