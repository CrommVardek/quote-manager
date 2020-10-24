package com.crommvardek.quotemanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

@Entity
public class Author {

    @Id
    private Long id;

    private final String authorName;

    @OneToMany
    private List<Quote> quotes;

    public Author(String authorName) {
        this.authorName = authorName;
        quotes = new ArrayList<>();
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

    public String getAuthorName(){
        return authorName;
    }

}
