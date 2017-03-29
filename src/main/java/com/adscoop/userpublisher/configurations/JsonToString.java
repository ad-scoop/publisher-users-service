package com.adscoop.userpublisher.configurations;

import com.adscoop.userpublisher.entites.Campagin;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.inject.Inject;

import java.util.Map;

/**
 * Created by thokle on 23/03/2017.
 */
public class JsonToString {
    private Gson gson;
    private ObjectMapper objectMapper;
    @Inject
    public JsonToString(Gson gson, ObjectMapper  objectMapper) {
        this.gson = gson;
        this.objectMapper = objectMapper;
    }

    public String toString(Object o){
      return   gson.toJson(o);


    }


    public Campagin mapToJson(Map<String , Object> map){


     return    objectMapper.convertValue(map, Campagin.class);

    }


}
