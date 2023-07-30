package com.example.mybook.controller;

import com.example.mybook.entity.Author;
import com.example.mybook.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String listAllAuthors(Model model) {
        model.addAttribute("authors", authorService.listAllAuthors());
        return "authors";
    }

    @GetMapping("/authors/new")
    public String createNewAuthors(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "create_author";
    }

    @PostMapping("/authors")
    public String saveAuthors(@ModelAttribute("author") Author author) {
        authorService.saveAuthors(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/edit/{id}")
    public String updateAuthors(@PathVariable int id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "authors_edit_form";
    }

    @PostMapping("/authors/{id}")
    public String findAuthorById(@PathVariable int id, @ModelAttribute("author")Author author, Model model) {
        Author exitAuthor = authorService.findById(id);
        exitAuthor.setId(author.getId());
        exitAuthor.setName(author.getName());
        exitAuthor.setDateOfBirth(author.getDateOfBirth());
        exitAuthor.setAddress(author.getAddress());
        exitAuthor.setEmail(author.getEmail());

        authorService.updateAuthors(exitAuthor);

        return "redirect:/authors";
    }

    @GetMapping("/authors/{id}")
    public String deleteAuthorById(@PathVariable int id) {
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
