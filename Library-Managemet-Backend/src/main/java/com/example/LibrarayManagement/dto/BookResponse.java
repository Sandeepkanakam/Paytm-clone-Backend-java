package com.example.LibrarayManagement.dto;

import com.example.LibrarayManagement.models.Author;
import com.example.LibrarayManagement.models.Genre;
import com.example.LibrarayManagement.models.Student;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class BookResponse {

    private Integer id;

    private String name;

    private Author book_author;

    private Student book_student;

    private Genre genre;

    private Integer price;

    private Date createdOn;

    private Date updatedOn;

}
