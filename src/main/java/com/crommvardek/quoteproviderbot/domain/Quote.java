package com.crommvardek.quoteproviderbot.domain;

public class Quote {

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
