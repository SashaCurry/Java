package ru.sgu;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class Subtask2 {
    public static void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n\tОперации с большими вещественными числами");
        System.out.print("Введите 2 числа и операцию (ADD, SUB, MULT, DIV, REM, POW): ");

        String[] params = in.nextLine().split(" ");
        if (params.length != 3) {
            System.out.println("Неверное количество параметров!");
            return;
        }

        BigDecimal num1, num2;
        try {
            num1 = new BigDecimal(params[0]);
            num2 = new BigDecimal(params[1]);
        }
        catch (NumberFormatException error) {
            System.out.println("Ошибка при вводе чисел!");
            return;
        }
        String action = params[2];

        switch(action) {
            case "ADD":
                System.out.println("Результат: " + num1.add(num2));
                break;
            case "SUB":
                System.out.println("Результат: " + num1.subtract(num2));
                break;
            case "MULT":
                System.out.println("Результат: " + num1.multiply(num2));
                break;
            case "DIV":
                System.out.println("Результат: " + num1.divide(num2, RoundingMode.HALF_UP));
                break;
            case "REM":
                System.out.println("Результат: " + num1.remainder(num2));
                break;
            case "POW":
                try {
                    BigInteger num = new BigInteger(params[0]);
                    int deg = Integer.parseInt(params[1]);
                    System.out.println("Результат: " + num.pow(deg));
                }
                catch (NumberFormatException error) {
                    System.out.println("Для операции POW необходимо указать целые числа!");
                }
                break;
            default:
                System.out.println("Отсутствует указанная операция!");
        }
        in.close();
    }
}
