package ru.safarov.wordspring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.safarov.wordspring.controller.WordCountController;
import ru.safarov.wordspring.controller.WordCountResponse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class WordCountServiceTest {

    @Test
    void countWordsTest() {
        String textTest = "Grut! 12 3  I am grut!";
        WordCountService wordCountService = new WordCountService();
        Map<String, Long> words = wordCountService.countWords(textTest);
        Assertions.assertEquals(2L, words.get("grut"));
    }

    @Test
    void countWordsBook() throws IOException {

        WordCountService wordCountService = new WordCountService();

        String textTest = FileUtils.readFileToString(new File(this.getClass().getClassLoader()
                    .getResource("Dune.txt").getFile()), StandardCharsets.UTF_16BE);
        Map<String, Long> words = wordCountService.countWords(textTest);
        Assertions.assertEquals(194L, words.get("woman"));
    }
}