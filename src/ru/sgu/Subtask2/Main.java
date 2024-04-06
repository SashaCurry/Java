package ru.sgu.Subtask2;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;

        for (;;) {
            try {
                System.out.print("Введите число N: ");
                N = in.nextInt();

                if (N <= 0)
                    System.out.println("Число N должно быть больше 0!\n");
                else
                    break;
            }
            catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных!\n");
                in.nextLine();
            }
        }

        Fibonacci fibonacci = new Fibonacci(N);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(N + "-е число Фибоначчи: " + forkJoinPool.invoke(fibonacci));

        in.close();
    }
}
