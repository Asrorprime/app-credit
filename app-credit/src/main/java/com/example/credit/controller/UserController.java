package com.example.credit.controller;

import com.example.credit.model.User;
import com.example.credit.repository.UserRepository;
import com.example.credit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    RestTemplate restTemplate;

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> create(@RequestBody User user) {
        Optional<User> name = userRepository.findByUsername(user.getUsername());
        Optional<User> phone = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (name.isPresent()) {
            return ResponseEntity.ok("Bunday nomli foydalanuvchi mavjud!");
        } else if (phone.isPresent()) {
            return ResponseEntity.ok("Bunday telefon raqamli foydalanuvchi mavjud!");
        } else {
            userService.saveUser(user);
            return ResponseEntity.ok("Foydalanuvchi saqlandi!");
        }
    }

    @GetMapping("/get-users")
    public ResponseEntity getUsers() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userService.delete(id);
        } else {
            return ResponseEntity.ok("Foydalanuvchi topilmadi!");
        }
        return ResponseEntity.ok("Muvoffiqiyatli o'chirildi!");
    }


}
