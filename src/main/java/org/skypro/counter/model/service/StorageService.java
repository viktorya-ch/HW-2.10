package org.skypro.counter.model.service;

import org.skypro.counter.model.article.Article;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.search.SearchResult;
import org.skypro.counter.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;
    private final Map<UUID, Searchable> getAllSearchable;


    public Map<UUID, Product> getProducts() {
        return products;
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }

    public Map<UUID, Searchable> getGetAllSearchable() {
        return getAllSearchable;
    }

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        this.getAllSearchable = new HashMap<>();

    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Object> getAllSearchable() {
        return Stream.concat(products.values().stream(), articles.values().stream()).collect(Collectors.toList());
    }


    private void initializeTest() {
        Product product1 = new Product(UUID.randomUUID(), " Чайник ") {
            @Override
            public double getPrice() {
                return 0;
            }

            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        Product product2 = new Product(UUID.randomUUID(), " Фен ") {
            @Override
            public double getPrice() {
                return 0;
            }

            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        Product product3 = new Product(UUID.randomUUID(), " Блокнот ") {
            @Override
            public double getPrice() {
                return 0;
            }

            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        Product product4 = new Product(UUID.randomUUID(), " Стол ") {
            @Override
            public double getPrice() {
                return 0;
            }

            @Override
            public boolean isSpecial() {
                return false;
            }
        };


        Article article1 = new Article(UUID.randomUUID(), " Кровать ", " Кровать односпальная подростковая ");
        Article article2 = new Article(UUID.randomUUID(), " Монитор ", " Монитор обладает разрешением 1920*108 ");
        Article article3 = new Article(UUID.randomUUID(), " Фен ", " Фен мощностью 1600ВТ ");
        Article article4 = new Article(UUID.randomUUID(), " Стол ", " Стол из английского дерева ");

    }


    public Collection<SearchResult> getAllSearchResults() {
        return List.of();
    }
}