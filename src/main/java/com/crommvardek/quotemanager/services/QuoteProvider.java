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
        return author.getAnyQuote();
    }

}
