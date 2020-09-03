package ru.safarov.wordspring.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.safarov.wordspring.model.Words;

@RestController
public class WordCountResponse {

    private Words words;

    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "[words=" + words +
                ']';
    }

}
