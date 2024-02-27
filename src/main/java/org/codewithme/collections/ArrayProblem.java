package org.codewithme.collections;

import org.codewithme.models.Product;

import java.util.Arrays;

public class ArrayProblem {

    public static void main(String[] args) {
        var phone1 =  new Product("Samsung S22", 900);
        var phone2 =  new Product("Apple 14", 1300);
        var phone3 =  new Product("One Plus 10T", 600);

        // Create
        Product[] products = { phone1, phone2 };

        // Print
        System.out.println(products);
        System.out.println(Arrays.toString(products));

        // add
        // products[2] =  phone3; ==> Exception: Index 2 out of bounds for length 2
        // So the first problem about arrays is we need to create a custom method to add new products
        products = add(products, phone3);
        System.out.println(Arrays.toString(products));

        // duplicate
        products = add(products, phone3);
        System.out.println(Arrays.toString(products));

    }

    private static Product[] add(Product[] productArray, Product product) {
        int length = productArray.length;
        var updatedProductArray =Arrays.copyOf(productArray, length+1);
        updatedProductArray[length] = product;

        return updatedProductArray;
    }

}
