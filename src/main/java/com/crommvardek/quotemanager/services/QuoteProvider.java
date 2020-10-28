package com.crommvardek.quotemanager.services;

import com.crommvardek.quotemanager.domain.author.Author;
import com.crommvardek.quotemanager.domain.quote.Quote;
import org.springframework.stereotype.Service;

@Service
public class QuoteProvider {


    public QuoteProvider() {

    }

    public String provideQuoteFrom(Author author) {
        return buildQuote(author).toString();
    }

    private StringBuilder buildQuote(Author author) {
        StringBuilder quoteText = new StringBuilder();
        quoteText.append(author.getAuthorName());
        quoteText.append(" : \"");
        quoteText.append(getQuote(author).getQuoteText());
        quoteText.append("\"");
        return quoteText;
    }

    private Quote getQuote(Author author){
        return author.getRandomQuote();
    }

}
