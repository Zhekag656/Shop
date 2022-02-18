package com.courseshop.Shop.Repository;

import com.courseshop.Shop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
