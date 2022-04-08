package core.lesson2;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        int size = 4;
        String[][] arrayString = new String[size][size];
        for (int i = 0; i < arrayString.length; i++) {
            for (int j = 0; j < arrayString[i].length; j++) {
                arrayString[i][j] = "1";
            }
        }
        try {
            out.println("Сумма равна " + changeToInt(arrayString));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        size += size;
        String[][] arrayString1 = new String[size][size];
        for (int i = 0; i < arrayString.length; i++) {
            for (int j = 0; j < arrayString[i].length; j++) {
                arrayString[i][j] = "23";
            }
        }
        try {
            out.println(changeToInt(arrayString1));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        arrayString = new String[][] {{"1", "2", "3", "4"}, {"a", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            out.println(changeToInt(arrayString));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }


    }

    public static int changeToInt(String arrayString2[][]) throws MyArraySizeException, MyArrayDataException{

        if(arrayString2.length > 4 && arrayString2[0].length > 4 ) {
            throw new MyArraySizeException("Размер массива должен быть 4х4!!! \n " +
                                           "Ваш массив имеет размер: " + arrayString2.length +
                                           "x" + arrayString2[0].length);
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arrayString2[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException ("Не число в элементе массива! Строка: "+ (i+1) + ", столбец: " + (j+1));
                }
            }
        }
        return sum;
    }
}
