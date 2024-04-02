package ru.sgu;

import java.util.*;

public class Subtask3 {
    private String generateString() {
        char[] res = new char[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            res[i] = (char)rand.nextInt(1040, 1105);
        }
        return new String(res);
    }

    private long testString() {
        String str = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++)
            str += generateString();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long testStringBuffer() {
        StringBuffer str = new StringBuffer("");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++)
            str.append(generateString());
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long testStringBuilder() {
        StringBuilder str = new StringBuilder("");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++)
            str.append(generateString());
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        Subtask3 subtask3 = new Subtask3();

        long speedString = subtask3.testString();
        System.out.print("Скорость выполнения с типом String: ");
        System.out.println(speedString + "мс = " + Math.round(speedString / 1000.0) + "с");

        long speedStringBuffer = subtask3.testStringBuffer();
        System.out.print("Скорость выполнения с типом StringBuffer: ");
        System.out.println(speedStringBuffer + "мс = " + Math.round(speedStringBuffer / 1000.0) + "c");

        long speedStringBuilder = subtask3.testStringBuilder();
        System.out.print("Скорость выполнения с типом StringBuilder: ");
        System.out.println(speedStringBuilder + "мс = " + Math.round(speedStringBuilder / 1000.0) + "c");
    }
}
