import java.util.*;
import java.util.stream.Collectors;

class StudentsProvider {

    static Collection<Student> getTestStudents() {
        return Arrays.asList(
                new Student("Ana Ionescu", "ana.ionescu@gmail.com", 23, "UPT"),
                new Student("Marius Blide", "mblide@yahoo.com", 28, "UPT"),
                new Student("Cristian Paul", "cristip@mail.com", 22, "UVT"),
                new Student("Ion Lazar", "lazari@mail.com", 26, "UVT"),
                new Student("Izabella Kiss", "kissiza@mail.com", 22, "UMFT"),
                new Student("Andreea Achim", "andreea32@hotmail.com", 20, "UVT"),
                new Student("Gheorghe Iova", "iovag@me.com", 10, "UMFT"),
                new Student("Adela Stefan", "adelas@gmail.com", 21, "UMFT"),
                new Student("Maria Tiurbe", "maria.tiurbe@yahoo.com", 20, "UPT"),
                new Student("Nandor Turzo", "nandor_t@gmail.com", 26, "UVT"),
                new Student("Sergiu Bogdan", "sergiu.b@gmail.com", 23, "USAMVBT")
        );
    }

    static Set<String> getUniversitiesSet() {
        return getTestStudents().stream().map(Student::getUniversity).collect(Collectors.toSet());
    }

    static Set<String> getEmailsSet() {
        return getTestStudents().stream().map(Student::getEmail).collect(Collectors.toSet());
    }

    static List<String> getSortedStudentsName() {
        return getTestStudents().stream().map(Student::getName).sorted().collect(Collectors.toList());
    }

    static List<String> getStudentEmailsSortedByAgeUnderTheAgeOf(int age) {
        return getTestStudents().stream()
                .filter(student -> student.getAge() < age)
                .sorted(Comparator.comparing(Student::getAge))
                .map(Student::getEmail)
                .collect(Collectors.toList());
    }
}
