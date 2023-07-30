package com.example.mybook.service;

import com.example.mybook.entity.Book;
import com.example.mybook.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBooks(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    public Book updateBooks(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
