package ru.sgu.Subtask2;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    private int num;

    public Fibonacci(int num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if (num <= 1)
            return num;

        Fibonacci fibonacciPart1 = new Fibonacci(num - 1);
        Fibonacci fibonacciPart2 = new Fibonacci(num - 2);

        fibonacciPart1.fork();
        fibonacciPart2.fork();

        return fibonacciPart1.join() + fibonacciPart2.join();
    }
}
