package com.crommvardek.quoteproviderbot.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class Author {

    private final String authorName;

    private List<Quote> quotes;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Quote getAnyQuote(){
        return quotes
            .stream()
            .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
            .findAny()
            .get();
    }

    public void addQuote(Quote quote){
        Predicate<Quote> equal = q -> q.equals(quote);
        if(!(quotes.stream().anyMatch(equal))) quotes.add(new Quote(quote.getText()));
    }

    public String getName(){
        return authorName;
    }

}
