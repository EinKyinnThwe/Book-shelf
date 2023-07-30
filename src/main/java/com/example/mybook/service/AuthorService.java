package com.example.mybook.service;

import com.example.mybook.entity.Author;
import com.example.mybook.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    public Author saveAuthors(Author author) {
        return authorRepository.save(author);
    }

    public Author findById(int id) {
        return authorRepository.findById(id).get();
    }

    public Author updateAuthors(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }
}
