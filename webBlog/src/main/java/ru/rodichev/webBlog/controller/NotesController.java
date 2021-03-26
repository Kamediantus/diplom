package ru.rodichev.webBlog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.models.Notes;
import ru.rodichev.webBlog.repo.NotesRepository;

import java.util.ArrayList;
import java.util.Optional;

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
    @GetMapping("/notes/add")
    public String addNote(Model model){
        return "newNote";
    }

    @PostMapping("/notes/add")
    public String submitNote(@RequestParam String heading, @RequestParam String fullText, @RequestParam String tags,  Model model){
        Notes notes = new Notes(heading, fullText, tags);
        notesRepository.save(notes);
        return "redirect:/notes";
    }

//    @GetMapping("/notes/{strId}")
//    public String fullNote(@PathVariable(value = "strId") String  strId, Model model){
//        long id = Long.parseLong(strId);
//        Optional<Notes> notes = notesRepository.findById((long)id);
//        ArrayList<Notes> res = new ArrayList<>();
//        notes.ifPresent(res::add);
//        model.addAttribute("note", res);
//        return "noteDetails";
//    }

    @GetMapping("/notes/{id}")
    public String fullNote(@PathVariable(value = "id") long id, Model model){
        if(notesRepository.existsById(id)) {
            Optional<Notes> notes = notesRepository.findById(id);
            ArrayList<Notes> res = new ArrayList<>();
            notes.ifPresent(res::add);
            model.addAttribute("note", res);
            return "noteDetails";
        }
        else return "redirect:/notes";
    }

}
