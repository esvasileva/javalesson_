package ru.geekbrains.lesson6;

public class Cat extends Animals {

    Cat(int maxLengthRun) { super(maxLengthRun, 0); }

    @Override
    public void swim(int lengthSwim) {
        System.out.println("Cat doesn't swim");
    }
}
