package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(calc("III + II"));
        System.out.println(calc("IV + I"));
        System.out.println(calc("V * I"));
        System.out.println(calc("X / II"));
        System.out.println(calc("X / III"));
        System.out.println(calc("X - III"));
        System.out.println(calc("XXIX - X"));
        System.out.println(calc("10 - 10"));
        System.out.println(calc("10 - 20"));
        System.out.println(calc("2 * 2"));
        System.out.println(calc("2 / 2"));
        //System.out.println(calc("3 * I"));
        //System.out.println(calc("V - X"));
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
