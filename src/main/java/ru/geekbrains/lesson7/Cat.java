/**
 * Java 1. Home task 7
 *
 * @author Elena Vasileva
 * @version 02.03.2022
 */

package ru.geekbrains.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    void eat(Plate plate) {
        if (plate.getFood() >= appetite && fullness != true) {
            plate.decreaseFood(appetite);
            fullness = true;
        }
    }

    @Override
    public String toString() {
        return "Cat: " + name + ", appetite: " + appetite + ", fullness: " + fullness;
    }
}
