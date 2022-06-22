package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(calc(line));
    }

    public static String calc(String input) {
        String[] split = input.split(" ");
        if (split.length != 3) {
            throw new RuntimeException("неверный формат");
        }
        String leftOperand = split[0];
        String operationSymbol = split[1];
        String rightOperand = split[2];

        boolean isRoman = checkRoman(leftOperand, rightOperand);
        Calculator calculator;

        if (isRoman) {
            calculator = new RomanCalculator();
        } else {
            calculator = new ArabicCalculator();
        }

        return calculator.calculate(leftOperand, rightOperand, operationSymbol);
    }

    private static boolean checkRoman(String leftOperand, String rightOperand) {
        boolean isLeftRoman = RomanNumber.isRoman(leftOperand);
        boolean isRightRoman = RomanNumber.isRoman(rightOperand);
        if (isLeftRoman != isRightRoman) {
            throw new RuntimeException("типы операндов не совпадают");
        }
        return isLeftRoman;
    }
}
