/**
 * Student class.
 * 
 * Purpose: To create a program that shows student's summer
 *          schedule. The program will enroll students into courses
 *          (no more than two) and if needed dropt the student.
 * 
 * Programmer: Enrique Mejia
 */

import java.util.Random;

public class Student
{
  
  private final int COURSE_NUM = 6;
  private String[] courses = new String[COURSE_NUM];
  private final int FIRST_OR_SECOND = 2;
  private final int POSSIBLE_COURSES = 2;
  private String firstName, lastName, classification;
  private int id;
  private String[] studentCourses = new String[POSSIBLE_COURSES];
  
    // set constructor Student
  
  public Student(String fNameIn, String lNameIn,
                 int idIn, String classificationIn)
  {
    setFirstName(fNameIn);
    setLastName(lNameIn);
    setId(idIn);
    setClassification(classification);
    setCourse();
  } // end constructor Student
  
    // mutator (set) methods
  
  public void setFirstName(String fNameIn)
  {
    firstName = fNameIn;
  } // end method setFirstName
  
  public void setLastName(String lNameIn)
  {
    lastName = lNameIn;
  } // end methof setLastName
  
  public void setID(int idIn)
  {
    id = idIn;
  } // end method setID
  
  public void setClassification(String classificationIn)
  {
    classification = classificationIn;
  } // end method setClassification
  
  public void setCourses()
  {
    courses[0] = "MAT 1093 Precalculus";
    courses[1] = "ENG 2413 Editing";
    courses[2] = "CHE 1073 Basic Chemestry";
    courses[3] = "PHI 2043 Indtroductory Logic";
    courses[4] = "BIO 1404 Biosciences I";
    courses[5] = "AST 1013 Introduction to Astronomy";
  } // end method setCourses
  
    // accessor (get) methods
  
  public String getFirstName()
  {
    return firstName;
  } // end method getFirstName
  
  public String getLastName()
  {
    return lastName;
  } // end method getLastName
  
  public int getID()
  {
    return id;
  } // end method getID
  
  public String getClassification()
  {
    return classification;
  } // end method getClassification
  
  public void enrollStudent()
  {
    int first = new Random().nextInt(COURSE_NUM);
    int second = new Random().nextInt(COURSE_NUM);
    
    while (first == second);
    {
      second = new Random().nextInt(COURSE_NUM);
    } // end while loop
    
    studentCourses[0] = courses[first];
    studentCourses[1] = courses[second];
    
  } // end method enrollStudent
  
  public void printStudentCourses();
  {
    for(int index = 0; index < studentCourses.length; index++)
    {
      System.out.printf("Student id: %s%n course:" +
                        id, studentCourses[index]);
    } // end for loop
  } // end method printStudentCourses
  
  public void dropCourse()
  {
    int dropThisCourse = new Random().nextInt(FIRST_OR_SECOND);
    studentCourses[dropThisCourse] += "(DROPPED)";
  } // end method dropCourse

} // class Student
  