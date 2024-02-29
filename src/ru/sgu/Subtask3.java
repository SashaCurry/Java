package ru.sgu;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Subtask3 {
    public static void run() {
        System.out.println("\nСчитывание данных из файла input.txt...");
        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNextLine()) {
                String[] str = scanner.nextLine().split(" ");
                if (str.length == 1 && str[0].isEmpty()) {
                    System.out.print("\n");
                    continue;
                }
                if (str.length < 3) {
                    System.out.println("...есть разные варианты...");
                    continue;
                }

                boolean flag = false;
                for (int i = 0; i < 3; i++) {
                    if (containsDigit(str[i])) {
                        flag = true;
                        break;
                    }
                }

                if (flag)
                    System.out.println("...есть разные варианты...");
                else {
                    System.out.println(str[1] + " " + str[0].charAt(0) + "." + str[2].charAt(0) + ".");
                }
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean containsDigit(String passCode){
        for (int i = 0; i < passCode.length(); i++) {
            if(Character.isDigit(passCode.charAt(i)))
                return true;
        }
        return false;
    }
}
