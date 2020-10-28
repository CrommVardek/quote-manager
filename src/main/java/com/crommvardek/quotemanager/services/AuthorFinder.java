package com.crommvardek.quotemanager.services;

import com.crommvardek.quotemanager.domain.author.Author;
import com.crommvardek.quotemanager.domain.author.AuthorDoesNotExistsException;
import com.crommvardek.quotemanager.infrastructure.repository.AuthorRepository;
import org.springframework.stereotype.Service;


@Service
public class AuthorFinder {

    private final AuthorRepository authorRepository;

    public AuthorFinder(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getTheAuthor(String authorName) throws AuthorDoesNotExistsException {

        Author author = authorRepository.findByAuthorName(authorName);

        if (author == null) throw new AuthorDoesNotExistsException();

        return author;

    }

}
