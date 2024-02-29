package ru.sgu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\tЗадание 1 \n1 - Простейшее приложение с выводом Hello World");
        System.out.println("2 - Операции с большими числами \n3 - Ввод/вывод из файла \n4 - Выход");
        String choice = in.next();

        switch(choice) {
            case "1":
                Subtask1.run();
                break;
            case "2":
                Subtask2.run();
                break;
            case "3":
                Subtask3.run();
                break;
            default:
                return;
        }
        in.close();
    }
}