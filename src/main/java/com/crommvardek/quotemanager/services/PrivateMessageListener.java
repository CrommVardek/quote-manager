package com.crommvardek.quotemanager.services;

import com.crommvardek.quotemanager.domain.exceptions.AuthorDoesNotExistsException;
import com.crommvardek.quotemanager.domain.PrivateMessage;
import com.crommvardek.quotemanager.webclient.RedditClient;
import org.springframework.scheduling.annotation.Scheduled;
import reactor.core.publisher.Flux;

public class PrivateMessageListener {

    private final AuthorFinder authorFinder;

    private final QuoteProvider quoteProvider;

    private final RedditClient redditClient;

    private final QuoteConsumer quoteConsumer;

    public PrivateMessageListener(AuthorFinder authorFinder, QuoteProvider quoteProvider, RedditClient redditClient
            , QuoteConsumer quoteConsumer) {
        this.authorFinder = authorFinder;
        this.quoteProvider = quoteProvider;
        this.redditClient = redditClient;
        this.quoteConsumer = quoteConsumer;
    }

    @Scheduled(fixedDelay = 15000)
    public void readMessageAndReply(){

        getUnreadMessages().toStream().map(x-> {
            try {
                return authorFinder.getTheAuthor(x.getAuthor());
            } catch (AuthorDoesNotExistsException e) {
                return null;
            }
        }).map(author->quoteProvider.getQuote(author))
                .forEach(quoteConsumer::accept);

    }

    public Flux<PrivateMessage> getUnreadMessages(){
        return redditClient.getUnreadMessages();
    }

}
