package core.lesson3;



public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>(new Apple(1), new Apple(1), new Apple(1));
        System.out.println(appleBox);

        Box<Orange> orangeBox = new Box<>(new Orange(1), new Orange(1), new Orange(1));
        System.out.println(orangeBox);


        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println("Коробки равны? - " + appleBox.compare(orangeBox));

        appleBox.addFruit(new Apple(1));
        System.out.println(appleBox);
        System.out.println(appleBox.getWeight());

        orangeBox.addFruit(new Orange(1));
        System.out.println(orangeBox);
        System.out.println(orangeBox.getWeight());

        appleBox.addFruit(new Apple(1));
        appleBox.addFruit(new Apple(1));
        System.out.println(appleBox);
        System.out.println(appleBox.getWeight());
        System.out.println("Коробки равны? - " + appleBox.compare(orangeBox));
    }
}
