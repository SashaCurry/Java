package ru.sgu.Subtask3;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private final BlockingQueue<Food> queue;
    private int sumCalories = 0;

    public Consumer(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Food eatenFood = queue.take();
                sumCalories += eatenFood.getCalories();
                synchronized (System.out) {
                    System.out.print("Потребитель: " + Thread.currentThread().getName());
                    System.out.print(", Съеденная еда: " + eatenFood.getName());
                    System.out.println(", Суммарное количество калорий: " + sumCalories);
                }
                Thread.sleep(400);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }
}
