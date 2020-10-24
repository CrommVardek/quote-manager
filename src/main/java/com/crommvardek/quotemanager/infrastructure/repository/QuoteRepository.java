package com.crommvardek.quotemanager.infrastructure.repository;

import com.crommvardek.quotemanager.domain.Author;
import com.crommvardek.quotemanager.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> getAllQuotesFrom(Author author);

}
