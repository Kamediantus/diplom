package ru.rodichev.webBlog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.models.Notes;
import ru.rodichev.webBlog.repo.NotesRepository;

@Controller
public class NotesController {


    @Autowired
    private NotesRepository notesRepository;

    @GetMapping("/notes")
    public String blog(Model model){
        Iterable<Notes> notes = notesRepository.findAll();
        model.addAttribute("notes", notes);
        return "mainNotes";
    }
    @GetMapping("/blog/add")
    public String addNote(Model model){
        return "newNote";
    }

    @PostMapping("/blog/add")
    public String submitNote(@RequestParam String heading, @RequestParam String fullText, @RequestParam String tags,  Model model){
        Notes notes = new Notes(heading, fullText, tags);
        notesRepository.save(notes);
        return "redirect:/notes";
    }

    @GetMapping("/blog/add/{id}")
    public String fullNote(Model model){
        return "fullNote";
    }

}
