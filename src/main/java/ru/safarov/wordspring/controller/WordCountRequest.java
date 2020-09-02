package ru.safarov.wordspring.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCountRequest {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
