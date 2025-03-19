package org.skypro.counter.model.service;

import org.skypro.counter.model.article.Article;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class StorageService {

    private Map<UUID, Product> products;
    private Map<UUID, Article> articles;
    private Map<UUID, Searchable> getAllSearchable;


    public Map<UUID, Product> getProducts() {
        return products;
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }

    public Map<UUID, Searchable> getGetAllSearchable() {
        return getAllSearchable;
    }

    public StorageService(Map<UUID, Product> products, Map<UUID, Article> articles) {
        this.products = new HashMap<>;
        this.articles = new HashMap<>;
        this.getAllSearchable = new HashMap<>;

    }
    public Collection<Searchable>getAllSearchables(){
        return getAllSearchable.values();
    }

    public class Mup<Searchable> getAllSearchables() {
        Map<Searchable> searchables = new HashMap<>();
        searchables.putAll(products);
        searchables.putAll(articles);
        return searchables;
    }

    private void initializeTest() {
        Product product1 = new Product(UUID.randomUUID(), " Чайник ")
        Product product2 = new Product(UUID.randomUUID(), " Фен ");
        Product product3 = new Product(UUID.randomUUID(), " Блокнот ");
        Product product4 = new Product(UUID.randomUUID(), " Стол ");


        Article article1 = new Article(UUID.randomUUID(), " Кровать ", " Кровать односпальная подростковая ");
        Article article2 = new Article(UUID.randomUUID(), " Монитор ", " Монитор обладает разрешением 1920*108 ");
        Article article3 = new Article(UUID.randomUUID(), " Фен ", " Фен мощностью 1600ВТ ");
        Article article4 = new Article(UUID.randomUUID(), " Стол ", " Стол из английского дерева ");

    }


}