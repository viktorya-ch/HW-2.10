package org.skypro.counter.model.basket;

import org.skypro.counter.model.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<UUID, Integer> products;

    public ProductBasket() {

        this.products = new HashMap<>();
    }

    public void addProduct(UUID id) {
        products.put(id, products.getOrDefault(id, 0) + 1);
    }

    public Map<UUID, Integer> getProducts() {
        return Collections.unmodifiableMap(products);

    }


}
