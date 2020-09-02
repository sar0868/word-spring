package ru.safarov.wordspring.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.safarov.wordspring.model.Words;
import ru.safarov.wordspring.service.WordCountResponse;
import ru.safarov.wordspring.service.WordCountService;

@RestController
public class TextController {

    private WordCountService wordCountService;

    public TextController(WordCountService wordCountService) {
        this.wordCountService = wordCountService;
    }

    @PostMapping("/wordspring")
    public Words wordsCount(String text){

        return wordCountService.countWords(text);
    }
}
