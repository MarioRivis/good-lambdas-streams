import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @Before
    public void init() {
        studentRepository = new StudentRepository(StudentsProvider.getTestStudents());
    }

    @Test
    public void getStudentsUnderTheAgeOf() {
        List<Student> students = studentRepository.getStudentsSortedByAgeUnderTheAgeOf(25);
        List<String> actualEmails = students.stream().map(Student::getEmail).collect(Collectors.toList());
        assertEquals(StudentsProvider.getStudentEmailsSortedByAgeUnderTheAgeOf(25), actualEmails);
    }

    @Test
    public void getSortedStudentNames() {
        List<String> studentNames = studentRepository.getAndPrintSortedStudentNames();
        assertEquals(StudentsProvider.getSortedStudentsName(), studentNames);
    }

    @Test
    public void getUniversities() {
        assertEquals(StudentsProvider.getUniversitiesSet(), studentRepository.getUniversities());
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
        Map<String, List<Student>> studentsGroupedByUniversity = studentRepository.getStudentsGroupedByUniversity();
        Set<String> universitiesSet = StudentsProvider.getUniversitiesSet();
        assertEquals(universitiesSet, studentsGroupedByUniversity.keySet());
        assertTrue(universitiesSet.stream()
                .allMatch(university -> studentsGroupedByUniversity.get(university).stream()
                        .allMatch(student -> student.getUniversity().equals(university))));
    }
}