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
     * @return returns the sorted list of distinct names.
     *
     * SIDE EFFECT: makes all student names uppercase
     */
    public List<String> makeStudentNamesUppercaseAndReturnThemAsSortedDistinctList() {
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

    public Optional<String> getTheNameOfTheSecondOldestStudent() {
        return null;
    }

    public OptionalDouble getAverageAgeOfNStudentsInUniversity(int n, String university) {
        return null;
    }

    public long countStudentsWithNamesLongerThan(int n) {
        return -1;
    }

    // Students in no university (university == null) are considered to be in the same university
    public double countNumberOfStudentsWithAtLeastNColleaguesInDifferentUniversity(int n) {
        return -1;
    }

    public List<Student> getStudentsWithAtLeastOneColleagueWithDifferentEmailDomain() {
        return null;
    }
}
