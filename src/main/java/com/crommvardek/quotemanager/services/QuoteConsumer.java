package com.crommvardek.quotemanager.services;

import com.crommvardek.quotemanager.domain.Quote;

import java.util.function.Consumer;

public class QuoteConsumer implements Consumer<Quote> {
    @Override
    public void accept(Quote quote) {
        //TODO write a comment...
        System.out.println(quote.getText());
    }
}
