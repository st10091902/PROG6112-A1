package a1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;

public class StudentManagementAppTest {

    private StudentManagementApp app;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());

    @Before
    public void setUp() {
        app = new StudentManagementApp();
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
    }

    @Test
    public void testSaveStudent() {
        // Prepare input data for the test
        String input = "12345\nJohn Doe\n17\njohn.doe@example.com\nCS101\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Execute the captureStudent method
        app.captureStudent();

        // Verify that a student has been added to the students list
        assertEquals(1, app.getStudents().size());

        // Verify the saved student's details using direct field access
        Student savedStudent = app.getStudents().get(0);
        assertEquals(12345, savedStudent.getStudentID());
        assertEquals("John Doe", savedStudent.studentName);
        assertEquals(17, savedStudent.studentAge);
        assertEquals("john.doe@example.com", savedStudent.studentEmail);
        assertEquals("CS101", savedStudent.studentCourse);
    }

    @Test
    public void testSearchStudent() {
        // Prepare test data
        Student student = new Student(12345, "John Doe", 17, "john.doe@example.com", "CS101");
        app.getStudents().add(student);

        // Prepare input data for the test
        String input = "12345\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Execute the searchStudent method
        app.searchStudent();

        // Verify that the student's details are printed
        String expectedOutput = "---------------------------------------\n"
                + "Student ID: 12345\n"
                + "Student Name: John Doe\n"
                + "STUDENT AGE: 17\n"
                + "STUDENT EMAIL: john.doe@example.com\n"
                + "STUDENT COURSE: CS101\n"
                + "---------------------------------------\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Prepare test data (empty students list)
        app.getStudents().clear();

        // Prepare input data for the test
        String input = "12345\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Execute the searchStudent method
        app.searchStudent();

        // Verify that the "Student not found" message is printed
        String expectedOutput = "Student with Student ID: 12345 was not found!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDeleteStudent() {
        // Prepare test data
        Student student = new Student(12345, "John Doe", 17, "john.doe@example.com", "CS101");
        app.getStudents().add(student);

        // Prepare input data for the test
        String input = "12345\ny\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Execute the deleteStudent method
        app.deleteStudent();

        // Verify that the student has been deleted
        assertTrue(app.getStudents().isEmpty());

        // Verify the success message
        String expectedOutput = "----------------------------------\n"
                + "Student with Student ID: 12345 was deleted!\n"
                + "----------------------------------\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Prepare test data (empty students list)
        app.getStudents().clear();

        // Prepare input data for the test
        String input = "12345\ny\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Execute the deleteStudent method
        app.deleteStudent();

        // Verify that the "Student not found" message is printed
        String expectedOutput = "Student with Student ID: 12345 was not found!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

//    @Test
//    public void testStudentAge_StudentAgeValid() {
//        // Create a Student object with a valid age (e.g., 17)
//        Student student = new Student(12345, "John Doe", 17, "john.doe@example.com", "CS101");
//
//        // Verify that the student's age is valid
//        assertTrue(app.studentAge(student.getStudentAge()));
//    }
//    @Test
//    public void testStudentAge_StudentAgeInvalid() {
//        // Execute the studentAge method with an invalid age (15)
//        boolean isValidAge = app.studentAge(15);
//
//        // Verify that the student's age is invalid
//        assertFalse(isValidAge);
//    }
    
    @After
    public void tearDown() {
        // Restore the original System.out and close streams
        System.setOut(originalOut);
        System.setIn(System.in);
        try {
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
