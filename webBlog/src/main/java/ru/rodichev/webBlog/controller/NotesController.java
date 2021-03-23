package ru.rodichev.webBlog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.rodichev.webBlog.models.Notes;
import ru.rodichev.webBlog.repo.NotesRepository;

@Controller
public class NotesController {


    @Autowired
    private NotesRepository notesRepository;

    @GetMapping("/blog")
    public String blog(Model model){
        Iterable<Notes> notes = notesRepository.findAll();
        model.addAttribute("notes", notes);
        return "mainBlog";
    }
}
