package com.example.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.model.User;
import com.example.email.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:3000") // Replace with your React app's URL
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    private UserService userService;

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }
}


