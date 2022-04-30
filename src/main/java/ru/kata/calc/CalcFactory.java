package ru.kata.calc;

import ru.kata.calc.numberSystem.Arabic;
import ru.kata.calc.numberSystem.NumberSystem;
import ru.kata.calc.numberSystem.Rome;

public class CalcFactory {
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 10;

    public static String calc(String line) {
        String stripedLine = line.strip().replaceAll(" ", "");
        Operation operation = extracktOperation(stripedLine);
        String[] numbers = extractNumberts(stripedLine, operation);
        NumberSystem[] numberSystems = createNumberSystemArr(numbers);
        checkNumberSystemArr(numberSystems);

        Calc calc = new Calc(numberSystems[0], numberSystems[1], operation);

        return calc.calculate().getValue();
    }

    private static String[] extractNumberts(String line, Operation operation) {
        String[] numbers = line.split("[" + operation.getOperationSymbol() + "]");
        if (numbers.length < 2) {
            throw new CalcException("Неверное выражение");
        } else if (numbers.length > 2) {
            throw new CalcException("Формат математической операции не удовлетворяет заданию");
        }
        return numbers;
    }

    private static Operation extracktOperation(String line) {
        Operation findedOper = null;
        for (Operation oper : Operation.values()) {
            if (line.contains(oper.getOperationSymbol())) {
                findedOper = oper;
                break;
            }
        }
        if (findedOper == null) {
            throw new CalcException("Отсутствует математическая операция");
        }
        return findedOper;
    }


    public static NumberSystem[] createNumberSystemArr(String[] numberStrArr) {
        NumberSystem[] numberSystems = new NumberSystem[numberStrArr.length];

        for (int i = 0; i < numberStrArr.length; i++) {
            String numberStr = numberStrArr[i];
            if (numberStr.matches("[0-9]+")) {
                numberSystems[i] = new Arabic(numberStr);
            } else if (numberStr.matches("[IVXLC]+")) {
                numberSystems[i] = new Rome(numberStr);
            } else {
                throw new CalcException("Невозможно определить систему счисления");
            }
        }
        return numberSystems;
    }

    private static void checkNumberSystemArr(NumberSystem[] numberSystems) {
        if (!numberSystems[0].getClass().equals(numberSystems[1].getClass())) {
            throw new CalcException("Нельзя использовать разные системы счисления");
        }
        for (NumberSystem num : numberSystems) {
            int curVal = num.getIntValue();
            if (curVal < MIN_VAL || curVal > MAX_VAL) {
                throw new CalcException(String.format("Введенные числа выходят за" +
                        " диапазон допустимых значений: [%s,%s]", MIN_VAL, MAX_VAL));
            }
        }


    }

}




