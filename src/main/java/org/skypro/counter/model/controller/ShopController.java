package org.skypro.counter.model.controller;


import org.skypro.counter.model.article.Article;
import org.skypro.counter.model.basket.UserBasket;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.search.SearchResult;
import org.skypro.counter.model.service.BasketService;
import org.skypro.counter.model.service.StorageService;
import org.skypro.counter.model.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
public class ShopController {
    private StorageService storageService;
    private SearchService searchServise;
    private BasketService basketService;

    public ShopController(StorageService storageService, SearchService searchServise) {
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
    public Collection<SearchResult> search(@RequestParam String pattern) {
        return searchServise.search(pattern);
    }

    @GetMapping("/basket/{id}")
    public String addProduct(@PathVariable(" id ") UUID id) {
        basketService.addProductToBasket(id);
        return " Продукт успешно добавлен ";
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket() {
        return basketService.getUserBasket();
    }

}
