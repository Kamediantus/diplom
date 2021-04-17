package ru.rodichev.webBlog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rodichev.webBlog.entity.Comment;
import ru.rodichev.webBlog.logic.CurrDate;
import ru.rodichev.webBlog.entity.Note;
import ru.rodichev.webBlog.logic.SearchFromRepo;
import ru.rodichev.webBlog.repo.CommentRepository;
import ru.rodichev.webBlog.repo.NotesRepository;

import java.util.*;

@Controller
public class NoteController {


    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/notes")
    public String blog(Model model){
        Iterable<Note> notes = notesRepository.getOnlyChecked();
        model.addAttribute("notes", notes);
        return "note/mainNotes";
    }

    @PostMapping("/notes")
    public String searchNotes(@RequestParam String text, @RequestParam String tag, Model model){
        if(text != ""){
            Iterable<Note> notes = notesRepository.reverseFindByText(SearchFromRepo.toLike(text));
            model.addAttribute("notes", notes);
        } else if(tag != ""){
            Iterable<Note> notes = notesRepository.reverseFindByTag(SearchFromRepo.toLike(tag));
            model.addAttribute("notes", notes);
        } else if (text == "" && tag == ""){
            model.addAttribute("msg", "Please choose at least one parameter for search");
        } return "note/mainNotes";
    }

    @GetMapping("/notes/add")
    public String addNote(Model model){
        return "note/newNote";
    }

    @PostMapping("/notes/add")
    public String submitNote(@RequestParam String heading, @RequestParam String fullText, @RequestParam String tags,  Model model){
        Note notes = new Note(heading, fullText, tags);
        notesRepository.save(notes);
        return "redirect:/notes";
    }


    @GetMapping("/notes/{id}")
    public String fullNote(@PathVariable(value = "id") long id, Model model){
        if(notesRepository.existsById(id)) {
            Optional<Note> notes = notesRepository.findById(id);
            ArrayList<Note> res = new ArrayList<>();
            notes.ifPresent(res::add);
            model.addAttribute("note", res);
            List<String> listOfTags = SearchFromRepo.parseTagsAsList(notesRepository.getTagsById(id));
            listOfTags.replaceAll(s -> s.trim());
            model.addAttribute("tags", listOfTags);
            Iterable<Comment> comments = commentRepository.reverseFindById(id);
            model.addAttribute("comments", comments);
            return "note/noteDetails";
        }
        else return "redirect:/notes";
    }

    @GetMapping("/notes/search/{tag}")
    public String searchTag(@PathVariable(value = "tag") String tag, Model model){
        Iterable<Note> notes = notesRepository.reverseFindByTag(SearchFromRepo.toLike(tag));
        model.addAttribute("notes", notes);
        return "note/mainNotes";
    }

    @PostMapping("/notes/{id}")
    public String addComment(@PathVariable(value = "id") long id,@RequestParam String fullComment, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Comment comment = new Comment(id, auth.getName(), fullComment, CurrDate.getCurrDate());
        commentRepository.save(comment);
        Optional<Note> notes = notesRepository.findById(id);
        ArrayList<Note> res = new ArrayList<>();
        notes.ifPresent(res::add);
        model.addAttribute("note", res);
        Iterable<Comment> comments = commentRepository.reverseFindById(id);
        model.addAttribute("comments", comments);
        return "note/noteDetails";
    }

    @GetMapping("/notes/edit/{id}")
    public String editNote(@PathVariable(value = "id") long id, Model model){
        if(notesRepository.existsById(id)) {
            Optional<Note> notes = notesRepository.findById(id);
            ArrayList<Note> res = new ArrayList<>();
            notes.ifPresent(res::add);
            model.addAttribute("note", res);
            return "note/editNote";
        }
        else return "redirect:/notes";
    }

    @PostMapping("/notes/edit/{id}")
    public String updateNote(@PathVariable(value = "id") long id, @RequestParam String heading, @RequestParam String fullText, @RequestParam String tags,  Model model) {
        if (notesRepository.existsById(id)) {
            Note notes = notesRepository.findById(id).orElseThrow();
            notes.setHeading(heading);
            notes.setFinalFullText(notes.toHtmlBreakLines(fullText));
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
