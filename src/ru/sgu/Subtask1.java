package ru.sgu;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;


public class Subtask1 {
    public List<Integer> inputData() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целочисленные значения: ");

        List<Integer> res = new ArrayList<>();
        String[] params = in.nextLine().split(" ");
        for (String param : params)
            res.add(Integer.parseInt(param));

        in.close();
        return res;
    }

    public void filteringStream(List<Integer> data) {
        Stream.Builder<Integer> numBuilder = Stream.builder();
        for (Integer num : data)
            numBuilder.add(num);
        Stream <Integer> numStream = numBuilder.build();

        Predicate<Integer> isOddNumber = x -> x % 2 == 1;
        System.out.print("Отфильтрованный поток: ");
        numStream.filter(isOddNumber).forEach(x -> System.out.print(x + " "));
    }

    public void run() {
        try {
            List<Integer> data = inputData();
            filteringStream(data);
        }
        catch (NumberFormatException e) {
            System.out.println("Значение указано неверно!");
        }
    }

    public static void main(String[] args) {
        Subtask1 subtask1 = new Subtask1();
        subtask1.run();
    }
}
