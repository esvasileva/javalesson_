package core.lesson9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StudentsAndCourse> studentsAndCourseList = new ArrayList<>();

        studentsAndCourseList.add(new StudentsAndCourse("Lena", Arrays.asList("Math", "Bio", "Geography")));
        studentsAndCourseList.add(new StudentsAndCourse("Dima", Arrays.asList("English", "Bio")));
        studentsAndCourseList.add(new StudentsAndCourse("Denis", Arrays.asList("Algebra", "Geography")));

        StudentsAndCourse studentsAndCourse = new StudentsAndCourse("Lena", Arrays.asList("Math", "Bio"));

        studentsAndCourseList.add(studentsAndCourse);

        System.out.println(studentsAndCourse.getStudentsGoCourse(studentsAndCourseList, "Algebra"));
        System.out.println(studentsAndCourse.getMostInquisitive(studentsAndCourseList));
        System.out.println(studentsAndCourse.getUniqueCourses(studentsAndCourseList));

    }
}
