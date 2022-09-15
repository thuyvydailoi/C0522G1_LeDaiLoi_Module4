package com.codegym.service.impl;

import com.codegym.repository.IDictionaryRepository;
import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    IDictionaryRepository iDictionaryRepository;
    @Override
    public String distionary(String english) {
        return iDictionaryRepository.translate(english);
    }
}
