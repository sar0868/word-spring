package ru.safarov.wordspring.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.safarov.wordspring.service.WordCountService;

@RestController
public class TextController {

    private WordCountService wordCountService;

    public TextController(WordCountService wordCountService) {
        this.wordCountService = wordCountService;
    }

    @PostMapping("/wordservice")
    public WordCountResponse wordsCount(FileUploadController text){

        return wordCountService.countWords(text);
    }
}
