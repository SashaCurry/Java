package ru.sgu.Subtask1;

import java.io.*;
import java.util.*;

public class Main {
    private String fileName;
    private ArrayList<Company> companies = new ArrayList<>();
    private final String dataFile = "Shares.txt";
    private final String formatTXT = ".txt";

    private void getFile() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название файла, из которого считать данные (по умолчанию " + dataFile + "): ");
        fileName = in.nextLine();

        if (fileName.isEmpty())
            fileName = dataFile;
        else if (!fileName.endsWith(formatTXT))
            fileName = fileName + formatTXT;

        in.close();
        this.fileName = fileName;
    }

    private void readData() throws FileNotFoundException{
        Scanner inFile = new Scanner(new File(fileName));
        while(inFile.hasNextLine()) {
            String str = inFile.nextLine();
            Company company = new Company(str);
            if (!companies.contains(company))
                companies.add(company);
        }

        Collections.sort(companies);
        System.out.println("Отсортированный рейтинг компаний: ");
        for (Company company : companies)
            System.out.println("\t" + company);
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.getFile();
            main.readData();
        } catch (FileNotFoundException e) {
            System.out.println("Данного файла не существует в каталоге!");
        }
    }
}
