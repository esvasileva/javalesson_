/**
 * Java 1. Home task 4
 *
 * @author Elena Vasileva
 * @version 19.02.2022
 */

package ru.geekbrains.lesson4;

import static java.lang.System.*;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    Random random;
    Scanner scanner;
    char[][] matrix;

    public static void main(String[] args) {
        new TicTacToe().game();

    }

    TicTacToe() {
        random = new Random();
        scanner = new Scanner(System.in);
        matrix = new char[3][3];
    }

    void game() {
        initMatrix();
        printMatrix();
        while (true) {
            turnHuman();
            if (checkWin('x')) {
               out.println("You WON!");
               break;
            }
            if (isTableFull()) {
                out.println("Sorry, DRAW...");
                break;
            }
            turnAI();
            printMatrix();
            if (checkWin('o')) {
                out.println("AI WON!");
                break;
            }
            if (isTableFull()) {
                out.println("Sorry, DRAW...");
                break;
            }
        }
        out.println("GAME OVER!");
        printMatrix();
    }

    void initMatrix() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                matrix[x][y] = '.';
            }
        }
    }

    void printMatrix() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                out.print(matrix[x][y] + " ");
            }
            out.println();
        }
    }

    void turnHuman() {
        int x ,y;
        do {
            out.println("Enter x y [1..3]: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        matrix[x][y] = 'x';
    }

    void turnAI() {
        int x ,y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        matrix[x][y] = 'o';
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }
        return matrix[x][y] == '.';
    }

    boolean checkWin(char ch) {
        //
        for (int x = 0; x < 3; x++) {
            if (matrix[x][0] == ch && matrix[x][1] == ch && matrix[x][2] == ch) return true;
            if (matrix[0][x] == ch && matrix[1][x] == ch && matrix[2][x] == ch) return true;
        }
        //if (matrix[0][0] == ch && matrix[0][1] == ch && matrix[0][2] == ch) return true;
        //if (matrix[1][0] == ch && matrix[1][1] == ch && matrix[1][2] == ch) return true;
        //if (matrix[2][0] == ch && matrix[2][1] == ch && matrix[2][2] == ch) return true;
        //
        //if (matrix[0][0] == ch && matrix[1][0] == ch && matrix[2][0] == ch) return true;
        //if (matrix[0][1] == ch && matrix[1][1] == ch && matrix[2][1] == ch) return true;
        //if (matrix[0][2] == ch && matrix[1][2] == ch && matrix[2][2] == ch) return true;
        //
        if (matrix[0][0] == ch && matrix[1][1] == ch && matrix[2][2] == ch) return true;
        if (matrix[2][0] == ch && matrix[1][1] == ch && matrix[0][2] == ch) return true;
        return false;
    }

    boolean isTableFull() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (matrix[x][y] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
