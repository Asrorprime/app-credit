package com.example.credit.dto;

import com.example.credit.model.User;
import com.example.credit.model.enums.Gender;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String userLastName;
    private String password;
    private String email;
    private String phoneNumber;
    private Gender gender;

    public UserDto(User user) {
        setId(user.getId());
        setUsername(user.getUsername());
        setUserLastName(user.getUserLastName());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        setPhoneNumber(user.getPhoneNumber());
        setGender(user.getGender());
    }

    public User convertToUser() {
        User user = new User();
        return convertToUser(user);
    }

    public User convertToUser(User user) {
        if (id != null)
            user.setId(id);
        user.setUsername(username);
        user.setUserLastName(userLastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setGender(gender);
        return user;
    }

}
