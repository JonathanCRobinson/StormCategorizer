/*
 * Jonathan Robinson
 * COP2552 OBJ ORIENT PG 2
 * Project 4 Storm Organizer
 * March 2023
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Name {
	Hurricane[] storms = new InputHurricanes().getArray();
	private String sort;
	
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
		choice = JOptionPane.showInputDialog(null, "Major Florida Hurricanes 1950 - 2020 \n\n Sort By Hurricane Name\n\n "
				+ "Press 1 for Ascending Order \n Press 2 for Descending Order");
		
		setOrder(choice);
	}
	
	
	private void sortAscending() {
		sort = "Ascending"; // Will be used to fill in the display functions order style string
		Arrays.sort(storms, (first, second) ->
		
		// Compares the first name to the second to determine if it needs to be switched places.
		first.GetName().compareTo(second.GetName()));

		displayOutput(sort);

	}
	
	private void sortDescending() {
		sort = "Descending"; // Will be used to fill in the display functions order style string
		Arrays.sort(storms, (first, second) ->
		
		// Compares the second name to the first to determine if it needs to be switched places.
		second.GetName().compareTo(first.GetName()));

		displayOutput(sort);
	}
	
	// Will display a message box with the names in the correct order and then write it to a file.
	// Order will take in the String value of either Ascending or Descending depending on which function is called.
	private void displayOutput(String order) {
		JTextArea textArea = new JTextArea("Major Florida Hurricanes 1950 - 2020 \n\n"
				+ "Sort By Hurricane Name in " + order + " Order\n\n" 
				+ " Name \t Category \t    Date\n");
		
		// Goes through the array and creates a text box full of the sorted hurricanes objects
		for(int i = 0; i < storms.length; i++) {
			String name = storms[i].GetName();
			int category = storms[i].GetCategory();
			String date = storms[i].GetDate();
			textArea.append(name + "\t    " + category + "\t" + date +"\n");
		}
		JOptionPane.showMessageDialog(textArea, textArea);
		writeToFile();
	}
	
	// Very similar to the display output but instead mirrors the format of the original text file.
	private void writeToFile() {
		try {
			PrintWriter write = new PrintWriter("C:/SFC/COP2552/Project4/SortByName.txt");
			write.println("Major Florida Hurricanes 1950 - 2020");
			write.println("Sort By Hurricane Name\n");
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
	
	public void displayNames() {
		getOrder();
	}
}
