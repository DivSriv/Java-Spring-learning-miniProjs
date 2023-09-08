package org.example;

// Java Program to implement Runnable interface

// Importing FileNotFound class from
// input output classes bundle
import java.io.FileNotFoundException;
import java.util.concurrent.*;

// Class
// Implementing the Runnable interface
class RunnableImpl implements Runnable {

    public void run()
    {
        System.out.println("Hello World from a different thread than Main");
    }
}
public class RunnableExample{
    static ExecutorService executor = Executors.newFixedThreadPool(2);
    static ExecutorService executor1 = Executors.newSingleThreadExecutor();
    public static void main(String[] args){
        // Creating and running runnable task using Thread class
        RunnableImpl task = new RunnableImpl();
        Thread thread = new Thread(task);
        thread.start();
        // Creating and running runnable task using Executor Service.
        executor.submit(task);
    }
}

