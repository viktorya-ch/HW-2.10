package org.skypro.counter.model.product;

import java.util.Objects;
import java.util.UUID;


public final class FixPriceProduct extends Product {
    private static final double FIXED_PRICE = 399.0;
    private final double price;

    public FixPriceProduct(UUID id, String title,double price) {
        super(id, title);
        this.price=price;
    }

    public double getPrice() {
        return 399.0;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            if (!super.equals(o)) {
                return false;
            } else {
                FixPriceProduct that = (FixPriceProduct)o;
                return Double.compare(this.price, that.price) == 0;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{super.hashCode(), this.price});
    }

    public String toString() {
        return " " + this.title + " :  Фиксированная цена 399.0";
    }

    public boolean isSpecial() {
        return true;
    }
}

