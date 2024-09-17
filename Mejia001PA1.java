/**
 * Class:MejiaE001PA3
 * Course: IS 2063
 * 
 * Purpose: The purpose of this PA is to create 
 *          a program that will display records of
 *          peoples name, and their age. The program will
 *          manipulate the records in the appropriate way talked about.
 * 
 * Due Date: 08/04/2023
 * Programmer: Enrique Mejia
 */

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class MejiaE001PA3 {
  
  
  public static void main(String[] args) throws IOException {
    
      /* declaring variables that will
       * be used in the program.
       */
    String fullName = "";
    String firstName, lastName;
    String oneLetter;
    String bigRecord;
    String bigRecordArray[] = new String[15];
    String tokens[];
    int index = 0;
    int age;
    
      /* reading from file, we begin
       * by opening the file info.txt
       */
    
    File myFile = new File("info.txt");
    Scanner inputFile = new Scanner(myFile);
    System.out.println("Information to be read from file:%n");
    
    
      /* Read until the end of the file
       */
    while(inputFile.hasNext())
    {
        /* obtaining each record from the
         * file and printing it
         */
      bigRecord = inputFile.nextLine();
      System.out.printf("%nReading record: " +
                        index, bigRecord);
      
        /* spliting the record into tokens
         */
      tokens = bigRecord.split(" ");
      
        /* modifying lastName
         */
      lastName = modifyVowels(tokens[0]);
      lastName = lastName.toUpperCase();
      oneLetter = lastName.substring(0,1);
      lastName = lastName.substring(1, lastName.length()).toLowerCase();
      lastName = oneLetter + lastName;
      
        /* modifying firstName
         */
      firstName = modifyVowels(tokens[1]);
      firstName = firstName.toUpperCase();
      
        /* obtaining full name
         */
      fullName = firstName + " " + lastName;
      
        /* obtaining age and modifying it
         */
      age = Integer.parseInt(tokens[2]);
      age = updateAge(age);
      tokens[2] = Integer.toString(age);
      
        /* adding record to
         * the array
         */
      bigRecordArray[index] = fullName + " " + tokens[2];
      
        /* increment the index
         */
      index++;
      
    } // END while there;s no more to read from the file
    inputFile.close(); // close the file when done
    
      /* printing modified records
       */
    System.out.printf("%nModified records:%n");
    printRecords(bigRecordArray, index);
    
      /* sorting the records
       */
    selectionSort(bigRecordArray, index);
    
      /* printing the sorted 
       * records
       */
    System.out.printf("%nSorted records:%n");
    printRecords(bigRecordArray, index);
    
      /* print end of program
       */
    System.out.printf("%nThis program was written by Enrique Mejia.%n" +
                      "End of program.%n");
                        
  } // END of main method
  
    // modifyVowels() method to modify vowels in String
  public static String modifyVowels(String s)
  {
    int i = 0;
    int l = s.length();
    String str = " ";
    
      // iterate string
    for(i = 0; i < l; i++)
    {
      switch(s.charAt(i))
      {
        case '0':
          str += 'a';
          break;
        case '1':
          str += 'e';
          break;
        case '2':
          str += 'i';
          break;
        case '3':
          str += 'o';
          break;
        case '4':
          str += 'u';
          break;
        case '5':
          str += 'y';
          break;
        default:
          str += s.charAt(i);
          break;
      } // END switch statement
      
    } // END for loop
    
    return str; // return string
    
  } // END method modifyVowels
  
  public static int updateAge(int age)
  {
    Random random = new Random();
    int num;
    
    num = random.nextInt(5);
    
    switch(num)
    {
      case 0:
        age += 1;
        break;
      case 1:
        age -= 1;
        break;
      case 2:
        age += 2;
        break;
      default:
        age = 21;
        break;
    } // END switch statement
    return age; // return age
  } // END method updateAge
  
  public static void printRecords(String arr[], int index)
  {
    int i = 0;
    
    for(i = 0; i < index; i++)
    {
      System.out.printf("%nRecord: " +
                        i, arr[i]);
    } // END for loop
  } // END method printRecords
  
  public static void selectionSort(String arr[], int index)
  {
    for(int i = 0; i < index; i++)
    {
      int min = i;
      for(int j = i + 1; j < index; j++)
      {
        if(arr[min].compareTo(arr[j]) > 0)
        {
          min = j;
        } // end if statement
      } // end for
      
      String temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    } // END for loop
  } // END method selectionSort
  
} // END OF CLASS MejiaE001PA
