package WebClient;

import Domain.PrivateMessage;
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
        webClient.get()
                .uri
    }

}
