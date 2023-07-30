package com.example.mybook.repository;

import com.example.mybook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author , Integer> {
}
