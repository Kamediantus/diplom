package ru.rodichev.webBlog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.repo.UserRepository;
import ru.rodichev.webBlog.service.UserService;

@Controller
public class MainController {
    private UserRepository userRepository;

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("title", "Sweet home");
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
        if(userRepository.findByUsername(username)!=null){
            UserService userService = new UserService();
            userService.loadUserByUsername(username);
            return "redirect: /";
        } else model.addAttribute("loginError", "Incorrect username or password.");
        return "/login";
    }
}
