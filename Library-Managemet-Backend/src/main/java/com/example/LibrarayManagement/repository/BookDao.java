package com.example.LibrarayManagement.repository;

import com.example.LibrarayManagement.models.Book;
import com.example.LibrarayManagement.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
    // FindByAttr1(value)
    // Select * from book where attr1 = "value"

    List<Book> findByGenre(Genre genre);
    List<Book> findByName(String bookName);

    @Query("Select b from Book b, Author a where b.book_author.id = a.id and a.name = ?1")
    List<Book> findByAuthor_Name(String authorName);

}
