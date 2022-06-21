package com.company;

class RomanCalculator implements Calculator {
    @Override
    public String calculate(String leftOperand, String rightOperand, String operationSymbol) {
        int result = Operations.calculate(RomanNumber.toArabic(leftOperand), RomanNumber.toArabic(rightOperand), operationSymbol);
        if (result < 0) {
            throw new RuntimeException("результат римских операций не может быть меньше 0");
        }
        return RomanNumber.toRoman(result);
    }
}
