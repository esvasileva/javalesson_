package ru.geekbrains.lesson1;

import static java.lang.System.*;

public class HomeWork1App {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    static void printThreeWords() {
        out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign() {
        int a = -5, b = 0;
        out.println((a + b) >= 0? "Сумма положительная" : "Сумма отрицательная");
    }

    static void printColor() {
        int value = 101;
        if (value <= 0) {
            out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            out.println("Желтый");
        }
        if (value > 100) out.println("Зеленый");
    }

    static void compareNumbers() {
        int a = 1000, b = 1000;
        out.println(a >= b? "a >= b" : "a < b");
    }
}
