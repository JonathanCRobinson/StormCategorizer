/*
 * Jonathan Robinson
 * COP2552 OBJ ORIENT PG 2
 * Project 4 Storm Organizer
 * March 2023
 */

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		menu();
		
	}
	//Displays the main menu choices for the user to pick and enter from
	public static String displayMenu() {
		String choice;
		choice = JOptionPane.showInputDialog(null, "Major Florida Hurricanes 1950 - 2020 \n\n"
				+ "Press 1 to Sort by Storm Name\n"
				+ "Press 2 to Sort by Storm Category\n"
				+ "Press 3 to Sort by Storm Year\n"
				+ "Press 4 to Sort by Storm Month\n"
				+ "Press 5 to Display Average Storm Category\n"
				+ "Press 6 to Display the Most Active Year\n"
				+ "Press 7 to Display Total by Category\n"
				+ "Press 8 to Display Total by Year\n"
				+ "Press 9 to Exit\n");
		return choice;
	}
	
	// Switch cases for each of the menu choices pulling methods from each desired class.
	public static void menu() {
		String select = displayMenu();
		while(select != "9") {
			switch(select) {
				case "1":
					Name name = new Name();
					name.displayNames();
					break;
					
				case "2": 
					Category categoryOrder = new Category();
					categoryOrder.displayCategory();
					break;
				
				case "3":
					Year year = new Year();
					year.displayOrder();
					break;
				
				case "4":
					Month month = new Month();
					month.displayMonths();
					break;
				
				case "5":
					Category categoryAverage = new Category();
					categoryAverage.getAverage();
					break;
				
				case "6":
					Year activeYear = new Year();
					activeYear.displayActive();
					break;
				
				case "7":
					Category aggregate = new Category();
					aggregate.getAggregate();
					break;
					
				case "8":
					Year yearAggregate = new Year();
					yearAggregate.displayAggregate();
					break;
				
				case "9":
					System.exit(0);
					break;
			}
			select = displayMenu();
		}
		
	}
}
