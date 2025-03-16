package org.skypro.counter.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Objects;
import java.util.UUID;


public class Article {

    private final UUID id;
    private final String titleArticle;
    private final String textArticle;

    public Article(UUID id, String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
        this.id = id;

    }

    public String getID() {
        return this.id;
    }

    public String getTitleArticle() {
        return this.titleArticle;
    }

    public String getTextArticle() {
        return this.textArticle;
    }


    public String toString() {
        return " " + titleArticle + "\n" + textArticle;
    }

    @JsonIgnore
    public String getSearchTerm() {
        return toString();
    }

    @JsonIgnore
    public String getContentType() {
        return " ARTICLE ";
    }

//    @Override
//    public String getName() {
//        return titleArticle;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleArticle, article.titleArticle) && Objects.equals(textArticle, article.textArticle);
    }


    @Override
    public int hashCode() {
        return Objects.hash(titleArticle, textArticle);
    }
}