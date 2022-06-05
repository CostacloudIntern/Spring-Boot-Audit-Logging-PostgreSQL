package com.postgresql.audit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.audit.api.model.User;
import com.postgresql.audit.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/add/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable(value = "userId") int userId) {
        return new ResponseEntity<>(userService.getUserByUserId(userId).get(), HttpStatus.OK);
    }

}
