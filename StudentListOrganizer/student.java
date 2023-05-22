


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;






//********************************************************************************************************************
public class student {
	
	//Private Variables for Student Class
	String id;
	String firstName;
	String lastName;
	String gpa;
	String major;

	 //--------------------------------------------------------------------------------------------------------------
    //Method used to set the private variables equal to the incoming values.
	 public student (String id, String firstName, String lastName, String major, String gpa) 
	 { 
		 this.id = id; 
		 this.firstName = firstName; 
		 this.lastName = lastName; 
		 this.gpa = gpa; 
		 this.major = major; 
	 }
	 
	public student(String title, ArrayList<String> studentIDs, ArrayList<String> firstNames,
			ArrayList<String> lastNames, ArrayList<String> majors, ArrayList<String> gpas) {
		// TODO Auto-generated constructor stub
	}

	//--------------------------------------------------------------------------------------------------------------
	 //Mutators for Student Class
	 public void setId(String id) 
	 {
		 this.id = id;
	 }
	 
	 public void setFirstName(String firstName) 
	 {
		this.firstName = firstName;
	 }
	 
	 public void setLastName(String lastName) 
	 {
		 this.lastName = lastName;
	 }
	 

	 public void setGpa(String gpa)
	 {
		 this.gpa = gpa;
	 }
	
	 public void setMajor(String major) 
	 {
		 this.major = major;
	 }
		 
	 
	//--------------------------------------------------------------------------------------------------------------
	//Accessors for Student Class

	 public String getId() 
	 {
		return id;
	 }

	 public String getFirstName() 
	 {
		 return firstName;
	 }
	
	public String getLastName() 
	{
		return lastName;
	}

	public String getGpa()
	{
		return gpa;
	}

	public String getMajor() 
	{
		return major;
	}

	
	
	
	// Method to check if Seat is empty
	   public boolean isEmpty() {
	      return firstName.equals("empty");
	   }
	   
	   
	   // Method to empty a Seat
	   public void makeEmpty() {
	      id="empty";
	      gpa="empty";
		  firstName = "empty";
	      lastName = "empty";
	      major = "empty";
	   }

	//--------------------------------------------------------------------------------------------------------------
    //ToString that outputs a formatted list of the students data
    public String toString() {
        return "Student" + "\nStudent ID: " + id +"\nFirst Name: " + firstName +"\nLast Name: " + lastName+ "\nMajor: " + major +"\nGPA: " + gpa;
    }

}
