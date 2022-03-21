package core.lesson1;

public class Human {
    final private String name;
    private int maxDistanceOfRun;
    private int maxDistanceOfJump;

    Human (String name, int maxDistanceOfRun, int maxDistanceOfJump){
        this.name = name;
        this.maxDistanceOfRun = maxDistanceOfRun;
        this.maxDistanceOfJump = maxDistanceOfJump;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n" + "Максимальная длина бега: " + maxDistanceOfRun + "\n" +
                "Максимальная высота прыжка: " + maxDistanceOfJump + "\n";
    }

    public String getName() {
        return name;
    }

    public int getMaxDistanceOfJump() {
        return maxDistanceOfJump;
    }

    public int getMaxDistanceOfRun() {
        return maxDistanceOfRun;
    }

    public void setMaxDistanceOfRun(int maxDistanceOfRun) {
        if (maxDistanceOfRun < 0) {
            this.maxDistanceOfRun = maxDistanceOfRun;
        } else System.out.println("Введите корректное значение!");
    }

    public void setMaxDistanceOfJump(int maxDistanceOfJump) {
        if (maxDistanceOfJump < 0) {
            this.maxDistanceOfJump = maxDistanceOfJump;
        } else System.out.println("Введите корректное значение!");
    }

}
