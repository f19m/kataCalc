package ru.kata.calc;

import ru.kata.calc.numberSystem.NumberSystem;

class Calc {
    private final NumberSystem firstNumber;
    private final NumberSystem secondNumber;
    private final Operation operation;

    public Calc(NumberSystem firstNumber, NumberSystem secondNumber, Operation operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }


    public NumberSystem calculate() {
        switch (operation) {
            case addition:
                return firstNumber.doAddition(secondNumber);
            case division:
                return firstNumber.doDivision(secondNumber);
            case multiplication:
                return firstNumber.doMultiplication(secondNumber);
            case subtraction:
                return firstNumber.doSubtraction(secondNumber);
            default:
                throw new CalcException("Неизвестная операция");
        }

    }


}
