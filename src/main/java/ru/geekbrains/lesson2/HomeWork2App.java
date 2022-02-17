/**
 * Java 1. Home task 2
 *
 * @author Elena Vasileva
 * @version 13.02.2022
 */

package ru.geekbrains.lesson2;

import static java.lang.System.*;

public class HomeWork2App {
    public static void main(String[] args) {
        out.printf("Task1\n----\n%s%n", checkSumSign10Between20(-10, 40));
        out.println("----\nTask2\n----");
        checkNumberPosNegString(-15);
        out.printf("----\nTask3\n----\n%s%n", checkNumberPosNegBoolean(-8));
        out.println("----\nTask4\n----");
        printStringCount("It's work", 23);
        out.printf("----\nTask5\n----\n%s%n", checkLeapYear(1602));
    }

    static boolean checkSumSign10Between20(int number1, int number2) {
        return (number1+number2 >= 10 && number1+number2 <= 20);
    }

    static void checkNumberPosNegString(int numbers) {
        out.println((numbers >= 0) ? "Number positive" : "Number negative");
    }

    static boolean checkNumberPosNegBoolean(int numberb) {
        return (numberb < 0);
    }

    static void printStringCount(String text, int count) {
        for(int i = 0; i < count; i++) out.println(text);
    }

    static boolean checkLeapYear(int year) {
        return ((year%4 == 0 && year%100 != 0) || (year%400 == 0 && year%100 == 0));
    }
}



