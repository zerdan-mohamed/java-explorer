package org.codewithme.functionalinterfaces;

import org.codewithme.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateImplementation {
    private static final Map<String, String> userCredentials = new HashMap<>();

    static {
        // Simulate user credentials stored in a database
        userCredentials.put("user1", "password123");
        userCredentials.put("user2", "secure456");
    }

    public static void main(String[] args) {
        productFilter();
        userAuthentication();
    }

    // Using Predicate to filter a list of products based on their price
    public static void productFilter() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 800.0));
        products.add(new Product("Phone", 500.0));
        products.add(new Product("Tablet", 300.0));

        Predicate<Product> priceFilter = product -> product.price() < 600.0;

        List<Product> affordableProducts = products.stream()
                .filter(priceFilter)
                .toList();

        for (Product product : affordableProducts) {
            System.out.println("Product: " + product.name() + ", Price: $" + product.price());
        }
    }


    // Using a Predicate to check whether a user's credentials are valid
    public static void userAuthentication() {
        String username = "user1";
        String password = "password123";

        Predicate<String> credentialsValidator = storedPassword -> storedPassword.equals(password);

        boolean isValid = userCredentials.containsKey(username) &&
                credentialsValidator.test(userCredentials.get(username));

        if (isValid) {
            System.out.println("Authentication successful for user: " + username);
        } else {
            System.out.println("Authentication failed for user: " + username);
        }
    }
}
