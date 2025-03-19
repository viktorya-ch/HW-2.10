package org.skypro.counter.model.search;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class SearchResult {
    public final String id;
    public final String title;
    public final String contentType;


    public SearchResult(UUID id, String title, String contentType) {
        this.id = id;
        this.title = title;
        this.contentType = contentType;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle() {
        return title;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType() {
        return contentType;
    }

    public static fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId(),
                searchable.getTitle(),
                searchable.getContentType());
    }

    public Map<SearchResult> search(String inquiry) {
        Map<Searchable> searchables = storageService.getAllSearchables();
        return searchables.stream().filter(searchable -> searchable.getTitle().contains(inquiry)).map(SearchResult::fromSearchable).collect(Collectors.toMap());

    }

}
