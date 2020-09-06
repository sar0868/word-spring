package ru.safarov.wordspring.service;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.safarov.wordspring.controller.WordCountController;
import ru.safarov.wordspring.controller.WordCountResponse;

import java.io.*;
import java.util.Map;
import java.util.Objects;

class WordCountServiceTest {

    WordCountController wordCountController;
    WordCountResponse response;



    @Test
    void countWordsTest() {
        String textTest = "Grut! 12 3  I am grut!";
        WordCountService wordCountService = new WordCountService();
        Map<String, Long> words = wordCountService.countWords(textTest);
        Assertions.assertEquals(2L, words.get("grut"));
    }

    @Test
    void countWordsBook() {

        WordCountService wordCountService = new WordCountService();

        String textTest  = null;
        try {
            textTest = FileUtils.readFileToString(new File(Objects.requireNonNull(this.getClass().getClassLoader()
                    .getResource("Dune.txt")).getFile()), "utf-16be");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Long> words = wordCountService.countWords(textTest);
        Assertions.assertEquals(331L, words.get("when"));
    }
}