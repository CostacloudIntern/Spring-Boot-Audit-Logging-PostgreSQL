package com.postgresql.audit.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.audit.api.model.User;
import com.postgresql.audit.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
         User added_user = userRepository.save(user);
        return added_user;
    }

    public Optional<User> getUserByUserId(int userId) {
        return userRepository.findById(userId);

    }

}
