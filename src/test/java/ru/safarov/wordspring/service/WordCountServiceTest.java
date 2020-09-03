package ru.safarov.wordspring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.safarov.wordspring.controller.WordCountResponse;
import ru.safarov.wordspring.model.Words;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class WordCountServiceTest {

    @Test
    void countWordsTest() {
//        String textTest = null;
        String textTest = "Grut! 12 3  I am grut!";
        WordCountService wordCountService = new WordCountService();
        WordCountResponse words = wordCountService.countWords(textTest);
        System.out.println(words);
//        Assertions.assertEquals("{am=1, grut=2, i=1}", words.toString());

    }
}