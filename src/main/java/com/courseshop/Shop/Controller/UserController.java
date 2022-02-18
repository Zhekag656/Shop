package com.courseshop.Shop.Controller;

import com.courseshop.Shop.DTO.UserDTO;
import com.courseshop.Shop.Entity.User;
import com.courseshop.Shop.Exceptions.ValidationException;
import com.courseshop.Shop.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Log
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public UserDTO saveUsers(@RequestBody UserDTO userDTO) throws ValidationException{
        log.info("Обробка збереження користувача: " + userDTO);
        return userService.saveUser(userDTO);
    }

    @GetMapping("/findAll")
    public List<UserDTO> findAllUsers(){
        log.info("Обробка запиту пошуку всіх користувачів");
        return userService.findAll();
    }

    @GetMapping("/findByLogin")
    public UserDTO findByLogin(@RequestParam String login){
        log.info("Обробка пошуку за логіном: " + login);
        return userService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id){
        log.info("Обробка запиту на видалення користувача: " + id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
