/*
 * Jonathan Robinson
 * COP2552 OBJ ORIENT PG 2
 * Project 4 Storm Organizer
 * March 2023
 */

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class InputHurricanes {
	// Creates a file instance of the NamedFloridaHurricanes 
	File inputFile = new File("C:/SFC/COP2552/Project4/NamedFloridaHurricanes.txt");
	
	// Gets the length of the input file and creates and array for the hurricane objects to be held
	private int length = getLength(inputFile);
	Hurricane[] storms = new Hurricane[length];
	
	// Function to find the length of the file and catch if it exists.
	private int getLength(File file) {
		int i = 0;
		
		try (Scanner scan = new Scanner(file)) {
			while (scan.hasNext()) {
				scan.nextLine();
				i++;
			}
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found, please place the text file in the \n C:/SFC/COP2552/Project4 folder.");
		}
		return i;
	}
	
	// Makes an array to hold the text file entries as the hurricane objects.
	private void setArray() {
		try (Scanner scan = new Scanner(inputFile)){
			for(int i = 0; i< length; i++) {
				String storm = scan.nextLine();
				String[] token = storm.split("[,:]");
				storms[i] = new Hurricane(token[0], Integer.parseInt(token[1]), token[2]);
			}
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found, please place the text file in the \n C:/SFC/COP2552/Project4 folder.");
		}
	}
	
	// Makes a copy of the array to be called later.
	public Hurricane[] getArray() {
		setArray();
		return storms;
	}
	
	// Calls the copy of the Array
	public void list() {
		getArray();
	}
}
