package ru.geekbrains.lesson7;

public class Lesson7 {
    public static void main(String[] args) {
        Cat[] cat = {new Cat("Cat1", 5),
                     new Cat("Cat2", 10),
                     new Cat("Cat3", 5),
                     new Cat("Cat4", 30)};
        //System.out.println(cat);

        Plate plate = new Plate(30);
        System.out.println(plate);

        for(Cat cats : cat) {
            cats.eat(plate);
            System.out.println(cats);
            System.out.println(plate);
        }

        plate.addFood(20);
        System.out.println("New " + plate);

        for(Cat cats : cat) {
            cats.eat(plate);
            System.out.println(cats);
            System.out.println(plate);
        }
    }
}
