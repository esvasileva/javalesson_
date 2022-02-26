/**
 * Java 1. Home task 6
 *
 * @author Elena Vasileva
 * @version 26.02.2022
 */

package ru.geekbrains.lesson6;

interface IAnimals {
    void run(int lengthRun);
    void swim(int lengthSwim);
}

public abstract class Animals implements IAnimals {
    protected int maхLengthRun;
    protected int maxLengthSwim;

    Animals (int maхLengthRun, int maxLengthSwim) {
        this.maхLengthRun = maхLengthRun;
        this.maxLengthSwim = maxLengthSwim;
    }

    public int getMaхLengthRun() {
        return maхLengthRun;
    }

    public int getMaxLengthSwim() {
        return maxLengthSwim;
    }

    public void run(int lengthRun) {
        if (lengthRun <= getMaхLengthRun() && lengthRun > 0) {
            System.out.println(getClass().getSimpleName() + " running: " + lengthRun);
        } else {
            System.out.println ("Enter the correct value 'lengthRun'");
        }
    }

    public void swim(int lengthSwim) {
        if (lengthSwim <= getMaxLengthSwim() && lengthSwim > 0 ) {
            System.out.println(getClass().getSimpleName() + " swimming: " + lengthSwim);
        } else {
            System.out.println("Enter the correct value 'lengthSwim'");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
