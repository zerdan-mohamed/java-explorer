package org.codewithme.interfaces;

public interface Vehicle {
    void start(); // Abstract method

    default void stop() {
        System.out.println("Stopping the vehicle"); // Default implementation
    }
}
