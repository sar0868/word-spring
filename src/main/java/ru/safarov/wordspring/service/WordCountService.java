package ru.safarov.wordspring.service;

import org.springframework.stereotype.Service;
import ru.safarov.wordspring.controller.WordCountResponse;
import ru.safarov.wordspring.model.Word;
import ru.safarov.wordspring.model.Words;

import java.util.*;

import static java.awt.SystemColor.text;

@Service
public class WordCountService {

    private Words words;


    public WordCountResponse countWords(String text){

        WordCountResponse wordCountResponse = new WordCountResponse();


        text = text.replaceAll("[^a-zA-Z]", " ").trim();
        List<String> temp = new ArrayList<String>(Arrays.asList(text.split(" ")));
        Map<String, Long> words = new TreeMap<>();

        for(String str: temp){
            str = str.replaceAll("\\s+","").toLowerCase();
            if(str.isEmpty()){
                continue;
            }
            if(words.containsKey(str)){
                Long n = words.get(str);
                n++;
                words.replace(str, n);
            } else {
                words.put(str,1L);
            }
        }
        Words words1 = new Words();
        words1.setWords(new ArrayList<>());
        for (Map.Entry<String, Long> entry: words.entrySet()){
            Word word = new Word(entry.getKey(), entry.getValue());
            words1.getWords().add(word);
        }
        wordCountResponse.setWords(words1);
        return wordCountResponse;
    }


}
