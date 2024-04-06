package ru.sgu.Subtask3;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private final int countConsumers = 3;
    private final int timeWorkingProducer = 10000;
    private final int sizeQueue = 10;

    public void run() {
        BlockingQueue<Food> queue = new LinkedBlockingQueue<>(sizeQueue);

        Thread producer = new Thread(new Producer(queue));
        producer.start();

        ArrayList<Thread> consumers = new ArrayList<>();
        for (int i = 0; i < countConsumers; i++) {
            consumers.add(new Thread(new Consumer(queue)));
            consumers.get(i).start();
        }

        try {
            Thread.sleep(timeWorkingProducer);
            producer.interrupt();
            consumers.forEach(Thread::interrupt);
        }
        catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
