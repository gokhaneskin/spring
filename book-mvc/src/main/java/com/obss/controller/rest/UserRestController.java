package com.obss.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obss.model.User;
import com.obss.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	private UserService userService;

	@GetMapping("/{userName}")
	public User getUser(@PathVariable String userName) {
		System.out.println("getuser method -id:" + userName);
		return userService.getUser(userName);
	}

	@PostMapping
	public void addUser(@RequestBody User user) {
		System.out.println("getuser method -:" + user);
		userService.saveUser(user);

	}

	@PutMapping("/{userName}")
	public User updateUser(@PathVariable String userName, @RequestBody User user) {
		System.out.println("updateUser method -:" + user);
		return userService.updateUser(userName, user);
	}

	@DeleteMapping("/{userName}")
	public void deleteUser(@PathVariable String userName) {
		System.out.println("updateUser method" );
		userService.deleteUser(userName);
	}
}
