package com.crommvardek.quotemanager.domain.author;

import com.crommvardek.quotemanager.domain.quote.Quote;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String authorName;

    @OneToMany(mappedBy = "author")
    @Cascade(CascadeType.ALL)
    private Set<Quote> quotes;

    public Author(){
    }

    public Author(String authorName, Set<Quote> quotes) {
        this.authorName = authorName;
        this.quotes = quotes;
    }

    public Quote getRandomQuote(){
        return quotes
            .stream()
            .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
            .findAny()
            .get();
    }

    public Long getId() {
        return id;
    }

    public String getAuthorName(){
        return authorName;
    }

    public Set<Quote> getQuotes() {
        return quotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorName, author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName);
    }
}
