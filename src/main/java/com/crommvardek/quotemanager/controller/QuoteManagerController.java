package com.crommvardek.quotemanager.controller;

import com.crommvardek.quotemanager.domain.Author;
import com.crommvardek.quotemanager.domain.Quote;
import com.crommvardek.quotemanager.domain.exceptions.AuthorDoesNotExistsException;
import com.crommvardek.quotemanager.services.AuthorFinder;
import com.crommvardek.quotemanager.services.QuoteConsumer;
import com.crommvardek.quotemanager.services.QuoteProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class QuoteManagerController {

    private final AuthorFinder authorFinder;

    private final QuoteProvider quoteProvider;

    private final QuoteConsumer quoteConsumer;

    public QuoteManagerController(AuthorFinder authorFinder, QuoteProvider quoteProvider, QuoteConsumer quoteConsumer) {
        this.authorFinder = authorFinder;
        this.quoteProvider = quoteProvider;
        this.quoteConsumer = quoteConsumer;
    }

    @GetMapping
    public Quote getQuote(String authorName){
        try {
            Author author = authorFinder.getTheAuthor(authorName);
            return quoteProvider.getQuote(author);
        } catch (AuthorDoesNotExistsException e) {
            //TODO return 40X author not found
            e.printStackTrace();
        }
        return null;
    }

}
