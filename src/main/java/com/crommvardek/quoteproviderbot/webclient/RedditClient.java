package com.crommvardek.quoteproviderbot.webclient;

import com.crommvardek.quoteproviderbot.domain.PrivateMessage;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class RedditClient {

    private final WebClient webClient;

    private final String REDDIT_URI;

    public RedditClient(WebClient webClient, @Value("${redditUrl}") String reddit_uri){
        this.webClient = webClient;
        REDDIT_URI = reddit_uri;
    }

    public Flux<PrivateMessage> getUnreadMessages(){
        return webClient.get()
                .uri(REDDIT_URI + "/message/unread")
                .retrieve()
                .bodyToFlux(JsonNode.class)
                .parallel()
                .map(this::map)
                .sequential();
    }

    private PrivateMessage map(JsonNode jn){
        //TODO
        return new PrivateMessage();
    }

}
