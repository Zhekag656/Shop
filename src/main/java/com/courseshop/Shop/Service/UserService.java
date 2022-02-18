package com.courseshop.Shop.Service;

import com.courseshop.Shop.DTO.UserDTO;
import com.courseshop.Shop.Exceptions.ValidationException;
import com.courseshop.Shop.Repository.UserRepo;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO) throws ValidationException;

    void deleteUser(Integer userId);

    UserDTO findByLogin(String login);

    List<UserDTO> findAll();
}
