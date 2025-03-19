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

@Service
public class SearchService {
    private final StorageService storageService;

    @Autowired
    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }


    public List<SearchResult> search(String inquery) {
        Collection<Searchable> searchables = storageService.getAllSearchables();
        return searchables.stream().filter(searchable -> searchable.getContentType().toLowerCase().contains(inquery.toLowerCase())).map(SearchResult::new).collect(Collectors.toList());
    }


}
