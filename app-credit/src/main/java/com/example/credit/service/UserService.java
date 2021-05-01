package com.example.credit.service;

import com.example.credit.model.User;
import com.example.credit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
    }

}
