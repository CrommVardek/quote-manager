package com.crommvardek.quoteproviderbot.controller;

import com.crommvardek.quoteproviderbot.domain.Exceptions.AuthorDoesNotExistsException;
import com.crommvardek.quoteproviderbot.domain.PrivateMessage;
import com.crommvardek.quoteproviderbot.services.AuthorFinder;
import com.crommvardek.quoteproviderbot.services.QuoteConsumer;
import com.crommvardek.quoteproviderbot.services.QuoteProvider;
import com.crommvardek.quoteproviderbot.webclient.RedditClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

//TODO : delete this

@RestController
public class QuoteProviderController  {

    private final AuthorFinder authorFinder;

    private final QuoteProvider quoteProvider;

    private final RedditClient redditClient;

    private final QuoteConsumer quoteConsumer;

    public QuoteProviderController(AuthorFinder authorFinder, QuoteProvider quoteProvider, RedditClient redditClient
    , QuoteConsumer quoteConsumer) {
        this.authorFinder = authorFinder;
        this.quoteProvider = quoteProvider;
        this.redditClient = redditClient;
        this.quoteConsumer = quoteConsumer;
    }

    @PostMapping
    public void provideQuote() {

        getUnreadMessages().toStream().map(x-> {
            try {
                return authorFinder.getTheAuthor(x.getAuthor());
            } catch (AuthorDoesNotExistsException e) {
                return null;
            }
        }).map(author->quoteProvider.getQuote(author))
        .forEach(quoteConsumer::accept);

    }

    @GetMapping
    public Flux<PrivateMessage> getUnreadMessages(){
        return redditClient.getUnreadMessages();
    }

}
