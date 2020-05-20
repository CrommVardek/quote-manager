package Domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Author {

    private final String authorName;

    private List<Quote> quotes;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public String getAnyQuote(){
        return quotes
            .stream()
            .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
            .findAny()
            .get()
            .getText();
    }

}
