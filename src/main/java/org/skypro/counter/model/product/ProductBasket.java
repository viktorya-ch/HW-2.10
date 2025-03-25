package org.skypro.counter.model.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {

        products = new HashMap<>();
    }


    public void addProduct(Product product) {
        products.computeIfAbsent(product.getTitle(), k -> new ArrayList<>()).add(product);
    }

    public void removeProduct(Product product) {
        List<Product> productList = products.get(product.getTitle());
        if (productList != null) {
            productList.remove(product);
            if (productList.isEmpty()) {
                products.remove(product.getTitle());
            }
        }
    }

    public List<Product> removeProductsByTitle(String title) {
        List<Product> removedProducts = new ArrayList<>();
        List<Product> productList = products.get(title);
        if (productList != null) {
            removedProducts.addAll(productList);
            productList.clear();
            products.remove(title);
        }
        return removedProducts;
    }

    public void printBasket() {
        products.forEach((title,productList) -> {
            System.out.println(" Название: " + title);
            productList.forEach(System.out::println);
        });
    }

    public void clearBasket() {
        products.clear();
    }

    public double getTotalCost() {
        return products.values().stream().flatMap(List :: stream).mapToDouble(Product::getPrice).sum();
    }

    public int isSpecialProducts() {
        int count = 0;
        for (List<Product> product : products.values()) {
            if (product.isEmpty()) {
                count++;
            }
        }
        return count;
    }


}
