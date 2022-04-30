package ru.kata.calc.numberSystem;

import ru.kata.calc.CalcException;

public class Rome extends NumberSystem {
    private static final String[] rome = new String[]{"I", "V", "X", "L", "C"};
    private static final int[] arabic = new int[]{1, 5, 10, 50, 100};

    public Rome(String value) {
        super(value);
    }

    public Rome(int intValue) {
        super(intValue);
    }

    private static String convertArabicToRome(int value) {
        if (value > arabic[arabic.length - 1]) {
            throw new CalcException(String.format("Поддерживаются римские цифры только до %s (%s)", rome[rome.length - 1], arabic[arabic.length - 1]));
        }
        if (value == arabic[arabic.length - 1]) {
            return rome[rome.length - 1];
        }

        StringBuilder res = new StringBuilder(20);
        int arabNum = 0;
        res.append(convertToRome(value / 10, "X", "L", "C"));
        arabNum = value % 10;
        res.append(convertToRome(arabNum, "I", "V", "X"));
        return res.toString();
    }

    private static String convertToRome(int num, String low, String mid, String high) {
        switch (num) {
            case 9:
                return low + high;
            case 8:
                return mid + low + low + low;
            case 7:
                return mid + low + low;
            case 6:
                return mid + low;
            case 5:
                return mid;
            case 4:
                return low + mid;
            case 3:
                return low + low + low;
            case 2:
                return low + low;
            case 1:
                return low;
            default:
                return "";
        }
    }

    private static int convertRomeToArabic(String num) {
        String[] numArr = num.toUpperCase().split("");
        int arabicNum = 0;
        int prevArabicNum = 0;
        int curNum = 0;

        for (int i = 0; i < numArr.length; i++) {
            curNum = RomeNums.valueOf(numArr[i]).getIntValue();
            arabicNum += (curNum > prevArabicNum && prevArabicNum != 0) ? -prevArabicNum : prevArabicNum;
            prevArabicNum = curNum;
        }
        arabicNum += curNum;

        return arabicNum;
    }

    @Override
    public int convertStringValueToInt(String value) {
        return convertRomeToArabic(value);
    }

    @Override
    public String convertIntValueToString(int intValue) {
        return convertArabicToRome(intValue);
    }

    @Override
    public NumberSystem inctanceOf(int value) {
        if (value < 1) {
            throw new CalcException("Отрицательные числа и ноль не поддерживаются");
        }
        return new Rome(value);
    }


}
