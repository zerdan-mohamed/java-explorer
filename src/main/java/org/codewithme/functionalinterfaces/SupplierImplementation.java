package org.codewithme.functionalinterfaces;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class SupplierImplementation {
    public static void main(String[] args) {
        randomNameGenerator();
        databaseConfig();
    }

    // Using a Supplier to provide random values of different types
    public static void randomNameGenerator() {
        Supplier<String> randomNameSupplier = () -> {
            String[] names = {"Alice", "Bob", "Charlie", "David", "Ella"};
            Random random = new Random();
            int randomIndex = random.nextInt(names.length);
            return names[randomIndex];
        };

        // Generate and print random names
        for (int i = 0; i < 5; i++) {
            String randomName = randomNameSupplier.get();
            System.out.println("Random Name: " + randomName);
        }
    }


    // configuring a database connection using a Supplier to provide the database URL based on the environment
    public static void databaseConfig() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter environment (production/development): ");
        String environment = scanner.nextLine();

        Supplier<String> databaseUrlSupplier = () -> {
            if (environment.equals("production")) {
                return "jdbc:mysql://production-db.example.com:3306/mydb";
            } else if (environment.equals("development")) {
                return "jdbc:mysql://localhost:3306/mydb_dev";
            } else {
                return "jdbc:mysql://localhost:3306/mydb_test";
            }
        };

        String databaseUrl = databaseUrlSupplier.get();
        System.out.println("Database URL: " + databaseUrl);
    }
}
