package ru.rodichev.webBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.entity.User;
import ru.rodichev.webBlog.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String passwordConfirm, Model model) {
        if (!password.equals(passwordConfirm)){
            model.addAttribute("passwordError", "Password mismatch.");
            return "registration";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (!userService.saveUser(user)){
            model.addAttribute("usernameError", "A user with the same name already exists.");
            return "registration";
        }

        return "redirect:/";
    }
}