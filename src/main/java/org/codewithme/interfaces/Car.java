package org.codewithme.interfaces;

public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Starting the car");
    }
}
