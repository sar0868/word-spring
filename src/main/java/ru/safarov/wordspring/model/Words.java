package ru.safarov.wordspring.model;

import com.fasterxml.jackson.databind.type.MapType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Words extends TreeMap<String, Long> {

    private TreeMap<String, Long> words;

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
