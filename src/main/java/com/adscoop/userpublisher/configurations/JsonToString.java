package com.adscoop.userpublisher.configurations;

import com.google.gson.Gson;
import com.google.inject.Inject;

/**
 * Created by thokle on 23/03/2017.
 */
public class JsonToString {
    private Gson gson;

    @Inject
    public JsonToString(Gson gson) {
        this.gson = gson;
    }

    public String toString(Object o){
      return   gson.toJson(o);


    }
}
