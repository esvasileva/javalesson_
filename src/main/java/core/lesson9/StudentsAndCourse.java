package core.lesson9;

import java.util.List;
import java.util.stream.Collectors;

public class StudentsAndCourse implements Student, Course{

    private String nameStudents;
    private List nameCourses;

    public StudentsAndCourse(String nameStudents, List<String> nameCourses) {
        this.nameStudents = nameStudents;
        this.nameCourses = nameCourses;
    }

    @Override
    public String getName() {
        return nameStudents;
    }

    @Override
    public List getAllCourses() {
        return nameCourses;
    }

    @Override
    public String toString() {
        return "StudentsAndCourse{" +
                "nameStudents='" + nameStudents + '\'' +
                ", nameCourses=" + nameCourses +
                '}';
    }

    public List getUniqueCourses (List<StudentsAndCourse> student) {
        List courses = (List) student.stream()
                .map(s -> s.getAllCourses())
                .flatMap(f -> f.stream())
                .distinct()
                .collect(Collectors.toList());

        return courses;
    }

    public List getMostInquisitive (List<StudentsAndCourse> student) {
        List nameOfStudents = student.stream()
                .sorted((s1, s2) -> s2.getAllCourses().size() - s1.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
        return nameOfStudents;
    }

    public List getStudentsGoCourse (List<StudentsAndCourse> student, String course) {
        List studentCourse = student.stream()
                .filter(s -> s.getAllCourses().contains(course))
                .collect(Collectors.toList());

        return studentCourse;
    }

}
