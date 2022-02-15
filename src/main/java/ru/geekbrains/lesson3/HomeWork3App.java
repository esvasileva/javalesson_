/**
 * Java 1. Home task 2
 *
 * @author Elena Vasileva
 * @version 15.02.2022
 */

package ru.geekbrains.lesson3;

import static java.lang.System.*;
import java.util.Arrays;
import java.util.Random;

public class HomeWork3App {
    public static void main(String[] args) {
        //-------------------Task1-------------------
        int[] arr1 = {0, 1, 0, 1, 1, 0, 1, 0};
        out.print(Arrays.toString(arr1) + "\n");
        out.print(Arrays.toString(changeArray10(arr1)) + "\n");
        //-------------------Task2-------------------
        int[] arr2 = new int[100];
        out.print(Arrays.toString(arrayAssignment1100(arr2)) + "\n");
        //-------------------Task3-------------------
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        out.print(Arrays.toString(arr3) + "\n");
        out.print(Arrays.toString(arrayMultiplication(arr3)) + "\n");
        //-------------------Task4-------------------
        int table4Size = 15;
        int[][] table4 = new int[table4Size][table4Size];
        table4 = arrayDiagonalAssignment(table4);
        for (int i = 0; i < table4.length; i++) {
            out.println(Arrays.toString(table4[i]));
        }
        //-------------------Task5-------------------
        out.print(Arrays.toString(arrayInitial(4,50)) + "\n");
        out.print(Arrays.toString(arrayInitial(0,25)) + "\n");
        out.print(Arrays.toString(arrayInitial(40,-1)) + "\n");
        out.print(Arrays.toString(arrayInitial(-2,-1)) + "\n");
        //-------------------Task6-------------------
        int array6Size = 15, vars = 0;
        int[] array6 = new int[array6Size];
        Random random = new Random();
        for (int i = 0; array6Size > i; i++) {
            vars = random.nextInt(40);
            array6[i] = vars;
        }
        out.println(Arrays.toString(array6));
        int[] minMax = new int[2];
        minMax = arrayMinMax(array6);
        out.println("Minimum:" + minMax[0] + " " + "Maximum:" + minMax[1]);
        //-------------------Task7--------------------
        int array7Size = 6;
        int[] array7 = new int[array7Size];
        for (int i = 0; array7Size > i; i++) {
            vars = random.nextInt(15);
            array7[i] = vars;
        }
        out.println(Arrays.toString(array7));
        out.println(checkBalance(array7));
        //-------------------Task8--------------------
        out.println("--------Task8--------");
        out.println("Array without cyclic shift:  " + Arrays.toString(array7));
        out.println(Arrays.toString(arrayCyclicShift(array7, 5)));
        out.println(Arrays.toString(arrayCyclicShift(array7, 7)));
        out.println(Arrays.toString(arrayCyclicShift(array7, -5)));
        out.println(Arrays.toString(arrayCyclicShift(array7, -6)));
    }

    static int[] changeArray10(int[] array01) {
        for(int i = 0; array01.length > i; i++) {
            if (array01[i] == 1) array01[i] = 0;
            else array01[i] = 1;
        }
        return array01;
    }

    static int[] arrayAssignment1100(int[] array1100) {
        for(int i = 0; array1100.length > i; i++) {
            array1100[i] = i+1;
        }
        return array1100;
    }

    static int[] arrayMultiplication(int[] array6) {
        for (int i = 0; array6.length > i; i++) {
            if (array6[i] < 6) array6[i] = array6[i]*2;
        }
        return array6;
    }

    static int[][] arrayDiagonalAssignment(int[][] matrix) {
        for (int i = 0, j = 0; matrix.length > i && matrix[i].length > j; i++, j++) {
            if (i == j) matrix[i][j] = 1;
            matrix[i][matrix.length-(i+1)] = 1;
        }
        return matrix;
    }

    static int[] arrayInitial(int len, int initialValue) {
        if (len < 0) len = 0;
        int[] array = new int[len];
        for (int i = 0; len > i; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    static int[] arrayMinMax(int[] array) {
        int[] minMax = new int[2];
        minMax[0] = array[0];
        minMax[1] = array[1];
        for (int i = 0; array.length > i; i++) {
            if (array[i] < minMax[0]) minMax[0] = array[i];
            if (array[i] > minMax[1]) minMax[1] = array[i];
        }
        return minMax;
    }

    static boolean checkBalance(int[] arrayBalance) {
        int sumFirst = 0, sumSecond = 0;
        while (true) {
            for (int i = 0; arrayBalance.length > i+1; i++) {
                sumFirst = sumFirst + arrayBalance[i];
                sumSecond = 0;
                for (int j = i+1; arrayBalance.length > j; j++) {
                    sumSecond = sumSecond + arrayBalance[j];
                }
                if (sumFirst == sumSecond) return true;
            }
            return false;
        }
    }

    static int[] arrayCyclicShift(int[] array, int shift) {
        int [] arrayShift = new int[array.length];
        int b = 0;
        if (shift >= array.length || (array.length + shift) <= 0) {
            out.println("Var \"shift\" must be less array.length. Return unchanged array: ");
            return array;
        }
        if (shift > 0) {
            for (int i = 0; array.length > i; i++) {
                if (shift + i < array.length) arrayShift[shift + i] = array[i];
                else {
                    b = array.length - i;
                    arrayShift[shift - b] = array[i];
                }
            }
        } else {
            for (int i = array.length - 1; i >= 0; i--) {
                if (shift + i >= 0) arrayShift[i + shift] = array[i];
                else {
                    b = i + shift;
                    arrayShift[array.length + b] = array[i];
                }
            }
        }
        return arrayShift;
    }
}
