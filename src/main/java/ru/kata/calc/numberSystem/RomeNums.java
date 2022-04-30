package ru.kata.calc.numberSystem;

import java.util.Arrays;
import java.util.Optional;

public enum RomeNums {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100);

    private final int intValue;

    RomeNums(int intValue) {
        this.intValue = intValue;
    }

    public static String getStringValue(int intValue) {
        Optional<RomeNums> optional = Arrays.stream(RomeNums.values()).filter(e -> e.intValue == intValue).findFirst();
        RomeNums romeNums = null;
        if (!optional.isEmpty()) {
            romeNums = optional.get();
        }
        return (romeNums == null) ? "" : romeNums.name();
    }

    public int getIntValue() {
        return intValue;
    }
}
