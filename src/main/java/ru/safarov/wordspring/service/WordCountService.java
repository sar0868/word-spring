package ru.safarov.wordspring.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class WordCountService {

    public Map<String, Long> countWords(String text){

        text = text.replaceAll("[^a-zA-Z]", " ");
        List<String> temp = new ArrayList<String>(Arrays.asList(text.split("\\W+")));
        Map<String, Long> words = new HashMap<>();
        for(String str: temp){
            str = str.replaceAll("\\s+","").toLowerCase();
            if(str.isEmpty()){
                continue;
            }
            if(words.containsKey(str)){
                Long n = words.get(str);
                words.put(str, n+1);
            } else {
                words.put(str,1L);
            }
        }
//        List<Word> words1 = new ArrayList<>();
//        for (Map.Entry<String, Long> entry: words.entrySet()){
//            Word word = new Word(entry.getKey(), entry.getValue());
//            words1.add(word);
//        }
//        words1.sort(Comparator.comparing(Word::getCount).reversed());


        return words;
    }


}
