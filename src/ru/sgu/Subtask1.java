package ru.sgu;

import java.text.*;
import java.util.*;

public class Subtask1 {
    private Date date1, date2;
    private long countDays;

    private boolean checkCorrectDate(String date) {
        String[] mas = date.split(" ");
        if (mas.length != 3)
            return false;

        int year = Integer.parseInt(mas[0]), month = Integer.parseInt(mas[1]), day = Integer.parseInt(mas[2]);
        return year > 0 && month > 0 && month < 13 && day > 0 && day < 32;
    }

    private void inputData() throws Exception{
        Scanner in = new Scanner(System.in);

        System.out.print("Первая дата в формате \"год месяц день\": ");
        String date1 = in.nextLine();
        System.out.print("Вторая дата в формате \"год месяц день\": ");
        String date2 = in.nextLine();

        if (!checkCorrectDate(date1) || !checkCorrectDate(date2))
            throw new Exception();

        DateFormat df = new SimpleDateFormat("yyyy M d");
        this.date1 = df.parse(date1);
        this.date2 = df.parse(date2);

        in.close();
    }

    private void calculateDifference() {
        final double millisecondsPerDay = 1000 * 60 * 60 * 24;
        countDays = Math.abs(Math.round((date1.getTime() - date2.getTime()) / millisecondsPerDay));
    }

    public void run() {
        for (;;) {
            try {
                inputData();
                calculateDifference();
                System.out.println("Разница в днях: " + countDays);
                return;
            } catch (Exception e) {
                System.out.print("Неправильный формат даты! ");
                System.out.println("Введите дату в формате \"год месяц день\" (напр., 2024 04 02)\n");
            }
        }
    }

    public static void main(String[] args) {
        Subtask1 subtask1 = new Subtask1();
        subtask1.run();
    }
}
