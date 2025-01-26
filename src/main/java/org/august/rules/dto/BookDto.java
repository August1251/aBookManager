package org.august.rules.dto;

import java.util.HashMap;
import java.util.List;

public class BookDto {

    private final String title;
    private final String author;
    private final List<String> rules;

    public BookDto(String title, String author, List<String> rules) {
        this.title = title;
        this.author = author;
        this.rules = rules;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getRules() {
        return rules;
    }

}