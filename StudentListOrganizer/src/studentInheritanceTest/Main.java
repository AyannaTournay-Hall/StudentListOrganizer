package studentInheritanceTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;


public class Main extends student 
{
   //--------------------------------------------------------------
   //declare array list items
   //---------------------------------------------------------------
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
    
    //---------------------------------------------------------------------------
    // read from the file to the array
    //---------------------------------------------------------------------------

	public static String readStudent(ArrayList<String> studentIDs, ArrayList<String> firstNames, ArrayList<String> lastNames, ArrayList<String> majors, ArrayList<String> gpas) throws IOException 
	{
		FileInputStream fileByteStream = null; // File input stream
		FileInputStream fileByteStream2 = null; // File input stream

		Scanner inFS = null; // Scanner object
		Scanner inFS2 = null; // Scanner object

		String listName;
		String studentID;
		String firstName;
		String lastName;
		String major;
		String gpa;
		String fileName;
	
		// Try to open file
		
		System.out.println("Opening file.");
		
		fileByteStream = new FileInputStream("student.txt");

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
	
	//-------------------------------------------------------------------------
        //read another file and send it to the array
        //-------------------------------------------------------------------------
	public static String readStudent2(File file) throws IOException {
	    FileInputStream fileByteStream2 = null; // File input stream

	    Scanner inFS2 = null; // Scanner object

	    String listName;
	    String studentID;
	    String firstName;
	    String lastName;
	    String major;
	    String gpa;

	    // Try to open file
	    System.out.println("Opening file.");

	    fileByteStream2 = new FileInputStream(file);

	    inFS2 = new Scanner(fileByteStream2);

	    listName = inFS2.nextLine();

	    studentIDs.clear();
	    firstNames.clear();
	    lastNames.clear();
	    majors.clear();
	    gpas.clear();
	    listOfStudents.clear(); // Clear the listOfStudents ArrayList

	    //////////////////////////////////////////////////////////////////////////////
            //Get variables from txt files and add them to the values in each array list.
	    ///////////////////////////////////////////////////////////////////////////
            while (inFS2.hasNext()) {

	        studentID = inFS2.next();
	        firstName = inFS2.next();
	        lastName = inFS2.next();
	        major = inFS2.next();
	        gpa = inFS2.next();

	        studentIDs.add(studentID);
	        firstNames.add(firstName);
	        lastNames.add(lastName);
	        majors.add(major);
	        gpas.add(gpa);

	        // Create a new student object and add it to the listOfStudents ArrayList
	        student s = new student(studentID, firstName, lastName, major, gpa);
	        listOfStudents.add(s);

	    }

	    for (int i = 0; i < studentIDs.size(); i++) {
	        System.out.println(Main.listOfStudents.get(i).getFirstName());
	        System.out.println(Main.listOfStudents.get(i).getLastName());
	        System.out.println(Main.listOfStudents.get(i).getMajor());
	        System.out.println(Main.listOfStudents.get(i).getGpa());
	        System.out.println("--------------------");
	    }

	    inFS2.close(); // close() may throw IOException if fails
	    fileByteStream2.close(); // close() may throw IOException if fails

	    return listName;
	}

        //------------------------------------------------------------------
        //display the student info
        //---------------------------------------------------------------------
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
	
	public static File fileSelected(File file) {
	    // Load the students from the file
	  File mainFile = null;
	  return mainFile;
		
	    
	}

//********************************************************************************************************************************************
 
	public static void main(String[] args)  throws IOException 
	{
	   
		System.out.println(Main.listOfStudents.size() );
		// File loadedFile = //...get the loaded file from the loadButton
		File file = null;
		listName = readStudent( studentIDs, firstNames, lastNames, majors, gpas);
	   
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
	   
            System.out.println(factorial(studentIDs.size()));

	   
	}

		
		
	////////////////////////////////////////////////////////////////
        //Recursion
        //method for maximum possibilities of orders
        /////////////////////////////////////////////////////////////////////
	public static double factorial(int n){
            if (n==1){
                return 1;
            }
            else {
                return n*factorial(n-1);
            }
        }
		
	
		
		     
		     
}


		