package org.codewithme.interfaces;

public class DefaultMethodExample {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start();
        car.stop(); // Uses the default implementation
    }
}
