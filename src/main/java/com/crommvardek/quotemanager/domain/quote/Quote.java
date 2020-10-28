package com.crommvardek.quotemanager.domain.quote;

import com.crommvardek.quotemanager.domain.author.Author;

import javax.persistence.*;

@Entity
public class Quote {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;

    private String quoteText;

    public Quote(){

    }

    public Quote(Author author, String quoteText) {
        this.author = author;
        this.quoteText = quoteText;
    }

    public Long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getQuoteText() {
        return quoteText;
    }


    @Override
    public boolean equals(Object o){
        return ((o instanceof Quote) && (((Quote) o).getQuoteText().equals(getQuoteText())));
    }

    @Override
    public int hashCode() {
        return quoteText.hashCode();
    }
}
