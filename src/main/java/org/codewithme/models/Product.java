package org.codewithme.models;

import java.util.Comparator;

public record Product(String name, double price) {

    @Override
    public String toString() {
        return "Product{" +
                    "name= '" + name +
                    "', Price= " + price +
                "}";
    }

    public static final Comparator<Product> BY_PRICE = Comparator.comparingDouble(Product::price);
}
