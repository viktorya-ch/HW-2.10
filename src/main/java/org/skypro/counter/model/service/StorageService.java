package org.skypro.counter.model.service;

import org.skypro.counter.model.article.Article;
import org.skypro.counter.model.product.DiscountedProduct;
import org.skypro.counter.model.product.FixPriceProduct;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.product.SimpleProduct;
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
        initializeTest();

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
        DiscountedProduct product1 = new DiscountedProduct(UUID.randomUUID(), " Ручка ", 39, 6 );
        FixPriceProduct product2 = new FixPriceProduct(UUID.randomUUID(), " Книга ", 799);
        SimpleProduct product3 = new SimpleProduct(4900," Наушники ", UUID.randomUUID());
        products.put(product1.getID(), product1);
        products.put(product2.getID(),product2);
        products.put(product3.getID(),product3);

        Article article1 = new Article(UUID.randomUUID(), " Кровать ", " Кровать односпальная подростковая ");
        Article article2 = new Article(UUID.randomUUID(), " Монитор ", " Монитор обладает разрешением 1920*108 ");
        Article article3 = new Article(UUID.randomUUID(), " Фен ", " Фен мощностью 1600ВТ ");
        Article article4 = new Article(UUID.randomUUID(), " Стол ", " Стол из английского дерева ");
        articles.put(article1.getID(),article1);
        articles.put(article2.getID(),article2);
        articles.put(article3.getID(),article3);
        articles.put(article4.getID(),article4);

    }


}