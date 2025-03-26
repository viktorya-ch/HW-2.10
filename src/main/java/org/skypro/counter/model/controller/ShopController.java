package org.skypro.counter.model.controller;


import org.skypro.counter.model.article.Article;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.search.SearchResult;
import org.skypro.counter.model.service.StorageService;
import org.skypro.counter.model.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ShopController {
    private StorageService storageService;
    private SearchService searchServise;

    public ShopController(StorageService storageService, SearchService searchServise){
        this.storageService = storageService;
        this.searchServise = searchServise;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getProducts().values();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getArticles().values();
    }


    @GetMapping("/search")
    public List<SearchResult> search(@RequestParam String pattern) {
        return searchServise.search(pattern);
    }
}
