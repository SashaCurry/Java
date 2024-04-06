package ru.sgu;

public class Subtask1 {
    private volatile int var = 555;
    private final int countIncrement = 100_000;

    synchronized void increment() {
        var++;
    }

    public void run() {
        System.out.println(" Начальное значение переменной var: " + var);

        Thread thread = new Thread( ()-> {
            for (int i = 0; i < countIncrement; i++)
                increment();
        } );
        thread.start();

        for (int i = 0; i < countIncrement; i++)
            increment();

        try {
            thread.join();
        }
        catch (InterruptedException ignored) {}

        System.out.println("Итоговое значение переменной var: " + var);
    }

    public static void main(String[] args) {
        Subtask1 subtask1 = new Subtask1();
        subtask1.run();
    }
}
