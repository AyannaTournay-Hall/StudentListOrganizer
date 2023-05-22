package studentInheritanceTest;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import javax.swing.table.JTableHeader;

//------------------------------------------------------------------------------------------------------
//creates the comparator for comparing name
//-----------------------------------------------------------------------------------------------------
class studentLastNameComparator implements Comparator<student> {

//-----------------------------------------------------------------------------------------
//override the compare() method
//-----------------------------------------------------------------------------------------
public int compare(student s1, student s2)
{
return s1.lastName.compareTo(s2.lastName);
}
}

//----------------------------------------------------------------------------------------------
//creates the comparator for comparing Last name
//----------------------------------------------------------------------------------------------
class studentFirstNameComparator implements Comparator<student> {

 //---------------------------------------------------------------------------------------------
//override the compare() method
//---------------------------------------------------------------------------------------------
public int compare(student s1, student s2)
{
return s1.firstName.compareTo(s2.firstName);
}
}

//---------------------------------------------------------------------------------------------
//creates the comparator for comparing Last name
//--------------------------------------------------------------------------------------------
class studentIDComparator implements Comparator<student> {

//--------------------------------------------------------------------------------------------
//override the compare() method
//---------------------------------------------------------------------------------------
public int compare(student s1, student s2)
{
return s1.id.compareTo(s2.id);
}
}

//----------------------------------------------------------------------------------------
//creates the comparator for comparing Last name
//-----------------------------------------------------------------------------------------
class studentMajorComparator implements Comparator<student> {

 //-----------------------------------------------------------------------------------
//override the compare() method
//------------------------------------------------------------------------------------
public int compare(student s1, student s2)
{
return s1.major.compareTo(s2.major);
}
}

//----------------------------------------------------------------------------------------------
//creates the comparator for comparing Last name 
//---------------------------------------------------------------------------------------------
class studentGPAComparator implements Comparator<student> {

//----------------------------------------------------------------------------------------------    
//override the compare() method 
//---------------------------------------------------------------------------------------------
	public int compare(student s1, student s2) {
return s1.gpa.compareTo(s2.gpa); } }





public class GuiOutput extends JFrame implements ActionListener 
{
    //------------------------------------------------------------------------------------
    //variables for fields, buttons, and labels
    //-----------------------------------------------------------------------------------
	private JTextField firstNameField; 
	private JTextField lastNameField; 
	private JFormattedTextField idField; 
	private JFormattedTextField majorfield; 
	private JLabel tableLabel; 
	private JLabel studIDLabel;
	private JLabel firstNameLabel; 
	private JLabel lastNameLabel; 
	private JLabel MajorLabel;
	private JButton idButton;
	private JButton firstNameButton;
	private JButton lastNameButton;
	private JButton majorButton;
	private JButton gpaButton;	
	private JButton	loadButton;
	private JButton quitButton;
	private JTable studentStatusTable;
        private static ArrayList<student> listOfStudents;
	int NUM_STUDENTS = Main.listOfStudents.size();
	public static String guiListName;
	
  
	//--------------------------------------------------------------------------------
        //method to design the GUI output
        //----------------------------------------------------------------------------------
	public GuiOutput() throws IOException 
	{

	     

		System.out.println(Main.studentIDs.size()+" GUI OUTPUT 46") ;

		//sets table size (ROW,COLUMN)
		Object[][] tableVals = new Object[Main.listOfStudents.size()][5];
		//sets column headings for table 
		String[] columnHeadings = { "Student ID", "First Name","Last Name", "Major", "GPA" }; 
		// GUI component layout
		GridBagConstraints layoutConst = null; 
		
		NumberFormat Format = null; 
		
		// Set frame's title
		setTitle("Student List");

		//set frame background color		
                getContentPane().setBackground(new Color (238, 215, 250));
                
                    //the following is GUI layout code
                    // Create student table
                    tableLabel = new JLabel("Student List");
                    studIDLabel = new JLabel("Student ID:");
                    firstNameLabel = new JLabel("First Name:");
                    lastNameLabel = new JLabel("Last Name:");
                    MajorLabel = new JLabel("Major:");
                    
                    

                    idField = new JFormattedTextField(NumberFormat.getIntegerInstance());
                    

                    firstNameField = new JTextField(20);
                    
                    
                    lastNameField = new JTextField(20);
                    

                    majorfield = new JFormattedTextField(Format);
                    
                    
                    
                    /////////////////////////////////////////////////
                    //Buttons
                    ////////////////////////////////////////////////
                    
                    loadButton = new JButton("Load Students");
                    loadButton.addActionListener(this);
                    loadButton.setBackground(new Color(224, 120, 72));
                    loadButton.setForeground(Color.WHITE);
                    
                    firstNameButton = new JButton("Sort by First Name");
                    firstNameButton.addActionListener(this);
                    firstNameButton.setBackground(new Color(224, 120, 72));
                    firstNameButton.setForeground(Color.WHITE);

                    lastNameButton = new JButton("Sort by Last Name");
                    lastNameButton.addActionListener(this);
                    lastNameButton.setBackground(new Color(224, 120, 72));
                    lastNameButton.setForeground(Color.WHITE);

                    majorButton = new JButton("Sort by Major");
                    majorButton.addActionListener(this);
                    majorButton.setBackground(new Color(224, 120, 72));
                    majorButton.setForeground(Color.WHITE);

                    gpaButton = new JButton("Sort by GPA");
                    gpaButton.addActionListener(this);
                    gpaButton.setBackground(new Color(224, 120, 72));
                    gpaButton.setForeground(Color.WHITE);

                    idButton = new JButton("Sort by ID");
                    idButton.addActionListener(this);
                    idButton.setBackground(new Color(224, 120, 72));
                    idButton.setForeground(Color.WHITE);

                    quitButton = new JButton("Quit");
                    quitButton.addActionListener(this);
                    quitButton.setBackground(new Color(224, 120, 72));
                    quitButton.setForeground(Color.WHITE);

                    ///////Initialize table
                    
                    studentStatusTable = new JTable(tableVals, columnHeadings);
                    studentStatusTable.setEnabled(false); // Prevent user input via table

                    ///////// Add components using GridBagLayout
                    
                    setLayout(new GridBagLayout());

                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(10, 10, 1, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 0;
                    layoutConst.gridy = 0;
                    add(tableLabel, layoutConst);



                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(1, 10, 0, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 0;
                    layoutConst.gridy = 1;
                    layoutConst.gridwidth = 5;
                    add(studentStatusTable.getTableHeader(), layoutConst);


                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(0, 10, 10, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 0;
                    layoutConst.gridy = 2;
                    layoutConst.gridwidth = 4;
                    add(studentStatusTable, layoutConst);

                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(1, 10, 10, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 1;
                    layoutConst.gridy = 10;
                    add(loadButton, layoutConst);


                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(1, 10, 10, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 0;
                    layoutConst.gridy = 4;
                    add(idButton, layoutConst);

                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(1, 10, 10, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 1;
                    layoutConst.gridy = 4;
                    add(firstNameButton, layoutConst);

                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(1, 10, 10, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 2;
                    layoutConst.gridy = 4;
                    add(lastNameButton, layoutConst);

                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(1, 10, 10, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 3;
                    layoutConst.gridy = 4;
                    add(majorButton, layoutConst);

                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(1, 10, 10, 0);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 0;
                    layoutConst.gridy = 10;
                    add(gpaButton, layoutConst);

                    layoutConst = new GridBagConstraints();
                    layoutConst.insets = new Insets(0, 5, 10, 10);
                    layoutConst.fill = GridBagConstraints.HORIZONTAL;
                    layoutConst.gridx = 2;
                    layoutConst.gridy = 10;
                    add(quitButton, layoutConst);
                    
                    JScrollPane scrollPane = new JScrollPane(studentStatusTable);
                    layoutConst.gridx = 2;
                    layoutConst.gridy = 1;
                    add(scrollPane, layoutConst);
                    
		updateTable();
                
                

	}

	//-------------------------------------------------------------------------------------
        //method for button actions
        //-------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent event) {
        try {
                 JButton sourceEvent = (JButton) event.getSource();
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setAcceptAllFileFilterUsed(false);

         FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
         fileChooser.setFileFilter(filter);

         if (sourceEvent == loadButton) {
             int result = fileChooser.showOpenDialog(this);

             if (result == JFileChooser.APPROVE_OPTION) {
                 File file = fileChooser.getSelectedFile();

                 Main.studentIDs.clear();
                 Main.firstNames.clear();
                 Main.lastNames.clear();
                 Main.majors.clear();
                 Main.gpas.clear();
                 Main.readStudent2(file);


                 System.out.println("what2");

                 // Update the table with the new data
                 updateTable();
                 System.out.println("what3");

             } else {
                 System.out.println("Error. This is not available");
             }
        }
		
	    if (sourceEvent == idButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentIDComparator());
			updateTable();
	    }
	    
	    if (sourceEvent == firstNameButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentFirstNameComparator());
			updateTable();
	    }
		
	    
	    if (sourceEvent == lastNameButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentLastNameComparator());
			updateTable();
	    }
	    
	    
	    if (sourceEvent == majorButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentMajorComparator());
			updateTable();
	    }
	    
	    
	    if (sourceEvent == gpaButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentGPAComparator());
			updateTable();
	    }
		
		
		if (sourceEvent == quitButton) 
		{
			dispose(); 
		}
		
		
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("IOException occurred");
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("General exception occurred");
       }
	}

	////////////////////////////////////////////////////////////////////////
        //Updates the information displayed by the table 
        ////////////////////////////////////////////////////////////////////////
	public void updateTable() 
	{
		final int studentIDCol = 0; // Col num for Student IDs
		final int firstNameCol = 1; // Col num for first names
		final int lastNameCol = 2; // Col num for last names
		final int majorCol = 3; // Col num for Major
		final int GpaCol = 4; // Col num for GPA
		int i; // Loop index
	    Object[][] tableVals = new Object[Main.listOfStudents.size()][5];

		for ( i = 0; i < Main.listOfStudents.size(); i++) 
		{
		    student currentStudent = Main.listOfStudents.get(i);
		    tableVals[i][studentIDCol] = currentStudent.getId();
		    tableVals[i][firstNameCol] = currentStudent.getFirstName();
		    tableVals[i][lastNameCol] = currentStudent.getLastName();
		    tableVals[i][majorCol] = currentStudent.getMajor();
		    tableVals[i][GpaCol] = currentStudent.getGpa();
		}


		studentStatusTable.setModel(new javax.swing.table.DefaultTableModel(tableVals, new String[] { "Student ID", "First Name", "Last Name", "Major", "GPA" }));

		for (i = 0; i < Main.listOfStudents.size(); ++i) 
		{
			//If we want to add a # column the following is what you would call
			//studentStatusTable.setValueAt(i, i, studentIDCol);
			studentStatusTable.setValueAt(Main.listOfStudents.get(i).getId(), i, studentIDCol);
			studentStatusTable.setValueAt(Main.listOfStudents.get(i).getFirstName(), i, firstNameCol);
			studentStatusTable.setValueAt(Main.listOfStudents.get(i).getLastName(), i, lastNameCol);
			studentStatusTable.setValueAt(Main.listOfStudents.get(i).getMajor(), i, majorCol);
			studentStatusTable.setValueAt(Main.listOfStudents.get(i).getGpa(), i, GpaCol);
                        
                        JTableHeader header = studentStatusTable.getTableHeader();
                        header.setBackground(new Color(37, 150, 190));
                        header.setForeground(Color.BLACK);
                       
		}

               


		
	}
}


