package org.skypro.counter.model.service;

import org.skypro.counter.model.article.Article;
import org.skypro.counter.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    @Autowired
    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<Product> searchProducts(String inquery){
        List<Product>products = storageService.getProducts();
        return products.stream().filter(product -> {
            return product.getTitle().contains(inquery).collect(Collectors.toList());
        });
    }
    public List<Article> searchArticles(String inquery){
        List<Article>articles=storageService.getArticles();
        return articles.stream().filter(article -> article.getTitleArticle().contains(inquery) || article.getTextArticle().contains(inquery).collect(Collectors.toList());
    }



}
