package ru.rodichev.webBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.entity.BlockOfSite;
import ru.rodichev.webBlog.entity.Role;
import ru.rodichev.webBlog.entity.User;
import ru.rodichev.webBlog.repo.BlockRepository;
import ru.rodichev.webBlog.repo.UserRepository;
import ru.rodichev.webBlog.service.UserService;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlockRepository blockRepository;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("user", userService.allUsers());
        return "admin/admin";
    }

    @PostMapping("/admin")
    public String searchUsers(@RequestParam(required = false) Long id, @RequestParam(required = false) String username, @RequestParam(required = false) String role,  Model model){
        if (id != null){
            if(userService.findUserById(id).getUsername() == null){
                model.addAttribute("message", "User with id: " + id + " wasn't found");

            } else
            model.addAttribute("user", userService.findUserById(id));
        } else if (username != ""){
            if(userService.findUserByUsernameLike(username).size() == 0){
                model.addAttribute("message", "User with username mask: '" + username + "%' wasn't found");
            }
            model.addAttribute("user", userService.findUserByUsernameLike(username));
        } else if (!role.equals("empty")) {
            model.addAttribute("user", userService.findUserByRole(role));
        } else model.addAttribute("message", "Please choose at least one parameter for search");
        return "admin/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String  gtUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "admin/userEdit";
    }

    @PostMapping("/admin/edit/{id}")
    public String  updateUser(@PathVariable("id") Long id,@RequestParam String role, Model model) {
        User user = userService.findUserById(id);
        user.setRole(Role.valueOf(role));
        userRepository.save(user);
        model.addAttribute("user", userService.findUserById(id));
        return "admin/userEdit";
    }

    @PostMapping("/admin/edit/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model){
        if (userService.deleteUser(id)) {
            String msg = "User was deleted successfully. id: " + id;
            model.addAttribute("message",msg);

        } else{
            String msg = "User wasn't deleted successfully. id: " + id;
        }
            return "admin/userDelete";
    }

    @GetMapping("/admin/edit_site")
    public String editWebsitePage(Model model){
        Iterable<BlockOfSite> mainInfos = blockRepository.findAll();
        model.addAttribute("blocks", mainInfos);
        return "admin/editSite";
    }

    @GetMapping("/admin/edit_site/{id}")
    public String editWebsitePage(@PathVariable("id") Long id, Model model){
        BlockOfSite blockOfSite = blockRepository.getBlockById(id);
        model.addAttribute("block", blockOfSite);
        return "admin/editBlock";
    }

    @PostMapping("/admin/edit_site/{id}")
    public String saveChanges(@PathVariable("id") Long id, String newText, Model model){
        BlockOfSite block = blockRepository.getBlockById(id);
        block.setPreviousFullText(block.getFullText());
        block.setFullText(newText);
        blockRepository.save(block);
        model.addAttribute("block", block);
        return "admin/editBlock";
    }
}


