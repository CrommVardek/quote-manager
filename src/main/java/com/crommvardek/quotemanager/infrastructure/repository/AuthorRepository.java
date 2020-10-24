package com.crommvardek.quotemanager.infrastructure.repository;

import com.crommvardek.quotemanager.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE LOWER(a.authorName) = LOWER(:authorName)")
    Author findByAuthorName(String authorName);

}
