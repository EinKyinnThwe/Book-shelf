package com.example.mybook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String email;

    public Author() {}

    public Author(String name, LocalDate dateOfBirth, String address, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
    }

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public void addBook(Book book) {
        books.add(book);
    }
}
