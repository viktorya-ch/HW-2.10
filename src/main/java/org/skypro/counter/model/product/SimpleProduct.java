package org.skypro.counter.model.product;

import java.util.Objects;
import java.util.UUID;

public final class SimpleProduct extends Product {
    private final double price;
    //private String title;
    //private UUID id;

    public SimpleProduct(double price, String title, UUID id) {
        super(id, title);
        if (price < 0) {
            throw new ArithmeticException(" Неправильная цена продукта");
        }
        this.price = price;

    }

    public double getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return Double.compare(price, that.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }


    @Override
    public String toString() {
        return " " + title + " : " + price + " ";
    }

    public boolean isSpecial() {
        return false;
    }

}
