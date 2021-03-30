package ru.rodichev.webBlog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.logic.CurrDate;
import ru.rodichev.webBlog.entity.Notes;
import ru.rodichev.webBlog.repo.NotesRepository;

import java.util.*;

@Controller
public class NotesController {


    @Autowired
    private NotesRepository notesRepository;

    @GetMapping("/notes")
    public String blog(Model model){
        Iterable<Notes> notes = notesRepository.reverseFindAll();
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

    @GetMapping("/notes/edit/{id}")
    public String editNote(@PathVariable(value = "id") long id, Model model){
        if(notesRepository.existsById(id)) {
            Optional<Notes> notes = notesRepository.findById(id);
            ArrayList<Notes> res = new ArrayList<>();
            notes.ifPresent(res::add);
            model.addAttribute("note", res);
            return "editNote";
        }
        else return "redirect:/notes";
    }

    @PostMapping("/notes/edit/{id}")
    public String updateNote(@PathVariable(value = "id") long id, @RequestParam String heading, @RequestParam String fullText, @RequestParam String tags,  Model model) {
        if (notesRepository.existsById(id)) {
            Notes notes = notesRepository.findById(id).orElseThrow();
            notes.setHeading(heading);
            notes.setFullText(fullText);
            notes.setTags(tags);
            notes.setDate(CurrDate.getCurrDate());
            notesRepository.save(notes);
            return "redirect:/notes/{id}";
        }
        else return "redirect:/notes";
    }

    @GetMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable(value = "id") long id, Model model){
        if(notesRepository.existsById(id)) {
            notesRepository.delete(notesRepository.findById(id).orElseThrow());
            return "redirect:/notes";
        }
        else return "redirect:/notes";
    }

}
