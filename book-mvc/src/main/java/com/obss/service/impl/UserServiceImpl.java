package com.obss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.obss.dao.UserDao;

import com.obss.model.User;
import com.obss.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	public User getUser(String userName) {
		return userDao.getUser(userName);
	}

	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	public User updateUser(String userName, User user) {
		return userDao.updateUser(userName, user);
	}

	public void deleteUser(String userName) {
		userDao.deleteUser(userName);
		
	}

}
