package com.crommvardek.quotemanager.infrastructure.repository;

import com.crommvardek.quotemanager.domain.author.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE LOWER(a.authorName) = LOWER(:authorName)")
    Author findByAuthorName(String authorName);

}
