package ru.sgu;

import java.util.*;

public class Subtask3 {
    private final int codeRussianSymbolsStart = 1040;
    private final int codeRussianSymbolsEnd = 1105;
    private final double millisecondsPerSecond = 1000;
    private final int countSymbols = 10;
    private final int countContacenate = 100_000;

    private String generateString() {
        char[] res = new char[countSymbols];
        Random rand = new Random();
        for (int i = 0; i < countSymbols; i++) {
            res[i] = (char)rand.nextInt(codeRussianSymbolsStart, codeRussianSymbolsEnd);
        }
        return new String(res);
    }

    private long testString() {
        String str = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < countContacenate; i++)
            str += generateString();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long testStringBuffer() {
        StringBuffer str = new StringBuffer();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < countContacenate; i++)
            str.append(generateString());
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long testStringBuilder() {
        StringBuilder str = new StringBuilder();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < countContacenate; i++)
            str.append(generateString());
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        Subtask3 subtask3 = new Subtask3();

        long speedString = subtask3.testString();
        System.out.print("Скорость выполнения с типом String: ");
        System.out.println(speedString + "мс = " + Math.round(speedString / subtask3.millisecondsPerSecond) + "с");

        long speedStringBuffer = subtask3.testStringBuffer();
        System.out.print("Скорость выполнения с типом StringBuffer: ");
        System.out.println(speedStringBuffer + "мс = " + Math.round(speedStringBuffer / subtask3.millisecondsPerSecond) + "c");

        long speedStringBuilder = subtask3.testStringBuilder();
        System.out.print("Скорость выполнения с типом StringBuilder: ");
        System.out.println(speedStringBuilder + "мс = " + Math.round(speedStringBuilder / subtask3.millisecondsPerSecond) + "c");
    }
}
