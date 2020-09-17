package com.crommvardek.quotemanager.domain.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonNodeToModelMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public <T> T map(JsonNode jsonNode, Class<T> modelClass){
        try{
            return objectMapper.treeToValue(jsonNode, modelClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
