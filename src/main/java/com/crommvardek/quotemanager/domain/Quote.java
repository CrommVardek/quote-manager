package com.crommvardek.quotemanager.domain;

import javax.persistence.*;

@Entity
public class Quote {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Author author;

    private String quoteText;

    public Quote(){

    }

    public Quote(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getText(){
        return quoteText.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    @Override
    public boolean equals(Object o){
        return ((o instanceof Quote) && (((Quote) o).getText().equals(getText())));
    }

    @Override
    public int hashCode() {
        return quoteText.hashCode();
    }
}
