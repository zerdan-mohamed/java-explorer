package org.codewithme.functionalinterfaces;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunnableImplementation {

    public static void main(String[] args) {
        scheduledTask();
        backgroundTask();
    }

    // The Runnable functional interface can be used with ScheduledExecutorService
    //  to schedule and execute tasks at specific intervals
    public static void scheduledTask() {
        // Create a ScheduledExecutorService with a single thread
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Define a Runnable task to be scheduled
        Runnable periodicTask = () -> System.out.println("Scheduled Task: Hello!");

        // Schedule the task to run every 2 seconds with an initial delay of 1 second
        scheduler.scheduleAtFixedRate(periodicTask, 1, 2, TimeUnit.SECONDS);

        // Allow the task to run for a while
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Shutdown the scheduler when done
        scheduler.shutdown();
    }


    // Perform tasks in the background without blocking the main thread
    public static void backgroundTask() {
        // Create a Runnable to define the background task
        Thread thread = getThread();
        thread.start();

        // Main thread continues executing other tasks
        for (int i = 0; i < 3; i++) {
            System.out.println("Main Thread Task: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static Thread getThread() {
        Runnable backgroundTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Background Task: " + i);
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Start a new thread to run the background task
        return new Thread(backgroundTask);
    }
}
