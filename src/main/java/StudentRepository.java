import java.util.*;

public class StudentRepository {
    private Collection<Student> students;

    public StudentRepository(Collection<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public List<String> getStudentEmailsSortedByAgeUnderTheAgeOf(int age) {
        return null;
    }

    /**
     * @return returns the sorted list of distinct names while setting all names to Uppercase characters.
     */
    public List<String> makeStudentNamesUppercaseAndReturnItAsSortedDistinctList() {
        return null;
    }

    public Set<String> getNonNullUniversities() {
        return null;
    }

    public Map<String, Student> getStudentsMappedByEmail() {
        return null;
    }

    public Map<String, List<Student>> getOverageStudentsGroupedByUniversity() {
        return null;
    }

    public Optional<Student> getTheStudentWithTheNthShortestEmail(int n) {
        return null;
    }

    public Optional<Student> getTheNameOfTheSecondOldestStudent() {
        return null;
    }

    public OptionalDouble getAverageAgeOfNStudentsInUniversity(int n, String university) {
        return null;
    }

    public long countStudentsWithNamesLongerThan(int n) {
        return -1;
    }


}
