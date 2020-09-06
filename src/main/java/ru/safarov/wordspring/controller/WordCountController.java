package ru.safarov.wordspring.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.safarov.wordspring.service.WordCountService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WordCountController {

    private final WordCountService wordCountService;

    public WordCountController(WordCountService wordCountService) {
        this.wordCountService = wordCountService;
    }

    @PostMapping("/wordCount")
    public WordCountResponse wordsCount(@RequestBody WordCountRequest request){
        Map<String, Long> words = wordCountService.countWords(request.getText());
        WordCountResponse response = new WordCountResponse();
        response.setIdResponse(request.getId());
        response.setWords(words);
        return response;
    }
}
