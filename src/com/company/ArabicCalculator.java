package com.company;

class ArabicCalculator implements Calculator{
    @Override
    public String calculate(String leftOperand, String rightOperand, String operationSymbol) {
        return String.valueOf(Operations.calculate(Integer.parseInt(leftOperand), Integer.parseInt(rightOperand), operationSymbol));
    }
}
