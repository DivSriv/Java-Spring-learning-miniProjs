package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 public class MyRunnable implements Runnable {
    private final String task;

    MyRunnable(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Executing "+ task +" with "+Thread.currentThread().getName());
        }
        System.out.println();
    }
}

class Exec2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            System.out.println("i is incremented");
            Runnable worker = new MyRunnable("Task" + i);
            executor.execute(worker);
        }
        executor.shutdown();
    }
}