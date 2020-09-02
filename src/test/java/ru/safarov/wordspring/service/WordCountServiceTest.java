package ru.safarov.wordspring.service;

import org.junit.jupiter.api.Test;
import ru.safarov.wordspring.model.Words;

import static org.junit.jupiter.api.Assertions.*;

class WordCountServiceTest {

    @Test
    void countWordsTest() {
        String textTest = "Grut! 12 3  I am grut!";
        WordCountService wordCountService = new WordCountService();
        Words words = new Words(wordCountService.countWords(textTest));
        System.out.println(words);

    }
}