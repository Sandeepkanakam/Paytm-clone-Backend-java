package com.example.LibrarayManagement.repository;

import com.example.LibrarayManagement.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Integer> {

    Author findByEmail(String email);

}
