package com.courseshop.Shop.Controller;

import com.courseshop.Shop.Entity.User;
import com.courseshop.Shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "login";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "login";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Користувач з таким ім'ям вже існує");
            return "login";
        }
        userService.saveUser(userForm);
        return "redirect:/login";
    }

}
