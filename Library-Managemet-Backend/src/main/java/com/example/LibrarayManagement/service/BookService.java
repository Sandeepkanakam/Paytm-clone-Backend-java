package com.example.LibrarayManagement.service;

import com.example.LibrarayManagement.models.Author;
import com.example.LibrarayManagement.models.Book;
import com.example.LibrarayManagement.models.Genre;
import com.example.LibrarayManagement.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookDao bookDao;

    public void createOrUpdateBook(Book book) {
        // Get or create the author using author details
        Author bookAuthor = authorService.getOrCreate(book.getBook_author());

        // set the author
        book.setBook_author(bookAuthor);

        // Save the book
        bookDao.save(book);
    }

    public List<Book> findBook(String searchKey, String searchValue) throws Exception {
        return switch (searchKey) {
            case "genre" -> bookDao.findByGenre(Genre.valueOf(searchValue));
            case "name" -> bookDao.findByName(searchValue);
            case "author_name" -> bookDao.findByAuthor_Name(searchValue);
            case "id" -> {
                Optional<Book> book = bookDao.findById(Integer.parseInt(searchValue));
                yield book.map(List::of).orElseGet(ArrayList::new);
            }
            default -> throw new Exception("Invalid search key: " + searchKey);
        };
    }
}
