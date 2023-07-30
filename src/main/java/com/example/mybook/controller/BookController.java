package com.example.mybook.controller;

import com.example.mybook.entity.Book;
import com.example.mybook.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.listAllBooks());
        return "books";
    }

    @GetMapping("/books/new")
    public String createNewBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "create_book";
    }

    @PostMapping("/books")
    public String saveBooks(@ModelAttribute("book")Book book) {
        bookService.saveBooks(book);
        return "redirect:/books";
    }

    @GetMapping("books/edit/{id}")
    public String updateBooks(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "books_edit_form";
    }

    @PostMapping("/books/{id}")
    public String findById(@PathVariable int id, @ModelAttribute("book")Book book, Model model) {
        Book existBook = bookService.findById(id);
        existBook.setId(book.getId());
        existBook.setTitle(book.getTitle());
        existBook.setPublisher(book.getPublisher());
        existBook.setPrice(book.getPrice());

        bookService.updateBooks(existBook);

        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String deleteBooksById(@PathVariable int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
