package ru.safarov.wordspring.service;

import org.springframework.stereotype.Service;
import ru.safarov.wordspring.model.Word;
import ru.safarov.wordspring.model.Words;

import java.util.*;

@Service
public class WordCountService {

    private Words words;


    public Words countWords(String text){

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

       Words wordsResponse = new Words((TreeMap<String, Long>) words);

        return wordsResponse;
    }


}
