package com.crommvardek.quotemanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Quote {

    @Id
    private Long id;

    @ManyToOne
    private Author author;

    private String quoteText;

    public Quote(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getText(){
        return quoteText.trim();
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
