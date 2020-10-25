package com.crommvardek.quotemanager.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String authorName;

    @OneToMany
    private List<Quote> quotes;

    public Author(){
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName(){
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
