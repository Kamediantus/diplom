package ru.rodichev.webBlog.controller;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.repo.UserRepository;
import ru.rodichev.webBlog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    private UserRepository userRepository;

    @GetMapping("/")
    public String homepage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String roles = auth.getDetails().toString();
            String currentUsername = auth.getName();
            model.addAttribute("user", currentUsername);
            model.addAttribute("roles", roles);
        }
        return "homePage";
    }
    @GetMapping("/contacts")
    public String contacts(Model model){
        return "contacts";
    }
    @GetMapping("/aboutMe")
    public String aboutMe(Model model){
        return "aboutMe";
    }

    @GetMapping("/login")
    public String login(Model model){return "login";}

    @PostMapping("/login")
    public String postLogin(@RequestParam String username, @RequestParam String password, Model model){
        model.addAttribute("loginError", "Incorrect username or password.");
        if(userRepository.findByUsername(username)!=null){
            UserService userService = new UserService();
            userService.loadUserByUsername(username);
            return "redirect: /";
        } else {
            model.addAttribute("loginError", "Incorrect username or password.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect: /";
    }
}
