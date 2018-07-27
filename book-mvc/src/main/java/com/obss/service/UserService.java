package com.obss.service;

import com.obss.model.User;

public interface UserService {
	public User getUser(String userName);

	public User saveUser(User user);

	public User updateUser(String userName, User user);

	public void deleteUser(String userName);

}
