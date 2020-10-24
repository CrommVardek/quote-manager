package com.crommvardek.quotemanager.controller;

import com.crommvardek.quotemanager.domain.Author;
import com.crommvardek.quotemanager.domain.Quote;
import com.crommvardek.quotemanager.domain.exceptions.AuthorDoesNotExistsException;
import com.crommvardek.quotemanager.services.AuthorFinder;
import com.crommvardek.quotemanager.services.QuoteProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class QuoteManagerController {

    private final AuthorFinder authorFinder;

    private final QuoteProvider quoteProvider;

    public QuoteManagerController(AuthorFinder authorFinder, QuoteProvider quoteProvider) {
        this.authorFinder = authorFinder;
        this.quoteProvider = quoteProvider;
    }

    @GetMapping
    public Quote getQuote(String authorName){
        try {
            Author author = authorFinder.getTheAuthor(authorName);
            return quoteProvider.getQuote(author);
        } catch (AuthorDoesNotExistsException e) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find author");
        }
    }

}
