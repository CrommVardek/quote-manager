package com.crommvardek.quoteproviderbot.controller;

import com.crommvardek.quoteproviderbot.services.AuthorFinder;
import com.crommvardek.quoteproviderbot.services.QuoteProvider;
import com.crommvardek.quoteproviderbot.webclient.RedditClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteProviderController {

    private final AuthorFinder authorFinder;

    private final QuoteProvider quoteProvider;

    private final RedditClient redditClient;

    public QuoteProviderController(AuthorFinder authorFinder, QuoteProvider quoteProvider, RedditClient redditClient) {
        this.authorFinder = authorFinder;
        this.quoteProvider = quoteProvider;
        this.redditClient = redditClient;
    }

    @PostMapping
    public void provideQuote(){

    }

}
