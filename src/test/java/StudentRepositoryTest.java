import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;
    private Collection<Student> testStudents;

    @Before
    public void init() {
        testStudents = StudentsProvider.getTestStudents();
        studentRepository = new StudentRepository(testStudents);
    }

    @Test
    public void getStudentsUnderTheAgeOf() {
        List<String> actualEmails = studentRepository.getStudentEmailsSortedByAgeUnderTheAgeOf(25);
        assertEquals(StudentsProvider.getStudentEmailsSortedByAgeUnderTheAgeOf(25), actualEmails);
    }

    @Test
    public void getSortedStudentNames() {
        List<String> studentNames = studentRepository.makeStudentNamesUppercaseAndReturnItAsSortedDistinctList();
        assertEquals(StudentsProvider.makeStudentNamesUppercaseAndReturnItAsSortedDistinctList(), studentNames);
        assertTrue(testStudents.stream().map(Student::getName).allMatch(s -> s.toUpperCase().equals(s)));
    }

    @Test
    public void getNonNullUniversities() {
        assertEquals(StudentsProvider.getNonNullUniversitiesSet(), studentRepository.getNonNullUniversities());
    }

    @Test
    public void getStudentsMappedByEmail() {
        Map<String, Student> studentsMappedByEmail = studentRepository.getStudentsMappedByEmail();
        Set<String> emailsSet = StudentsProvider.getEmailsSet();
        assertEquals(emailsSet, studentsMappedByEmail.keySet());
        assertTrue(emailsSet.stream().allMatch(email -> studentsMappedByEmail.get(email).getEmail().equals(email)));
    }

    @Test
    public void getStudentsGroupedByUniversity() {
        Map<String, List<Student>> studentsGroupedByUniversity = studentRepository.getOverageStudentsGroupedByUniversity();
        Set<String> universitiesSet = StudentsProvider.getNonNullUniversitiesSet();
        assertEquals(universitiesSet, studentsGroupedByUniversity.keySet());
        assertEquals(3, studentsGroupedByUniversity.get("UPT").size());
        assertEquals(3, studentsGroupedByUniversity.get("UVT").size());
        assertEquals(1, studentsGroupedByUniversity.get("UMFT").size());
        assertEquals(1, studentsGroupedByUniversity.get("USAMVBT").size());
    }

    @Test
    public void testGetStudentwithSecondLongestEmail() {
        Optional<Student> theStudentWithTheNthLongestEmail = studentRepository.getTheStudentWithTheNthShortestEmail(2);
        assertEquals(StudentsProvider.getTheStudentWithNthShortestEmail(2), theStudentWithTheNthLongestEmail);
    }

    @Test
    public void testGetTheNameOfTheSecondOldestStudent() {
        Optional<Student> theNameOfTheSecondOldestStudent = studentRepository.getTheNameOfTheSecondOldestStudent();
        assertEquals(StudentsProvider.getTheNameOfTheSecondOldestStudent(), theNameOfTheSecondOldestStudent);
    }

    @Test
    public void testGetAverageAgeOfNStudentsInUniversity2UPT() {
        testGetAverageAgeOfNStudentsInUniversity(2, "UPT");
    }

    @Test
    public void testGetAverageAgeOfNStudentsInUniversity3UPT() {
        testGetAverageAgeOfNStudentsInUniversity(3, "UPT");
    }

    @Test
    public void testGetAverageAgeOfNStudentsInUniversity1UPT() {
        testGetAverageAgeOfNStudentsInUniversity(1, "UPT");
    }

    @Test
    public void testGetAverageAgeOfNStudentsInUniversity4UPT() {
        testGetAverageAgeOfNStudentsInUniversity(4, "UPT");
    }

    @Test
    public void testGetAverageAgeOfNStudentsInUniversity4USAMVBT() {
        testGetAverageAgeOfNStudentsInUniversity(4, "USAMVBT");
    }

    @Test
    public void testCountStudentsWithNamesLongerThan10() {
        testCountStudentsWithNamesLongerThan(10);
    }

    @Test
    public void testCountStudentsWithNamesLongerThan15() {
        testCountStudentsWithNamesLongerThan(15);
    }

    @Test
    public void testCountStudentsWithNamesLongerThan20() {
        testCountStudentsWithNamesLongerThan(20);
    }

    private void testCountStudentsWithNamesLongerThan(int i) {
        long countStudentsWithNamesLongerThan = studentRepository.countStudentsWithNamesLongerThan(i);
        assertEquals(StudentsProvider.countStudentsWithNamesLongerThan(i), countStudentsWithNamesLongerThan);
    }

    private void testGetAverageAgeOfNStudentsInUniversity(int i, String university) {
        OptionalDouble actualResult = studentRepository.getAverageAgeOfNStudentsInUniversity(i, university);
        assertEquals(StudentsProvider.getAverageAgeOfNStudentsInUniversity(i, university), actualResult);
    }
}