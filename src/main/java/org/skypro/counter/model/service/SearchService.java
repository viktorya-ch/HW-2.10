package org.skypro.counter.model.service;

import org.skypro.counter.model.article.Article;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.search.SearchResult;
import org.skypro.counter.model.search.Searchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class SearchService {
    private final StorageService storageService;

    @Autowired
    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }


    public Collection<SearchResult>search(String searchTerm) {
        return storageService.getAllSearchable().stream().filter(o -> o instanceof Searchable).map(o->(Searchable)o).filter(searchable -> searchable.getSearchTerm().contains(searchTerm))
                .map(searchable -> new SearchResult(searchable.getId(),searchable.getName(),searchable.getContentType())).collect(Collectors.toList());

    }
                
                



}
