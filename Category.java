/*
 * Jonathan Robinson
 * COP2552 OBJ ORIENT PG 2
 * Project 4 Storm Organizer
 * March 2023
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Category {
	// New instance of the Hurricane array
	Hurricane[] storms = new InputHurricanes().getArray();
	private String sort; //Variable to be used as a display for either Ascending or Descending
	private String[] str = new String[6]; //Variable to display the aggregate display
	
	//Calls the functions to order in ascending or descending based on the users choice.
	public void setOrder(String choice) {
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
		choice = JOptionPane.showInputDialog(null, "Major Florida Hurricanes 1950 - 2020 \n\n Sort By Hurricane Category\n\n "
				+ "Press 1 for Ascending Order \n Press 2 for Descending Order");
		
		setOrder(choice);
	}
	
	private void sortAscending() {
		sort = "Ascending"; // Will be used to fill in the display functions order style string
		Arrays.sort(storms, (first, second) ->

		// Compares the first name to the second to determine if it needs to be switched places.
		Integer.compare(first.GetCategory(), (second.GetCategory()))
		);


		displayOutput(sort);

	}
	
	private void sortDescending() {
		sort = "Desceding"; // Will be used to fill in the display functions order style string
		Arrays.sort(storms, (first, second) ->

		// Compares the second name to the first to determine if it needs to be switched places.
		Integer.compare(second.GetCategory(), (first.GetCategory()))
		);

		displayOutput(sort);
	}

	// Will display a message box with the names in the correct order and then write it to a file.
	// Order will take in the String value of either Ascending or Descending depending on which function is called.
	private void displayOutput(String order) {
		JTextArea textArea = new JTextArea("Major Florida Hurricanes 1950 - 2020 \n\n"
				+ "Sort By Hurricane Category in " + order + " Order\n\n" 
				+ " Name \t Category \t    Date\n");
		// Goes through the array and creates a text box full of the sorted hurricanes objects
		for(int i = 0; i < storms.length; i++) {
			String name = storms[i].GetName();
			int category = storms[i].GetCategory();
			String date = storms[i].GetDate();
			textArea.append(name + "\t    " + category + "\t" + date +"\n");
		}
		JOptionPane.showMessageDialog(null, textArea);	
		writeToFile();
	}

	// Similar to the display output but instead mirrors the format of the original text file.
	private void writeToFile() {
		try {
			PrintWriter write = new PrintWriter("C:/SFC/COP2552/Project4/SortByCategory.txt");
			write.println("Major Florida Hurricanes 1950 - 2020");
			write.println("Sort By Hurricane Category\n");
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
	
	// Gets the total number of storms in the file
	private float getTotal() {
		float total = 0;
		for(int i = 0; i < storms.length; i++) {
			total = total + storms[i].GetCategory();
		}
		return total;
	}
	
	// Uses the total function to get the average storm category of the file
	public void getAverage() {
		String averageDisplay;
		float average = getTotal()/storms.length;
		averageDisplay = String.format("Major Florida Hurricanes 1950 - 2020 \n\n"
				+ "Average Storm Category by Saffir-Simpson Scale \n\n"
				+ "Average storm category is %.1f", average);
		JOptionPane.showMessageDialog(null, averageDisplay);	
	}
	
	
	// Gets the information from the array and puts it into a new display array named str
	private void getCategoryCount() {
		Arrays.stream(storms).collect(Collectors.groupingBy(storms -> storms.GetCategory()))
        	.forEach((occurrence, count) -> str[occurrence] = "Total category " + occurrence + " hurricanes: " + count.size());           
    	}
	
	// Adds the new str array to the string builder and makes a list of the categories and the how many per category
	private void displayAggregate() { 
        	StringBuilder builder = new StringBuilder(str.length);
        	for (int i = 1; i < str.length; builder.append(str[i++])) {
            	builder.append("\n");
        	}
        	JOptionPane.showMessageDialog(null, "Major Florida Hurricanes 1950 - 2020\n\n"
  	      			+ "Aggregate Totals by Category (Saffor-Simpson scale)\n\n"
  	      			+ "Total Number of Hurricanes listed: " + storms.length 
	        		+ "\n" + builder.toString());
	}
	
	// Functions to be used in the main class
	public void getAggregate() {
		getCategoryCount();
		displayAggregate();
	}
	
	public void displayCategory() {
		getOrder();
	}
}
