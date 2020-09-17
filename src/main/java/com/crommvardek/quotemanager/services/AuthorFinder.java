package com.crommvardek.quotemanager.services;

import com.crommvardek.quotemanager.domain.Author;
import com.crommvardek.quotemanager.domain.exceptions.AuthorDoesNotExistsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class AuthorFinder {

    private final String authorsPath;

    public AuthorFinder(@Value("${authorsPath}")String authorsPath) {
        this.authorsPath = authorsPath;
    }

    public Author getTheAuthor(String authorName) throws AuthorDoesNotExistsException {

        //TODO search in database instead of the files

        Path authorFile = Paths.get(authorsPath, authorName + "_Quotes.txt");

        if(Files.exists(authorFile)){
            return new Author(authorName);
        }

        throw new AuthorDoesNotExistsException();

    }

}
