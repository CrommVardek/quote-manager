package com.crommvardek.quotemanager.services;

import com.crommvardek.quotemanager.domain.Author;
import com.crommvardek.quotemanager.domain.Quote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class QuoteProvider {

    private final String authorsPath;

    public QuoteProvider(@Value("${authorsPath}")String authorsPath) {
        this.authorsPath = authorsPath;
    }

    public Quote getQuote(Author author){
        loadQuotes(author);
        return author.getAnyQuote();
    }

    private void loadQuotes(Author author){

        Path quotesFile = Paths.get(authorsPath, author.getName() + "_Quotes.txt");

        try {
            Files.readAllLines(quotesFile).stream().forEach(s->author.addQuote(new Quote(s)));
        } catch (IOException e) {
            //TODO
        }

    }

}
