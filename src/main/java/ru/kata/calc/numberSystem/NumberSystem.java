package ru.kata.calc.numberSystem;

public abstract class NumberSystem {
    private final String value;
    private final int intValue;

    NumberSystem(int intValue) {
        this.value = convertIntValueToString(intValue);
        this.intValue = intValue;
    }

    NumberSystem(String value) {
        this.value = value;
        this.intValue = convertStringValueToInt(value);
    }

    public String getValue() {
        return value;
    }

    public int getIntValue() {
        return intValue;
    }

    abstract String convertIntValueToString(int intValue);
    abstract int convertStringValueToInt(String value);
    abstract NumberSystem inctanceOf(int value);


    public NumberSystem doAddition(NumberSystem param) {
        int res = getIntValue() + param.getIntValue();
        return inctanceOf(res);
    }

    public NumberSystem doDivision(NumberSystem param) {
        int res = getIntValue() + param.getIntValue();
        return inctanceOf(res);
    }

    public NumberSystem doMultiplication(NumberSystem param) {
        int res = getIntValue() + param.getIntValue();
        return inctanceOf(res);
    }

    public NumberSystem doSubtraction(NumberSystem param) {
        int res = getIntValue() + param.getIntValue();
        return inctanceOf(res);
    }
}
