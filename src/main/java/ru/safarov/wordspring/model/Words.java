package ru.safarov.wordspring.model;

import com.fasterxml.jackson.databind.type.MapType;

import java.util.TreeMap;

public class Words {

    private TreeMap<String, Long> words = new TreeMap<>();

    public Words(TreeMap<String, Long> words) {
        this.words = words;
    }

    public TreeMap<String, Long> getWords() {
        return words;
    }

    public void setWords(TreeMap<String, Long> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Words{" +
                "words=" + words +
                '}';
    }
}
