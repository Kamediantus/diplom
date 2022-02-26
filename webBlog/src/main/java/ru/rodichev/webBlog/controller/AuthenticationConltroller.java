//package ru.rodichev.webBlog.controller;
//
//import org.json.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.rodichev.webBlog.entity.User;
//import ru.rodichev.webBlog.repo.UserRepository;
//import ru.rodichev.webBlog.service.UserService;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//public class AuthenticationConltroller {
//
//    @Autowired
//    private UserRepository userRepository;
////    @Autowired
////    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @GetMapping("/login")
//    public String login(Model model) {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String postLogin(@RequestBody String creds, Model model) {
////        JSONObject usersCreds = new JSONObject(creds);
////        String email = usersCreds.getString("email");
////        String password = usersCreds.getString("password");
////        if (userRepository.findByUsername(email) != null) {
////            User user = userRepository.findUserByUsername(email);
////            if (bCryptPasswordEncoder.matches(password, bCryptPasswordEncoder.encode(user.getPassword()))) {
////                model.addAttribute("passwordError", "Please enter correct password..");
////                return "login";
////            } else if (!bCryptPasswordEncoder.matches(password, bCryptPasswordEncoder.encode(user.getPassword()))) {
////                UserService userService = new UserService();
////                userService.loadUserByUsername(email);
////                return "redirect: /";
////            }
////
////        } else model.addAttribute("loginError", "incorrect username");
//        return "login";
//    }
//
//    @GetMapping("/logout")
//    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect: /";
//    }
//}
