package org.skypro.counter.model.service;

import org.skypro.counter.model.basket.BasketItem;
import org.skypro.counter.model.basket.ProductBasket;
import org.skypro.counter.model.basket.UserBasket;
import org.skypro.counter.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    @Autowired
    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(UUID id) {
        Optional<Product> productOptional = storageService.getProductId(id);
        if (!productOptional.isPresent()) {
            throw new NoSuchProductException(" Товар не найден ");

        }
        productBasket.addProduct(id);
    }

    public UserBasket receiveUserBasket() {
        return new UserBasket(productBasket.getProducts().entrySet().stream().map(entry -> {
            Product product = storageService.getProductId(entry.getKey()).orElseThrow();
            return new BasketItem(product, entry.getValue());
        }).toList());
    }

    public  UserBasket getUserBasket() {
        return new
                UserBasket(productBasket.getProducts().entrySet().stream().map(entry -> {
            UUID productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = storageService.getProductId(productId).orElseThrow(() ->
                    new NoSuchProductException(" Товар не найден " + productId));
            return new BasketItem(product, quantity);
        }).collect(Collectors.toList()));

    }

}


