package core.lesson1;

public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("Катя", 20, 25);
        Human human2 = new Human("Петя", 10, 15);
        Human human3 = new Human("Дима", 20, 15);
        Human human4 = new Human("Вова", 50, 5);

        Team team1 = new Team("First", 4, new Human[]{human1, human2, human3, human4});
        System.out.println(team1);

        System.out.println("--------Первая дистанция----------");
        Course course1 = new Course(5,5);
        course1.doIt(team1);
        team1.showResults();

        System.out.println("--------Вторая дистанция----------");
        Course course2 = new Course(20,15);
        course2.doIt(team1);
        team1.showResults();
    }
}
