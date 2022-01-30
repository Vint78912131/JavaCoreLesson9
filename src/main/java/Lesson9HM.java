import java.util.*;
import java.util.stream.Collectors;

public class Lesson9HM {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Ivan", Arrays.asList(new Course("Chemistry"), new Course("Physics"),
                new Course("Geometry"), new Course("Biology"), new Course("Math"))));
        students.add(new Student("Sergey", Arrays.asList(new Course("Chemistry"), new Course("Geography"),
                new Course("Biology"), new Course("Philosophy"))));
        students.add(new Student("Nikolay", Arrays.asList(new Course("Physics"), new Course("Biology"),
                new Course("Geography"), new Course("Literature"))));
        students.add(new Student("Vladimir", Arrays.asList(new Course("Physics"), new Course("Biology"),
                new Course("Chemistry"), new Course("Geometry"), new Course("Astronomy"))));
        students.add(new Student("Olga", Arrays.asList(new Course("Math"), new Course("Physics"),
                new Course("Literature"), new Course("Art"))));
        students.add(new Student("Evgeniya", Arrays.asList(new Course("Chemistry"), new Course("Biology"),
                new Course("Geometry"), new Course("Math"), new Course("Physics"), new Course("Art"))));
        students.add(new Student("Ekaterina", Arrays.asList(new Course("Math"), new Course("Astronomy"),
                new Course("Art"), new Course("Literature"))));


        System.out.println("List of courses:\n");
        students.stream()
                .flatMap(f -> f.getCourses().stream())
                .distinct()
                .forEach(System.out::print);


        System.out.println("\nThe most inquisitive students:\n");
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        System.out.println("\nStudents attends a math course:\n");
        Course course = new Course("Math");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
