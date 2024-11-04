package com.example.LibrarayManagement.controller;

import com.example.LibrarayManagement.dto.BookResponse;
import com.example.LibrarayManagement.dto.CreateBookRequest;
import com.example.LibrarayManagement.dto.SearchBookResponse;
import com.example.LibrarayManagement.dto.SearchRequest;
import com.example.LibrarayManagement.models.Book;
import com.example.LibrarayManagement.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        // create admin

        bookService.createOrUpdateBook(createBookRequest.to());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Book got added successfully");

    }

    @GetMapping("/search")
    public SearchBookResponse getBooks(@RequestBody @Valid SearchRequest searchRequest) {
        try {
            List<Book> bookList = bookService.findBook(
                    searchRequest.getSearchKey(),
                    searchRequest.getSearchValue());
            // TODO - Remove this logic from here and add in some dto
            List<BookResponse> bookResponseList = new ArrayList<>();
            for(Book book : bookList) {
                bookResponseList.add(book.to());
            }
            return new SearchBookResponse(bookResponseList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new SearchBookResponse();
        }
    }
}

// get book based on some genre

// get book by an author

// book by id

// book by name
