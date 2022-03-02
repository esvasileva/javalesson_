/**
 * Java 1. Home task 6
 *
 * @author Elena Vasileva
 * @version 26.02.2022
 */

package ru.geekbrains.lesson6;

import static java.lang.System.*;

public class Lesson6 {
    public static void main(String[] args) {
        IAnimals[] animals = {new Cat (200),
                              new Dog (500, 10)
        };
        for (IAnimals animals1: animals) {
            animals1.run(20);
            animals1.swim(20);
        }
    }
}
