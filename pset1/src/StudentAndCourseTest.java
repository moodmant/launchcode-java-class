import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
/**
 * JUnit tests for Student and Course
 * @author dshook
 *
 */
public class StudentAndCourseTest extends TestCase {
	@Test
	public void testStudentInit() {
        Student s = new Student("Doug", "Shook", 111111);
        assertEquals("Doug Shook", s.getName());
        assertEquals(111111, s.getStudentID());
        //No credits, no GPA
        assertEquals(0.0, s.getGPA());
        assertEquals(0.0, s.getCredits());


        //Generate some random students, and test
        for (int i = 0; i < 20; ++i) {
            double a = (Math.random() * 5000);
            double b = (Math.random() * 5000);
            int c = (int) (Math.random() * 5000);
            int standing = (int) (Math.random() * 120);
            double grade = (int) (Math.random() * 4);
            int hours = (int) (Math.random() * 5);

            Student s3 = new Student("" + a, "" + b, c);
            assertEquals(a + " " + b, s3.getName());
            assertEquals(0.0, s3.getGPA());

            s3.setCredits(standing);
            assertEquals(a + " " + b + ", " + c, s3.toString());
            if (standing > 90) {
                assertEquals("Senior", s3.getClassStanding());
            } else if (standing >= 60) {
                assertEquals("Junior", s3.getClassStanding());
            } else if (standing >= 30) {
                assertEquals("Sophomore", s3.getClassStanding());
            } else if (standing < 30) {
                assertEquals("Freshman", s3.getClassStanding());
            }
            //tests submitGrade
            assertEquals(s3.submitGrade(grade, hours), s3.getGPA());
        }


        //More tests should go here
    }
    @Test
    public void testComputeTuition(){
        Student a = new Student("John", "Doe", 101010, 30, 4);
        Student b = new Student("jane", "Doe", 202020, 38, 4);
        assertEquals(a.computeTuition(), 40000.0);
        assertEquals(b.computeTuition(), 60000.0);
    }

    @Test
    public void testCreateLegacy(){
        Student a = new Student("John", "Doe", 101010, 30, 4);
        Student b = new Student("Jane", "Doe", 202020, 38, 4);
        Student c = a.createLegacy(b);
        assertEquals("John Doe Jane Doe", c.getName());
        assertEquals(38.0, c.getCredits());
        assertEquals(4.0, c.getGPA());
    }

    @Test
    public void testCourseInit() {
        Student a = new Student("John", "Doe", 101010, 30, 4);
        Student b = new Student("Jane", "Doe", 202020, 38, 4);
        Course info = new Course("Math", 2.0, 30);
        assertEquals("Math", info.getName());
        assertEquals(2.0, info.getCredits());
        assertEquals(30, info.getNumberOfSeats());
    }

    @Test
    public void testAddStudent(){
        Student a = new Student("Jon", "Snow", 101010, 30, 3);
        Student b = new Student("Tyrion", "Lannister", 202020, 38, 4);
        Student c = new Student("Stannis", "Baratheon", 303030, 40, 3);
        Course info = new Course("Game Theory", 3.0, 2);
        assertEquals(true, info.addStudent(a));
        assertEquals(a, info.getRosterOfStudents()[0]);
        assertEquals(true, info.addStudent(b));
        assertEquals(b, info.getRosterOfStudents()[1]);
        assertEquals(false, info.addStudent(c));
    }

    @Test
    public void testPrintRoster(){
        Student a = new Student("Jon", "Snow", 101010, 30, 3);
        Student b = new Student("Tyrion", "Lannister", 202020, 38, 4);
        Student c = new Student("Stannis", "Baratheon", 303030, 40, 3);
        Course info = new Course("Game Theory", 3.0, 3);
        info.addStudent(a);
        info.addStudent(b);
        info.addStudent(c);
        info.printRoster();
    }

    @Test
    public void testAverageGPA(){
        Student a = new Student("Jon", "Snow", 101010, 30, 3);
        Student b = new Student("Tyrion", "Lannister", 202020, 38, 3);
        Student c = new Student("Stannis", "Baratheon", 303030, 40, 3);
        Course info = new Course("Game Theory", 3.0, 3);
        info.addStudent(a);
        info.addStudent(b);
        info.addStudent(c);
        assertEquals(3.0, info.averageGPA());
    }
}
