package ru.geekbrains.lesson6;

public class Dog extends Animals {

    Dog(int maxLengthRun, int maxLengthSwim) {
        super(maxLengthRun, maxLengthSwim);
    }

    @Override
    public String toString() {
        return "Dog";
    }

}
