package com.courseshop.Shop.Service;

import com.courseshop.Shop.Repository.UserRepo;

import java.util.List;

public interface UserService {
    UserRepo saveUser(UserRepo userRepo);
    void deleteUser(Integer userId);
    UserRepo findByLogin(String login);
    List<UserRepo> findAll();
}
