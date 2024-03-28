package ru.sgu;

import java.util.*;
import java.util.stream.*;

public class Subtask2 {
    public List<Integer> inputData() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целочисленные значения: ");

        List<Integer> res = new ArrayList<>();
        String[] params = in.nextLine().split(" ");
        for (String param : params)
            res.add(Integer.parseInt(param));

        in.close();
        return res;
    }

    public void findMinAndMax(List<Integer> data) {
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        for (Integer num : data)
            streamBuilder.add(num);
        Stream<Integer> numStream = streamBuilder.build();

        List<Integer> numList = numStream.sorted().distinct().toList();
        System.out.print("Отсортированный массив: ");
        for (Integer num : numList)
            System.out.print(num + " ");

        System.out.println("\nВторой наибольший элемент: " + numList.get(numList.size() - 2));
        System.out.println("Третий наименьший элемент: " + numList.get(2));
    }

    public void run() {
        try {
            List<Integer> data = inputData();
            findMinAndMax(data);
        }
        catch (NumberFormatException e) {
            System.out.println("Ошибка: Значение указано неверно!");
        }
        catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Subtask2 subtask2 = new Subtask2();
        subtask2.run();
    }
}
