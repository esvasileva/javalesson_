/**
 * Java 1. Home task 5
 *
 * @author Elena Vasileva
 * @version 22.02.2022
 */

package ru.geekbrains.lesson5;

import static java.lang.System.*;

public class Lesson5 {
    public static void main(String[] args) {
        Worker[] workerArr = new Worker[5];
        workerArr[0] = new Worker("Ivanov Ivan Ivanovich",
                                  "Junior QA",
                                  "email1@email.ru",
                                  "89999999999",
                                  10000,
                                  (byte) 23);
        workerArr[1] = new Worker("Petrov Petr Petrovich",
                                  "QA Engineer",
                                  "email2@email.ru",
                                  "89999998888",
                                  152350,
                                  (byte) 41);
        workerArr[2] = new Worker("Ivanova Liza Petrovna",
                                  "Lead QA",
                                  "email3@email.ru",
                                  "89569999999",
                                  250600,
                                  (byte) 32);
        workerArr[3] = new Worker("Simonov Sergey Nikolaevich",
                                  "Senior QA",
                                  "email4@email.ru",
                                  "89999859999",
                                  200800,
                                  (byte) 30);
        workerArr[4] = new Worker("Smirnov Nikolay Ivanovich",
                                  "CEO",
                                  "email5@email.ru",
                                  "89999985623",
                                  1000000,
                                  (byte) 45);
        //--------Worker.age > 40------
        for (int i = 0; i < 5; i++) {
            if (workerArr[i].getAge() > 40) out.println(workerArr[i]);
        }
    }
}
