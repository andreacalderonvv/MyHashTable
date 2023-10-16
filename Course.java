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
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * The public class for creating a course.
 */
public class Course{
    /*
     * the class Course's instance variables
     */
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    /**
     * intializes the course's department, number, description, and capacity
     * @param department
     * @param number
     * @param description
     * @param capacity
     */
    public Course(String department, String number, String description, int capacity){
        if(department == null || number == null || description == null){
            throw new IllegalArgumentException();
        }
        if (capacity <= 0){
            throw new IllegalArgumentException();
        }
        this.department=department;
        this.number=number;
        this.description=description;
        this.capacity=capacity;
        this.enrolled = new HashSet<>();
    }

    public String getDepartment(){
        return department;
    }

    public String getNumber(){
        return number;
    }

    public String getDescription(){
        return description;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean enroll(Student student){
        if (student == null){
            throw new IllegalArgumentException();
        }

        if (capacity > enrolled.size()){
            enrolled.add(student);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean drop(Student student){
        if(student == null){
            throw new IllegalArgumentException();
        }
        if (enrolled.contains(student) == true){
            enrolled.remove(student);
            return true;
        }
        else{
            return false;
        }
    }

    public void cancel(){
        enrolled.clear();
    }

    public boolean isFull(){
        if(capacity==enrolled.size()){
            return true;
        }
        return false;
    }

    public int getEnrolledCount(){
        return enrolled.size();
    }

    public int getAvailableSeats(){
        return capacity-enrolled.size();
    }

    public HashSet<Student> getStudents(){
        return (HashSet<Student>) enrolled.clone();
    }

    public ArrayList<Student> getRoster(){
        ArrayList<Student> newList = new ArrayList<>();
        for(Student s: enrolled){
            newList.add(s);
        }
        Collections.sort(newList);
        return newList;
    }

    public String toString(){
        return department + " " + number+ " " + "[" + capacity + "]" + " " + description;
    }












}