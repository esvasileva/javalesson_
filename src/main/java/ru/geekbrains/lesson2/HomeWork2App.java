package ru.geekbrains.lesson2;

import static java.lang.System.*;

public class HomeWork2App {
    public static void main(String[] args) {
        out.printf("Task1\n----\n%s%n", checkSumSign10Between20(-10, 40));
        out.printf("----\nTask2\n----\n%s%n", checkNumberPosNegString(-15));
        out.printf("----\nTask3\n----\n%s%n", checkNumberPosNegBoolean(0));
    }

    static boolean checkSumSign10Between20(int a, int b) {
        return (a+b >= 10 && a+b <= 20);
    }

    static String checkNumberPosNegString(int c) {
        return ((c >= 0)? "Number positive":"Number negative");
    }

    static boolean checkNumberPosNegBoolean(int d) throws RuntimeException {
        if (d == 0)
            throw new RuntimeException("The number Zero is neither positive or negative");
        else return (d < 0);
    }
}



