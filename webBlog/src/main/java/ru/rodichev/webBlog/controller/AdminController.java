package ru.rodichev.webBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.entity.Role;
import ru.rodichev.webBlog.entity.User;
import ru.rodichev.webBlog.repo.UserRepository;
import ru.rodichev.webBlog.service.UserService;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String  gtUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "userEdit";
    }

    @PostMapping("/admin/edit/{id}")
    public String  updateUser(@PathVariable("id") Long id,@RequestParam String role, Model model) {
        User user = userService.findUserById(id);
        user.setRole(Role.valueOf(role));
        userRepository.save(user);
        model.addAttribute("user", userService.findUserById(id));
        return "userEdit";
    }



    @PostMapping("/admin/edit/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model){
        if (userService.deleteUser(id)) {
            String msg = "User was deleted successfully. id: " + id;
            model.addAttribute("message",msg);

        } else{
            String msg = "User wasn't deleted successfully. id: " + id;
        }
            return "userDelete";
    }
}


