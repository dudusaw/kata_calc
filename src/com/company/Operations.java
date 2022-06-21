package com.company;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

enum Operations {
    Sum((a, b) -> a + b, "+"),
    Diff((a, b) -> a - b, "-"),
    Mul((a, b) -> a * b, "*"),
    Div((a, b) -> a / b, "/");

    private BiFunction<Integer, Integer, Integer> func;
    private String symbol;

    public int calculate(int a, int b) {
        return func.apply(a, b);
    }

    public static int calculate(int a, int b, String operation) {
        for (Operations op : Operations.values()) {
            if (op.symbol.equals(operation)) {
                return op.calculate(a, b);
            }
        }
        throw new RuntimeException("нет такой операции");
    }

    public static String getAllSymbols() {
        return Arrays.stream(Operations.values()).map(op -> op.symbol).collect(Collectors.joining());
    }

    Operations(BiFunction<Integer, Integer, Integer> func, String symbol) {
        this.func = func;
        this.symbol = symbol;
    }
}
