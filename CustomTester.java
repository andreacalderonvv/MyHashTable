/*
 * Name: Andrea Calderon
 * Email: a6calderon@ucsd.edu
 * PID: A17303613
 * Sources: Write Up, JDK 17 Doc
 * 
 * This Tester tests the various methods in the java files Student, Course,
 * and Sanctuary
 */
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;


public class CustomTester{

    @Test
    public void testStudentEquals(){
        Student stu = new Student("Andrea", "Calderon", "A17302613");
        Sanctuary sanc = new Sanctuary(10, 10);
        assertEquals(false,stu.equals(sanc));
    }

    @Test
    public void testSanctConstructor(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Sanctuary(-3,7);
        });
    }

    @Test
    public void testStudentCompareTo(){
        Student stu = new Student("Andrea", "Calderon", "A11111111");
        Student stu2 = new Student("Andrea", "Calderon","A17303613");
        assertEquals(-6,stu.compareTo(stu2));
    }

    @Test
    public void testCourseDrop(){
        Student stu = new Student("Rocco", "Calderon", "A17383013");
        Student stu2 = new Student("Tintino", "Calderon", "A17303613");
        Course cse = new Course("CSE", "101", "learn what a computer is", 100);
        cse.enroll(stu);

        assertEquals(false, cse.drop(stu2));
    }

    @Test
    public void testCourseEnroll(){
        Student stu = new Student("Rocco", "Calderon", "A17383013");
        Student stu2 = new Student("Tintino", "Calderon", "A17303613");
        Student stu3 = new Student("Puppee", "Calderon", "A17342614");
        Course pup = new Course("puppy", "178", "for puppies", 2);
        pup.enroll(stu);
        pup.enroll(stu2);
        assertEquals(false, pup.enroll(stu3));

    }

    @Test
    public void testCourseGetRoster(){
        


    }

    @Test
    public void testSanctRescuePartial(){
        Sanctuary sanct = new Sanctuary(90, 4);
        sanct.sanctuary.put("Giraffe", 20);
        sanct.sanctuary.put("Meerkat", 65);

        assertEquals(5,sanct.rescue("Koala", 10));
    }

    @Test
    public void testSanctRescueMaxSpecies(){
        Sanctuary sanct = new Sanctuary(500, 2);
        sanct.sanctuary.put("Giraffe", 20);
        sanct.sanctuary.put("Meerkat", 65);

        assertEquals(10,sanct.rescue("Koala", 10));
    }

    @Test
    public void testSanctReleasePartial(){
        Sanctuary sanct = new Sanctuary(500, 50);
        sanct.sanctuary.put("Giraffe", 20);
        sanct.sanctuary.put("Meerkat", 65);
        sanct.release("Giraffe", 3);

        assertEquals(17,sanct.countForSpecies("Giraffe"));
    }

    @Test
    public void testSanctReleaseTooMany(){
        Sanctuary sanct = new Sanctuary(500, 50);
        sanct.sanctuary.put("Giraffe", 20);
        sanct.sanctuary.put("Meerkat", 65);

        assertThrows(IllegalArgumentException.class, () -> {
            sanct.release("Giraffe", 21);
        });
    }

}