package ru.sgu;

import java.util.*;

public class Subtask2 {
    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
    }

    public void run() {
        Scanner in = new Scanner(System.in);

        for (;;) {
            try {
                System.out.print("Введите день недели и количество дней: ");
                DayOfWeek dayOfWeek = DayOfWeek.valueOf(in.next().toUpperCase());

                int days = in.nextInt();
                if (days < 0) {
                    System.out.println("Количество дней не может быть отрицательным!\n");
                    continue;
                }

                DayOfWeek[] week = DayOfWeek.values();
                DayOfWeek newDayOfWeek = week[(dayOfWeek.ordinal() + days) % 7];
                System.out.print("День недели через " + days + " дней: " + newDayOfWeek.toString().toLowerCase());
                break;
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных!\n");
                in.nextLine();
            }
        }

        in.close();
    }

    public static void main(String[] args) {
        Subtask2 subtask2 = new Subtask2();
        subtask2.run();
    }
}
