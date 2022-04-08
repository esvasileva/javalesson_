package core.lesson3;

import java.util.Arrays;

public class Box<T extends Fruit> {
    private T[] fruitBox;

    public Box(T... fruitBox) {
        this.fruitBox = fruitBox;
    }

    public T[] getFruitBox() {
        return fruitBox;
    }

    public void setFruitBox(T[] fruitBox) {
        this.fruitBox = fruitBox;
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitBox=" + Arrays.toString(getFruitBox()) +
                '}';
    }

    public float getWeight() {
        return fruitBox.length * fruitBox[0].getWeigh();
    }

    public boolean compare(Box<?> boxToCompare) {
        return getWeight() - boxToCompare.getWeight() == 0.0;
    }

    public void addFruit(T fruit) {
        Fruit[] fruitBoxNew = new Fruit[fruitBox.length + 1];
        for (int i = 0; i < fruitBox.length; i++) {
            fruitBoxNew[i] = fruitBox[i];
        }
        fruitBoxNew[fruitBox.length] = fruit;
        this.fruitBox = (T[]) fruitBoxNew;
    }
}
