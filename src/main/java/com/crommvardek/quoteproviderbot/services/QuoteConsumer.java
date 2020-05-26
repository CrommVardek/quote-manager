package com.crommvardek.quoteproviderbot.services;

import com.crommvardek.quoteproviderbot.domain.Quote;

import java.util.function.Consumer;

public class QuoteConsumer implements Consumer<Quote> {
    @Override
    public void accept(Quote quote) {
        //TODO write a comment...
        System.out.println(quote.getText());
    }
}
