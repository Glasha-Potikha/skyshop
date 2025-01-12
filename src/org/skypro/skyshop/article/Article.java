package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    final private String name;
    final private String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name + '\n' + text;
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }

    @Override
    public String typeFound() {
        return "ARTICLE";
    }
}
