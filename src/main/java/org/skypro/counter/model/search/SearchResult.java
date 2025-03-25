package org.skypro.counter.model.search;

import org.skypro.counter.model.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class  SearchResult {
    public final UUID id;
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

    public UUID setId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String setTitle() {
        return title;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String setContentType() {
        return contentType;
    }


    public static SearchResult fromSearchable(Searchable searchable,String title, String contentType) {
        return new SearchResult(searchable.getId(),title,contentType);
    }

}
