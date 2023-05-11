import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * Jonathan Robinson
 * COP2552 OBJ ORIENT PG 2
 * Project 4 Storm Organizer
 * March 2023
 */

public class Month {
	// New instance of the Hurricane array
	Hurricane[] storms = new InputHurricanes().getArray();
	
//Calls the functions to order in ascending or descending based on the users choice.
	private void setOrder(String choice) {
		switch (choice) {
			case "1":
				sortAscending();
				break;
			
			case "2":
				sortDescending();
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Choice not selected.");
				System.exit(0);
				break;
		}
	}
	
	// Prompts to get the users choice for ascending or descending
	private void getOrder() {
		String choice;
		choice = JOptionPane.showInputDialog(null, "Major Florida Hurricanes 1950 - 2020 \n\n Sort By Month\n\n "
				+ "Press 1 for Ascending Order \n Press 2 for Descending Order");
		
		setOrder(choice);
	}
	
	private void sortAscending() {
		String sort = "Ascending"; // Will be used to fill in the display functions order style string
		Arrays.sort(storms, (first, second) ->

		// Compares the first name to the second to determine if it needs to be switched places.
		Integer.compare(first.GetMonth(), (second.GetMonth()))
		);


		displayOutput(sort);

	}
	
	private void sortDescending() {
		String sort = "Descending"; // Will be used to fill in the display functions order style string
		Arrays.sort(storms, (first, second) ->

		// Compares the first name to the second to determine if it needs to be switched places.
		Integer.compare(second.GetMonth(), (first.GetMonth()))
		);

		displayOutput(sort);
	}

	// Will display a message box with the names in the correct order and then write it to a file.
	// Order will take in the String value of either Ascending or Descending depending on which function is called.
	private void displayOutput(String order) {
		JTextArea textArea = new JTextArea("Major Florida Hurricanes 1950 - 2020 \n\n"
				+ "Sort By Month in " + order + " Order\n\n" 
				+ " Name \t Category \t    Date\n");
		for(int i = 0; i < storms.length; i++) {
			String name = storms[i].GetName();
			int category = storms[i].GetCategory();
			String date = storms[i].GetDate();
			textArea.append(name + "\t    " + category + "\t" + date +"\n");
		}
		JOptionPane.showMessageDialog(textArea, textArea);
		writeToFile();
	}

	// Similar to the display output but instead mirrors the format of the original text file.	
	private void writeToFile() {
		try {
			PrintWriter write = new PrintWriter("C:/SFC/COP2552/Project4/SortByMonth.txt");
			write.println("Major Florida Hurricanes 1950 - 2020");
			write.println("Sort By Hurricane Month\n");
			for(int i = 0; i < storms.length; i++) {
				String name = storms[i].GetName();
				int category = storms[i].GetCategory();
				String date = storms[i].GetDate();
				
				write.println(name + "," + category + ":" + date);
			}
			write.close();
		} 
		catch (FileNotFoundException e) {
			System.exit(0);
		}
		
	}
	
	// Function to be used in main to display the months in order
	public void displayMonths() {
		getOrder();
	}
}
