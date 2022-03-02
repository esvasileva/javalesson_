package ru.geekbrains.lesson7;

public class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int food) {
        if ((this.food - food) >= 0) {
            this.food -= food;
        }
    }

    void addFood(int plusFood) {
        this.food = food + plusFood;
    }

    int getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}
