package com.crommvardek.quotemanager.domain.author;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    private final ModelMapper modelMapper;

    public AuthorMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public AuthorDTO authorToDTO(Author author){
        AuthorDTO authorDTO = modelMapper.map(author, AuthorDTO.class);
        return authorDTO;
    }

}
