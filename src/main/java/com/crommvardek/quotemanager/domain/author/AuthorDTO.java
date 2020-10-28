package com.crommvardek.quotemanager.domain.author;

import com.crommvardek.quotemanager.domain.quote.QuoteDTO;

import java.util.Set;

public class AuthorDTO {

    private final String authorName;

    private final Set<QuoteDTO> quotes;

    public AuthorDTO(String authorName, Set<QuoteDTO> quotes) {
        this.authorName = authorName;
        this.quotes = quotes;
    }

}
