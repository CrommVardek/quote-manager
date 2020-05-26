package com.crommvardek.quoteproviderbot.webclient;

import com.crommvardek.quoteproviderbot.domain.PrivateMessage;
import com.crommvardek.quoteproviderbot.domain.mapper.JsonNodeToModelMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class RedditClient {

    private final JsonNodeToModelMapper mapper;

    private final WebClient webClient;

    private final String REDDIT_URI;

    public RedditClient(JsonNodeToModelMapper mapper, WebClient webClient, @Value("${redditUrl}") String reddit_uri){
        this.mapper = mapper;
        this.webClient = webClient;
        REDDIT_URI = reddit_uri;
    }

    public Flux<PrivateMessage> getUnreadMessages(){
        return webClient.get()
                .uri(REDDIT_URI + "/message/unread/.json?feed=90d58608de8022044718cc00a28a869f2f1a065e&user=QuotesProviderBot")
                .retrieve()
                .bodyToFlux(JsonNode.class)
                .parallel()
                .map(jsonNode -> mapper.map(jsonNode, PrivateMessage.class))
                .sequential();
    }

}
