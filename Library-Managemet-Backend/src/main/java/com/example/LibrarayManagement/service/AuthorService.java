package com.example.LibrarayManagement.service;

import com.example.LibrarayManagement.models.Author;
import com.example.LibrarayManagement.repository.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorDao authorDao;

    public Author getOrCreate(Author author) {

        // try to get the author with the same email
        Author existingAuthor = authorDao.findByEmail(author.getEmail());

        // if it doesn't -> create the author and return the same
        if(existingAuthor == null) {
            existingAuthor = authorDao.save(author);
        }

        // if it exists -> return the author object
        return existingAuthor;

    }



}
