package ru.kata;

import ru.kata.calc.CalcFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите математическую операцию: ");

        Scanner consoleInput = new Scanner(System.in);
        String inputStr = consoleInput.nextLine();

        System.out.println(calc(inputStr));
    }


    public static String calc(String input) {
        return CalcFactory.calc(input);
    }
}
