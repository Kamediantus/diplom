package ru.rodichev.webBlog.controller;


import org.apache.coyote.*;
import org.json.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import ru.rodichev.webBlog.repo.*;

@Controller
public class MockController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping ("/singIn")
    public ResponseEntity postLogin(@RequestBody String creds, Model model) {
        JSONObject usersCreds = new JSONObject(creds);
        String email = usersCreds.getString("email");
        String password = usersCreds.getString("password");
        if (true) {
            return new ResponseEntity<String>("Welcome", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Bad credentials", HttpStatus.CONFLICT);
    }

    @GetMapping ("/test")
    public String test(Model model) {
        int s = 2;
        return "loh";
    }
}
