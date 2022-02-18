package com.courseshop.Shop.Service;

import com.courseshop.Shop.DTO.UserDTO;
import com.courseshop.Shop.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User fromUserDTOToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getLogin());
        return user;
    }

    public UserDTO fromUserToUserDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .login(user.getLogin())
                .email(user.getEmail())
                .build();
    }
}
