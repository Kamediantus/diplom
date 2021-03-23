package ru.rodichev.webBlog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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

}
