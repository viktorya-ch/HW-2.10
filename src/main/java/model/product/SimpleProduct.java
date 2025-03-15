package model.product;

import model.product.Product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private final double price;
    super(nameProduct, id);




    public SimpleProduct(String title, double price) {
        super(title);
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
