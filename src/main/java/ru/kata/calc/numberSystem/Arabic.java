package ru.kata.calc.numberSystem;

public class Arabic extends NumberSystem {

    public Arabic(String value) {
        super(value);
    }

    public Arabic(int intValue) {
        super(intValue);
    }

    @Override
    public String convertIntValueToString(int intValue) {
        return String.valueOf(intValue);
    }

    @Override
    int convertStringValueToInt(String value) {
        return Integer.parseInt(value);
    }

    @Override
    NumberSystem inctanceOf(int value) {
        return new Arabic(value);
    }
}
