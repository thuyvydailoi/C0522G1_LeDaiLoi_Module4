package com.codegym.repository.impl;

import com.codegym.model.Dictionary;
import com.codegym.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

     private  static Map<String, String> dictionary = new HashMap<>();

    @Override
    public String translate(String english) {

        dictionary.put("hello","xin chào");
        dictionary.put("world","thế giới");
        dictionary.put("bear","con gấu");
        dictionary.put("street","con đường");
        dictionary.put("bean","hạt đậu");

        return dictionary.get(english);

    }
}
