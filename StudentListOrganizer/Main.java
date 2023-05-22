

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;


public class Main extends student 
{

   public static ArrayList<String> studentIDs = new ArrayList<String>();
   public static ArrayList<String> firstNames = new ArrayList<String>();
   public static ArrayList<String> lastNames = new ArrayList<String>();
   public static ArrayList<String> majors = new ArrayList<String>();
   public static ArrayList<String> gpas = new ArrayList<String>(); 
   public  static ArrayList<student> listOfStudents = new ArrayList<student>();
   public static String listName;
	
	
	public Main(String id, String firstName, String lastName, String major, String gpa) 
	{
		super(id, firstName, lastName, major, gpa);
	}

// ********************************************************************************************************************************************

	public static String readStudent(ArrayList<String> studentIDs, ArrayList<String> firstNames, ArrayList<String> lastNames, ArrayList<String> majors, ArrayList<String> gpas) throws IOException 
	{
		FileInputStream fileByteStream = null; // File input stream
		Scanner inFS = null; // Scanner object
		String listName;
		String studentID;
		String firstName;
		String lastName;
		String major;
		String gpa;
		String fileName;
	
		// Try to open file
		System.out.println("Enter the fileName to pull student information from:");
		Scanner scnr = new Scanner(System.in);
		// try/catch? if/else? loop?
		fileName = scnr.next();
		System.out.println("Opening file.");
		fileByteStream = new FileInputStream(fileName);
		inFS = new Scanner(fileByteStream);

		listName = inFS.nextLine();

		//Get variables from txt files and add them to the values in each array list.
		while (inFS.hasNext()) {

			studentID = inFS.next();
			firstName = inFS.next();
			lastName = inFS.next();
			major = inFS.next();
			gpa = inFS.next();

			studentIDs.add(studentID);
			firstNames.add(firstName);
			lastNames.add(lastName);
			majors.add(major);
			gpas.add(gpa);

		}
		inFS.close(); // close() may throw IOException if fails
		fileByteStream.close(); // close() may throw IOException if fails

		return listName;
	}

	public static void DisplayStudents() 
	{
		System.out.println("\n" + listName);
		System.out.println("--------------------");
		for (int i = 0; i < Main.listOfStudents.size(); ++i) 
		{
			System.out.println(Main.listOfStudents.get(i).getFirstName());
			System.out.println(Main.listOfStudents.get(i).getLastName());
			System.out.println(Main.listOfStudents.get(i).getMajor());
			System.out.println(Main.listOfStudents.get(i).getGpa());
			System.out.println("--------------------");

		}
	}
	

//********************************************************************************************************************************************
 
	public static void main(String[] args)  throws IOException 
	{
	   System.out.println(Main.listOfStudents.size() );
	   
	   listName = readStudent(studentIDs, firstNames, lastNames, majors, gpas);
 
	   //loop to create students and add them to an array list.
	   int j=0;
	   while(j< studentIDs.size() )
	   {	
			student s=new student(studentIDs.get(j), firstNames.get(j), lastNames.get(j), majors.get(j) ,gpas.get(j) );
			listOfStudents.add(s);
			j++;
	   }	
	   //*********************************************************************************************************
	   //output the raw file 
	   DisplayStudents();

	   
	   //Call GUI
	   GuiOutput myFrame = new GuiOutput();
	   myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   myFrame.pack();
	   myFrame.setVisible(true);
	   


	
	   
	}

	public static void loadStudentsFromFile(File file) {
		// TODO Auto-generated method stub
		
	}	
		
		
	/*
	 * public static int getStudIdPosByFirstName(ArrayList<String> firstName, String
	 * j) { for(int i = 0; i < firstName.size(); i++) { //if statement compares the
	 * value in the array to the student id searching for
	 * if(firstName.get(i).equals(j)) { return i; } } return -1; }
	 */



	/*
	 * public static int getStudIdPos(ArrayList<String> id, String j) { for(int i =
	 * 0; i < id.size(); i++) { //if statement compares the value in the array to
	 * the student id searching for if(id.get(i).equals(j)) { return i; //if found
	 * return position of student id in array } } return -1; }
	 */
		
	
		
		     
		     
}

		// ********************************************************************************************************************************************

	