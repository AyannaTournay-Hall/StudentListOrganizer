

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



//creates the comparator for comparing name
class studentLastNameComparator implements Comparator<student> {

//override the compare() method
public int compare(student s1, student s2)
{
return s1.lastName.compareTo(s2.lastName);
}
}


//creates the comparator for comparing Last name
class studentFirstNameComparator implements Comparator<student> {

//override the compare() method
public int compare(student s1, student s2)
{
return s1.firstName.compareTo(s2.firstName);
}
}

//creates the comparator for comparing Last name
class studentIDComparator implements Comparator<student> {

//override the compare() method
public int compare(student s1, student s2)
{
return s1.id.compareTo(s2.id);
}
}

//creates the comparator for comparing Last name
class studentMajorComparator implements Comparator<student> {

//override the compare() method
public int compare(student s1, student s2)
{
return s1.major.compareTo(s2.major);
}
}


//creates the comparator for comparing Last name 
class studentGPAComparator implements Comparator<student> {

//override the compare() method 
	public int compare(student s1, student s2) {
return s1.gpa.compareTo(s2.gpa); } }





public class GuiOutput extends JFrame implements ActionListener 
{
	private JTextField firstNameField; // Holds first name
	private JTextField lastNameField; // Holds last name
	private JFormattedTextField idField; // Holds Student ID
	private JFormattedTextField majorfield; // Holds ticket cost
	private JLabel tableLabel; // Label for table display
	private JLabel seatNumLabel; // Label for Student ID
	private JLabel firstNameLabel; // Label for first name
	private JLabel lastNameLabel; // Label for last name
	private JLabel MajorLabel; // Label for amount paid
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
	private final static int NUM_SEATS = 5; // Number of seat in reservation system
	public static String guiListName;
	
	
	public GuiOutput() throws IOException 
	{

		System.out.println(Main.studentIDs.size()+" GUI OUTPUT 46") ;

		//sets table size (ROW,COLUMN)
		Object[][] tableVals = new Object[Main.listOfStudents.size()][5];
		//sets column headings for table 
		String[] columnHeadings = { "Student ID", "First Name","Last Name", "Major", "GPA" }; 
		// GUI component layout
		GridBagConstraints layoutConst = null; 
		// unsure rn
		NumberFormat Format = null; 
		
		// Set frame's title
				setTitle("Student List");

				
	
								//the following is GUI layout code
								// Create seat reservation table
								tableLabel = new JLabel("Student List");
								seatNumLabel = new JLabel("Student ID:");
								firstNameLabel = new JLabel("First Name:");
								lastNameLabel = new JLabel("Last Name:");
								MajorLabel = new JLabel("Major:");

								idField = new JFormattedTextField(NumberFormat.getIntegerInstance());
								idField.setEditable(true);
								idField.setValue(0);
						
								firstNameField = new JTextField(20);
								firstNameField.setEditable(true);
								firstNameField.setText("John");
						
								lastNameField = new JTextField(20);
								lastNameField.setEditable(true);
								lastNameField.setText("Doe");
						
								Format = NumberFormat.getCurrencyInstance();
								Format.setMaximumFractionDigits(0);
								majorfield = new JFormattedTextField(Format);
								majorfield.setEditable(true);
								majorfield.setText("Default");
						
								loadButton = new JButton("Load Students");
								loadButton.addActionListener(this);

								firstNameButton = new JButton("Sort by First Name");
								firstNameButton.addActionListener(this);
						
								lastNameButton = new JButton("Sort by Last Name");
								lastNameButton.addActionListener(this);
						
								majorButton = new JButton("Sort by Major");
								majorButton.addActionListener(this);
						
								gpaButton = new JButton("Sort by GPA");
								gpaButton.addActionListener(this);
						
								idButton = new JButton("Sort by ID");
								idButton.addActionListener(this);
						
								quitButton = new JButton("Quit");
								quitButton.addActionListener(this);
						
								// Initialize table
								studentStatusTable = new JTable(tableVals, columnHeadings);
								studentStatusTable.setEnabled(false); // Prevent user input via table
						
								// Add components using GridBagLayout
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
								layoutConst.gridx = 0;
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
								layoutConst.gridx = 4;
								layoutConst.gridy = 4;
								add(gpaButton, layoutConst);
						
								layoutConst = new GridBagConstraints();
								layoutConst.insets = new Insets(0, 5, 10, 10);
								layoutConst.fill = GridBagConstraints.HORIZONTAL;
								layoutConst.gridx = 5;
								layoutConst.gridy = 4;
								add(quitButton, layoutConst);
		updateTable();

	}

	
	public void actionPerformed(ActionEvent event) 
	{
		JButton sourceEvent = (JButton) event.getSource();
		
		if (sourceEvent == loadButton) {
		    // Open a file chooser dialog
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(this);

			if (result == JFileChooser.APPROVE_OPTION) {
			    // Get the selected file
			    File file = fileChooser.getSelectedFile();

			    // Load the students from the file
			    Main.loadStudentsFromFile(file);

			    // Update the table with the new data
			    updateTable();
			}
		}
		
		
		
	    // User pressed the reserve button
	    if (sourceEvent == idButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentIDComparator());
			updateTable();
	    }
	    // User pressed the reserve button
	    if (sourceEvent == firstNameButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentFirstNameComparator());
			updateTable();
	    }
		
	    // User pressed the reserve button
	    if (sourceEvent == lastNameButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentLastNameComparator());
			updateTable();
	    }
	    
	    // User pressed the reserve button
	    if (sourceEvent == majorButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentMajorComparator());
			updateTable();
	    }
	    
	    // User pressed the reserve button
	    if (sourceEvent == gpaButton) 
	    {	
	    	Collections.sort(Main.listOfStudents, new studentGPAComparator());
			updateTable();
	    }
		
		
		if (sourceEvent == quitButton) 
		{
			dispose(); // Terminate program
		}
	}

	/* Updates the information displayed by the table */
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
		}


		
	}
}


