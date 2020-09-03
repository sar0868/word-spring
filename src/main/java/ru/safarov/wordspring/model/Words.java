package ru.safarov.wordspring.model;

import com.fasterxml.jackson.databind.type.MapType;

import java.util.*;

public class Words {

    private Collection<Word> words;

    public Collection<Word> getWords() {
        return words;
    }

    public void setWords(Collection<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return words + "";
    }
}
