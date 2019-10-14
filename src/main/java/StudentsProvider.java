import java.util.*;
import java.util.stream.Collectors;

class StudentsProvider {

    static Collection<Student> getTestStudents() {
        return Arrays.asList(
                new Student("Ana Ionescu", "ana.ionescu@gmail.com", 23, "UPT"),
                new Student("Marius Blide", "mblide@yahoo.com", 28, "UPT"),
                new Student("Cristian Paul", "cristip@mail.com", 22, "UVT"),
                new Student("Ion Lazar", "lazari@mail.com", 26, "UVT"),
                new Student("Izabella Kiss", "kissiza@mail.com", 17, "UMFT"),
                new Student("Andreea Achim", "andreea32@hotmail.com", 20, null),
                new Student("Gheorghe Iova", "iovag@me.com", 10, "UPT"),
                new Student("Adela Stefan", "adelas@gmail.com", 21, "UMFT"),
                new Student("Maria Tiurbe", "maria.tiurbe@yahoo.com", 20, "UPT"),
                new Student("Nandor Turzo", "nandor_t@gmail.com", 26, "UVT"),
                new Student("Sergiu Bogdan", "sergiu.b@gmail.com", 23, "USAMVBT"),
                new Student("Cristi Boc", "cristi.b@email.com", 23, null)
        );
    }

    static Set<String> getNonNullUniversitiesSet() {
        return getTestStudents().stream().map(Student::getUniversity).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    static Set<String> getEmailsSet() {
        return getTestStudents().stream().map(Student::getEmail).collect(Collectors.toSet());
    }

    static List<String> makeStudentNamesUppercaseAndReturnItAsSortedDistinctList() {
        return getTestStudents().stream()
                .peek(s -> s.setName(s.getName().toUpperCase()))
                .map(Student::getName)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    static List<String> getStudentEmailsSortedByAgeUnderTheAgeOf(int age) {
        return getTestStudents().stream()
                .filter(student -> student.getAge() < age)
                .sorted(Comparator.comparingInt(Student::getAge))
                .map(Student::getEmail)
                .collect(Collectors.toList());
    }

    public static Optional<Student> getTheStudentWithNthShortestEmail(int n) {
        return getTestStudents().stream()
                .sorted(Comparator.comparingInt(student -> student.getEmail().length()))
                .skip(n - 1)
                .findFirst();
    }

    public static Optional<Student> getTheNameOfTheSecondOldestStudent() {
        return getTestStudents().stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .skip(1)
                .findFirst();
    }

    public static OptionalDouble getAverageAgeOfNStudentsInUniversity(int n, String university) {
        return getTestStudents().stream()
                .filter(student -> isInUniversity(student, university))
                .mapToInt(Student::getAge)
                .limit(n)
                .average();
    }

    private static boolean isInUniversity(Student student, String university) {
        if (university == null)
            return student.getUniversity() == null;
        return university.equals(student.getUniversity());
    }

    public static long countStudentsWithNamesLongerThan(int n) {
        return getTestStudents().stream()
                .map(Student::getName)
                .mapToInt(String::length)
                .filter(len -> len > n)
                .count();
    }
}
