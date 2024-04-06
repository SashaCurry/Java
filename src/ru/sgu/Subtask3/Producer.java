package ru.sgu.Subtask3;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private final BlockingQueue<Food> queue;

    public Producer(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Food food = new Food();
                queue.put(food);
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }
}
