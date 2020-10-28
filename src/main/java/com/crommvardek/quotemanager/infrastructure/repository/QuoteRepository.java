package com.crommvardek.quotemanager.infrastructure.repository;

import com.crommvardek.quotemanager.domain.author.Author;
import com.crommvardek.quotemanager.domain.quote.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {

    @Query("Select q from Quote q where q.author = :author")
    List<Quote> findByAuthor(Author author);

}
