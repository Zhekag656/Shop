package com.courseshop.Shop.Service;

import com.courseshop.Shop.DTO.UserDTO;
import com.courseshop.Shop.Repository.UserRepo;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);

    void deleteUser(Integer userId);

    UserDTO findByLogin(String login);

    List<UserDTO> findAll();
}
