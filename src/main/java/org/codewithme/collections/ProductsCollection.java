package org.codewithme.collections;

import org.codewithme.models.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProductsCollection {
    public static void main(String[] args) {
        var phone1 = new Product("Samsung S22", 900);
        var phone2 = new Product("Apple 14", 1300);
        var phone3 = new Product("One Plus 10T", 600);

        Collection<Product> products = new ArrayList<>();

        products.add(phone1);
        products.add(phone2);
        products.add(phone3);

        for (var product : products) {
            System.out.println(product);
        }

        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            var product = iterator.next();
            if (product.price() > 1000) iterator.remove();
        }
        // products.removeIf(product -> product.price() > 1000);

        System.out.println(" ### ### ### ");
        System.out.println(products);

        System.out.println(" ### ### ### ");
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(phone3));

        products.remove(phone1);
        System.out.println(" ### ### ### ");
        System.out.println(products.contains(phone1));

        products.add(phone1);
        products.add(phone2);

        var toRemove = new ArrayList<Product>();
        toRemove.add(phone1);
        toRemove.add(phone3);

        products.removeAll(toRemove);

        System.out.println(" ### ### ### ");
        System.out.println(products);

    }
}
