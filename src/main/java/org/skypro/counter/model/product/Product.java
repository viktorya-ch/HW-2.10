package org.skypro.counter.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.skypro.counter.model.search.Searchable;



import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    protected String title;
    private final UUID id;



    public Product(UUID id, String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(" Неправильное имя для продукта ");
        }
        this.title = title;
        this.id = id;
    }

    public UUID getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public abstract double getPrice();


    public void setTitle(String title) {
        this.title = title;
    }


    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }


    public abstract boolean isSpecial();


    @JsonIgnore
    public String getSearchTerm() {
        return title;
    }

    @JsonIgnore
    public String getContentType() {
        return " PRODUCT ";
    }

//    @Override
//    public String getName() {
//        return title;
//    }


}



