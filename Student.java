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

/**
 * This is a public class that intializes a student's first and last name and
 * their PID.
 */
public class Student implements Comparable<Student>{
    /*
     * the instance variables of the Student class
     */
    private final String firstName;
    private final String lastName;
    private final String PID;


    /**
     * A constructor that intializes all instance variables.
     * @param firstName
     * @param lastName
     * @param PID
     */
    public Student(String firstName, String lastName, String PID){
        if(firstName==null || lastName == null || PID == null){
            throw new IllegalArgumentException();
        }
        this.firstName= firstName;
        this.lastName = lastName;
        this.PID = PID;
    }
    /**
     * 
     * @return Student's first name
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * 
     * @return Student's last name
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * 
     * @return Student's PID
     */
    public String getPID(){
        return PID;
    }
    /**
     * @param o
     * @return if object matches all of the criteria
     */
    public boolean equals(Object o){ // all the instance variables of o equal the corresponding instance variables of the current Student object.
        if(o != null && (o instanceof Student)){
            return true;
        }
        return false;
    }

    /**
     * @return the hashcode of the instance variables
     */
    public int hashCode(){
        return Objects.hash(firstName, lastName, PID);
    }
    /**
     * @param
     * @return 0 is the student is the same, a negative number if the this
     * student is smaller than the other student and 1 if this student is
     * bigger than other student
     */
    public int compareTo(Student o){
        if ( o == null){
            throw new NullPointerException();
        }

        if(lastName.compareTo(o.lastName) != 0){
           return lastName.compareTo(o.lastName);
        }
        else{
            if(firstName.compareTo(o.firstName) == 0){
                return PID.compareTo(o.PID);
            }
            else{
                return firstName.compareTo(o.firstName);
            }
        }
    }
}