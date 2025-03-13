package service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StorageService{

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;
    private final Map<UUID, getAllSearchable> getAllSearchables;



    public StorageService(Map<UUID, Product> products, Map<UUID, Article> articles) {
        this.products = new HashMap<>;
        this.articles = new HashMap<>;

    }
    public Mup<Searchable> getAllSearchables()
    {
        Map<Searchable> searchables = new HashMap<>();
        searchables.addAll(products);
        searchables.addAll(articles);
        return searchables;
    }

    private void initializeTest(){
        Product product1 = new Product(UUID.randomUUID(), " Чайник " , 599);
        Product product2 = new Product(UUID.randomUUID(), " Фен " , 659);
        Product product3 = new Product(UUID.randomUUID(), " Блокнот " , 198);
        Product product4 = new Product(UUID.randomUUID(), " Стол " , 10899);



        Article article1 = new Article(UUID.randomUUID(), " Кровать ", " Кровать односпальная подростковая ");
        Article article2 = new Article(UUID.randomUUID(), " Монитор ", " Монитор обладает разрешением 1920*108 ");
        Article article3 = new Article(UUID.randomUUID(), " Фен ", " Фен мощностью 1600ВТ ");
        Article article4 = new Article(UUID.randomUUID(), " Стол ", " Стол из английского дерева ");

    }


}