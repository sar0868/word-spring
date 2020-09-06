package ru.safarov.wordspring.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WordCountResponse {

    private Long idResponse;
    private Map<String, Long> words;

    public Long getIdResponse() {
        return idResponse;
    }

    public void setIdResponse(Long idResponse) {
        this.idResponse = idResponse;
    }

    public Map<String, Long> getWords() {
        return words;
    }

    public void setWords(Map<String, Long> words) {
        this.words = words;
    }

}
