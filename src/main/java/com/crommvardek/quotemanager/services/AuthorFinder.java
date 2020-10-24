package com.crommvardek.quotemanager.services;

import com.crommvardek.quotemanager.domain.Author;
import com.crommvardek.quotemanager.domain.exceptions.AuthorDoesNotExistsException;
import com.crommvardek.quotemanager.infrastructure.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class AuthorFinder {

    private final AuthorRepository authorRepository;

    public AuthorFinder(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getTheAuthor(String authorName) throws AuthorDoesNotExistsException {

        //TODO search in database instead of the files


        if(true){
            return new Author(authorName);
        }

        throw new AuthorDoesNotExistsException();

    }

}
