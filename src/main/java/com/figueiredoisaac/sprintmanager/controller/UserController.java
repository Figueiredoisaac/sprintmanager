package com.figueiredoisaac.sprintmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.figueiredoisaac.sprintmanager.model.User;
import com.figueiredoisaac.sprintmanager.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
	    return userService.findAll();
	}

	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
	    Optional<User> user = userService.findByUsername(username);
	    if (user.isPresent()) {
	        return ResponseEntity.ok(user.get());
	    }
	    return ResponseEntity.notFound().build();
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
	    return userService.save(user);
	}

	@PutMapping("/{username}")
	public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
	    Optional<User> currentUser = userService.findByUsername(username);
	    if (currentUser.isPresent()) {
	        User updatedUser = currentUser.get();
	        updatedUser.setPassword(user.getPassword());
	        updatedUser.setEnabled(user.getEnabled());
	        return ResponseEntity.ok(userService.save(updatedUser));
	    }
	    return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable String username) {
	    Optional<User> user = userService.findByUsername(username);
	    if (user.isPresent()) {
	        userService.deleteByUsername(username);
	        return ResponseEntity.ok().build();
	    }
	    return ResponseEntity.notFound().build();
	}
}
