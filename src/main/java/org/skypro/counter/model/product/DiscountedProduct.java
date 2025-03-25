package org.skypro.counter.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    public double basePrice;
    public int discount;

 public DiscountedProduct(UUID id, String title, double basePrice, int discount) {
        super(id, title);
        this.discount=discount;
        if (basePrice < 0.0) {
            throw new IllegalArgumentException(" Неправильная базовая цена продукта ");
        } else {
            this.basePrice = basePrice;
            if (0 <= discount & discount >= 100) {
                throw new IllegalArgumentException(" Неправильная скидка для продукта ");
            } else {
                this.discount = discount;

            }
        }
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public int getDiscount() {
        return this.discount;
    }

    public double getPrice() {
        return this.basePrice - this.basePrice * (double)this.discount / 100.0;
    }

    public String toString() {
        return " " + this.title + " : " + this.basePrice + " Скидка = " + this.discount;
    }

    public boolean isSpecial() {
        return true;
    }
}


