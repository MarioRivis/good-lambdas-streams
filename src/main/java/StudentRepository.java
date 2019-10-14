import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentRepository {
    private Collection<Student> students;

    public StudentRepository(Collection<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public List<Student> getStudentsSortedByAgeUnderTheAgeOf(int age) {
        return students.stream()
                .filter(student -> student.getAge() < age)
                .sorted((a, b) -> {
                    if (a.getAge() < b.getAge())
                        return -1;
                    else if (a.getAge() > b.getAge())
                        return 1;
                    return 0;
                })
                .collect(Collectors.toList());
    }

    public List<String> getAndPrintSortedStudentNames() {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public Set<String> getUniversities() {
        return students.stream()
                .map(Student::getUniversity)
                .collect(Collectors.toSet());
    }

    public Map<String, Student> getStudentsMappedByEmail() {
        return students.stream()
                .collect(Collectors.toMap(Student::getEmail, Function.identity()));
    }

    public Map<String, List<Student>> getStudentsGroupedByUniversity() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getUniversity));
    }
}
