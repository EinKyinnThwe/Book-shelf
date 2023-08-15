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
    private String description;
    private String publisher;
    private double price;
    private String imaUrl;

    public Book() {}

    public Book(String title, String authorName, String description, String publisher, double price, String imaUrl) {
        this.title = title;
        this.authorName = authorName;
        this.description = description;
        this.publisher = publisher;
        this.price = price;
        this.imaUrl = imaUrl;
    }

    @ManyToOne
    private Author author;
}
