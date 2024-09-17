/**
 * Programmer: Enrique Mejia
 * Course: IS 2063.001
 * 
 * Class: MejiaE001PA
 * 
 * Purpose: To create a program that shows student's summer
 *          schedule. The program will enroll students into courses
 *          (no more than two) and if needed dropt the student.
 * 
 * Due date: 07-21-2023
 * Files: PA2, Student
 */

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class MejiaE001PA2
{
  
  public static void main(String[] args) throws FileNotFoundException {
    
      /* declare variables
       * to be used in this program
       */
    
    String fName, lName, classification;
    int id, index, drop;
    int numStudents = 0;
    final int NUM_STUDENTS = 4, CHANCE_OF_DROPPING = 3, DROP_A_COURSE = 1;
    
    
    Random rand = new Random();
    Scanner inputFile = new Scanner(new File("Names"));
    index = 0;
    
    Students[] students = new Student[NUM_STUDENTS];
    while(inputFile.hasNextLine() && numStudents < NUM_STUDENTS)
    {
      fName = readFirstName(inputFile);
      lName = readLastName(inputFile);
      id = realID(inputFile);
      classification = readClassification(inputFile);
      students[numStudents] = new Student(fName, lName, id, classification);
      numStudents++;
    } // end while loop
    inputFile.close();
    
      // printing student details from file
    for(int index = 0; index < numStudents; index++)
    {
      System.out.printf("Student: ", + 
                        students[index].getFirstName() +
                        students[index].getLastName() +
                        students[index].getID() +
                        students[index].getClassification());
      
    } // end for loop
    
      // for loop to enroll the students
    for(index = 0; index < numStudents; index ++)
    {
      students[index].enrollStudent();
    } // end for loop to enroll students
    
      /* Print out each students course
       * by invoking the method
       * printStudentCourses using for loop
       */
    
    System.out.printf("The student's courses: ");
    for(index = 0; index < numStudents; index++)
    {
      students[index].printStudentCourses();
    } // end for loop
    
      /* invoking the method dropCourse using
       * for loop for all students
       */
    
    for(index = 0; index < numStudents; index++)
    {
      drop = rand.nextInt(CHANCES_OF_DROPPING);
      if(drop == DROP_A_COURSE)
      {
        students[index].dropCourse();
      } // END if
    } // end for loop for drop courses
    
      /* again print out each students
       * course by invoking the method
       * printStudentCourses
       */
     System.out.printf("The student's courses: ");
    for(index = 0; index < numStudents; index++)
    {
      students[index].printStudentCourses();
    } // end for loop
    
      /* invoke the method goodBye to end program
       */
    
    goodBye();
    
      // reading first name from file
    
    public static String readFirstName(Scanner inputFile)
    {
      return inputFile.next();
    } // end method readFirstName
    
      /* reading last name from file */
    
    public static String readLastName(Scanner inputFile)
    {
      return inputFile.next();
    } // end method readLastName
    
      /* reading id from file */
    
    public static int readID(Scanner inputFile)
    {
      return inputFile.nextInt();
    } // end method readID
    
      /* reading classification from file */
    public static String readClassification(Scanner inputFile)
    {
      return inputFile.next();
    } // end method readClassification
    
      /* printing out goodBye message
       */ 
    public static void goodBye()
    {
      System.out.printf("%nThis program was written by Enrique Mejia.%n" +
                     "Goodbye!");
    } // end method goodBye
    
  } // end method main
} // end class MejiaE001PA2
