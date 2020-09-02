package ru.safarov.wordspring.service;

import org.springframework.stereotype.Service;
import ru.safarov.wordspring.model.Word;
import ru.safarov.wordspring.model.Words;

import java.util.TreeMap;

@Service
public class WordCountService {

    private Words words;


    public WordCountResponse countWords(String text){
        String result = text.split(" ")

        WordCountResponse wordCountResponse = new WordCountResponse();

        return null;
    }


}
