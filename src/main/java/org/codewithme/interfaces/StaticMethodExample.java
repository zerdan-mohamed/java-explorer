package org.codewithme.interfaces;

public class StaticMethodExample {
    public static void main(String[] args) {
        int result1 = MathOperations.add(5, 3);
        int result2 = MathOperations.subtract(10, 4);

        System.out.println("Addition Result: " + result1);
        System.out.println("Subtraction Result: " + result2);
    }
}
