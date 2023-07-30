package com.example.mybook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    private String authorName;
    private String publisher;
    private double price;

    public Book() {}

    public Book(String title, String authorName, String publisher, double price) {
        this.title = title;
        this.authorName = authorName;
        this.publisher = publisher;
        this.price = price;
    }

    @ManyToOne
    private Author author;
}
